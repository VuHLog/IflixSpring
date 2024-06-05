package com.iflix.iflix.Controller;

import com.iflix.iflix.DTO.Request.CategoriesRequest;
import com.iflix.iflix.DTO.Response.ApiResponse;
import com.iflix.iflix.DTO.Response.CategoriesResponse;
import com.iflix.iflix.Service.CategoriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/categories")
@Slf4j
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @PostMapping("")
    public ApiResponse<CategoriesResponse> createCategories(@RequestBody CategoriesRequest request){

        return ApiResponse.<CategoriesResponse>builder()
                .result(categoriesService.addCategories(request))
        .build();
    }

    @GetMapping("")
    public Page<CategoriesResponse> getCategories(
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
        Page<CategoriesResponse> categories = null;
        if(!search.trim().equals("")){
            categories = categoriesService.getCategoriesContains(search,pageable);
        }else categories = categoriesService.getCategories(pageable);
        return categories;
    }

    @GetMapping("/{categoriesId}")
    public ApiResponse<CategoriesResponse> getCategories(@PathVariable String categoriesId){
        return ApiResponse.<CategoriesResponse>builder()
                .result(categoriesService.getById(categoriesId))
                .build();
    }

    @PutMapping("/{categoriesId}")
    public ApiResponse<CategoriesResponse> updateCategories(@PathVariable String categoriesId,@RequestBody CategoriesRequest request){
        return ApiResponse.<CategoriesResponse>builder()
                .result(categoriesService.updateCategories(categoriesId,request))
                .build();
    }

    @RequestMapping(value = "/{categoriesId}", method = RequestMethod.DELETE)
    public ApiResponse<String> deleteCategories(@PathVariable String categoriesId){
        categoriesService.deleteCategories(categoriesId);
        return ApiResponse.<String>builder()
                .result("Categories has been deleted")
                .build();
    }
}
