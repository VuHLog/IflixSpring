package com.iflix.iflix.Service;

import com.iflix.iflix.DTO.Request.CountriesRequest;
import com.iflix.iflix.DTO.Response.CountriesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountriesService {
    public Page<CountriesResponse> getCountries(Pageable pageable);

    public Page<CountriesResponse> getCountriesContains(String s,Pageable pageable);
    public CountriesResponse getById(String id);

    public CountriesResponse addCountries(CountriesRequest request);

    public CountriesResponse updateCountries(String countriesId, CountriesRequest request);

    public void deleteCountries(String countriesId);
}
