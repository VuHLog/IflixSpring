package com.iflix.iflix.Controller;

import com.iflix.iflix.DTO.Request.CountriesRequest;
import com.iflix.iflix.DTO.Response.ApiResponse;
import com.iflix.iflix.DTO.Response.CountriesResponse;
import com.iflix.iflix.Service.CountriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/countries")
@Slf4j
public class CountriesController {
    @Autowired
    private CountriesService countriesService;

    @PostMapping("")
    public ApiResponse<CountriesResponse> createCountries(@RequestBody CountriesRequest request){

        return ApiResponse.<CountriesResponse>builder()
                .result(countriesService.addCountries(request))
        .build();
    }

    @GetMapping("")
    public Page<CountriesResponse> getCountries(
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
        Page<CountriesResponse> countries = null;
        if(!search.trim().equals("")){
            countries = countriesService.getCountriesContains(search,pageable);
        }else countries = countriesService.getCountries(pageable);
        return countries;
    }

    @GetMapping("/{countriesId}")
    public ApiResponse<CountriesResponse> getCountries(@PathVariable String countriesId){
        return ApiResponse.<CountriesResponse>builder()
                .result(countriesService.getById(countriesId))
                .build();
    }

    @PutMapping("/{countriesId}")
    public ApiResponse<CountriesResponse> updateCountries(@PathVariable String countriesId,@RequestBody CountriesRequest request){
        return ApiResponse.<CountriesResponse>builder()
                .result(countriesService.updateCountries(countriesId,request))
                .build();
    }

    @RequestMapping(value = "/{countriesId}", method = RequestMethod.DELETE)
    public ApiResponse<String> deleteCountries(@PathVariable String countriesId){
        countriesService.deleteCountries(countriesId);
        return ApiResponse.<String>builder()
                .result("Countries has been deleted")
                .build();
    }
}
