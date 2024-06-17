package com.iflix.iflix.Controller;

import com.iflix.iflix.DTO.Request.EpisodesRequest;
import com.iflix.iflix.DTO.Response.ApiResponse;
import com.iflix.iflix.DTO.Response.EpisodesResponse;
import com.iflix.iflix.Service.EpisodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/episodes")
public class EpisodesController {
    @Autowired
    private EpisodesService episodesService;

    @PostMapping("")
    public ApiResponse<EpisodesResponse> createEpisode(@RequestBody EpisodesRequest request){

        return ApiResponse.<EpisodesResponse>builder()
                .result(episodesService.addEpisode(request))
                .build();
    }

    @GetMapping("/{movieId}")
    public Page<EpisodesResponse> getEpisodes(
            @PathVariable String movieId,
            @RequestParam(name = "field", required = false, defaultValue = "episodeNumber") String field,
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "search", required = false, defaultValue = "0") int search
    ){

        Sort sortable = null;
        if(sort.toUpperCase().equals("ASC")){
            sortable = Sort.by(field).ascending();
        }
        if(sort.toUpperCase().equals("DESC")){
            sortable = Sort.by(field).descending();
        }

        Pageable pageable = PageRequest.of(pageNumber,pageSize,sortable);
        Page<EpisodesResponse> episodes = null;
        if(search !=0){
            episodes = episodesService.getEpisodesContains(search,pageable);
        }else episodes = episodesService.getEpisodes(movieId,pageable);
        return episodes;
    }

    @GetMapping("/episode/{episodeId}")
    public ApiResponse<EpisodesResponse> getEpisode(@PathVariable String episodeId){
        return ApiResponse.<EpisodesResponse>builder()
                .result(episodesService.getById(episodeId))
                .build();
    }
    @GetMapping("/number")
    public ApiResponse<List<EpisodesResponse>> getEpisodeByNumber(
            @RequestParam(name = "episodeNumber",required = true) int episodeNumber,
            @RequestParam(name = "movieId",required = true) String movieId
    ){
        return ApiResponse.<List<EpisodesResponse>>builder()
                .result(episodesService.getByEpisodeNumber(episodeNumber,movieId))
                .build();
    }


    @PutMapping("/{episodeId}")
    public ApiResponse<EpisodesResponse> updateEpisode(@PathVariable String episodeId,@RequestBody EpisodesRequest request){
        return ApiResponse.<EpisodesResponse>builder()
                .result(episodesService.updateEpisode(episodeId,request))
                .build();
    }

    @RequestMapping(value = "/{episodeId}", method = RequestMethod.DELETE)
    public ApiResponse<String> deleteEpisode(@PathVariable String episodeId){
        episodesService.deleteEpisode(episodeId);
        return ApiResponse.<String>builder()
                .result("Episode has been deleted")
                .build();
    }

}
