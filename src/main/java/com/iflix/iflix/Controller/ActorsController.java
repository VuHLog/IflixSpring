package com.iflix.iflix.Controller;

import com.iflix.iflix.DTO.Response.ActorsResponse;
import com.iflix.iflix.DTO.Response.ApiResponse;
import com.iflix.iflix.Service.ActorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/actors")
@Slf4j
public class ActorsController {
    @Autowired
    private ActorsService actorsService;

    @GetMapping("")
    public ApiResponse<List<ActorsResponse>> getActors(
    ){
        return ApiResponse.<List<ActorsResponse>>builder()
                .result(actorsService.getActors())
                .build();
    }

    @GetMapping("/{actorId}")
    public ApiResponse<ActorsResponse> getActor(@PathVariable String actorId){
        return ApiResponse.<ActorsResponse>builder()
                .result(actorsService.getById(actorId))
                .build();
    }
}
