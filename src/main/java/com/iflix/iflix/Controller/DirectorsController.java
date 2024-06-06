package com.iflix.iflix.Controller;

import com.iflix.iflix.DTO.Response.ApiResponse;
import com.iflix.iflix.DTO.Response.DirectorsResponse;
import com.iflix.iflix.Service.DirectorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/directors")
@Slf4j
public class DirectorsController {
    @Autowired
    private DirectorsService directorsService;

    @GetMapping("")
    public ApiResponse<List<DirectorsResponse>> getDirectors(
    ){
        return ApiResponse.<List<DirectorsResponse>>builder()
                .result(directorsService.getDirectors())
                .build();
    }

    @GetMapping("/{directorId}")
    public ApiResponse<DirectorsResponse> getDirector(@PathVariable String directorId){
        return ApiResponse.<DirectorsResponse>builder()
                .result(directorsService.getById(directorId))
                .build();
    }
}
