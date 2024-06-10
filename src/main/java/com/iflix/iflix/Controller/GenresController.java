package com.iflix.iflix.Controller;

import com.iflix.iflix.DTO.Request.GenresRequest;
import com.iflix.iflix.DTO.Response.ApiResponse;
import com.iflix.iflix.DTO.Response.GenresResponse;
import com.iflix.iflix.Service.GenresService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/genres")
@Slf4j
public class GenresController {
    @Autowired
    private GenresService genresService;

    @PostMapping("")
    public ApiResponse<GenresResponse> createGenres(@RequestBody GenresRequest request){

        return ApiResponse.<GenresResponse>builder()
                .result(genresService.addGenres(request))
        .build();
    }

    @GetMapping("")
    public Page<GenresResponse> getGenres(
            @RequestParam(name = "field", required = false, defaultValue = "id") String field,
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "search", required = false, defaultValue = "") String search
    ){
        Sort sortable = null;
        if(sort.toUpperCase().equals("ASC")){
            sortable = Sort.by(field).ascending();
        }
        if(sort.toUpperCase().equals("DESC")){
            sortable = Sort.by(field).descending();
        }

        Pageable pageable = PageRequest.of(pageNumber,pageSize,sortable);
        Page<GenresResponse> genres = null;
        if(!search.trim().equals("")){
            genres = genresService.getGenresContains(search,pageable);
        }else genres = genresService.getGenres(pageable);
        return genres;
    }

    @GetMapping("/{genresId}")
    public ApiResponse<GenresResponse> getGenres(@PathVariable String genresId){
        return ApiResponse.<GenresResponse>builder()
                .result(genresService.getById(genresId))
                .build();
    }

    @PutMapping("/{genresId}")
    public ApiResponse<GenresResponse> updateGenres(@PathVariable String genresId,@RequestBody GenresRequest request){
        return ApiResponse.<GenresResponse>builder()
                .result(genresService.updateGenres(genresId,request))
                .build();
    }

    @RequestMapping(value = "/{genresId}", method = RequestMethod.DELETE)
    public ApiResponse<String> deleteGenres(@PathVariable String genresId){
        genresService.deleteGenres(genresId);
        return ApiResponse.<String>builder()
                .result("Genres has been deleted")
                .build();
    }
}
