package com.iflix.iflix.Mapper;

import com.iflix.iflix.DTO.Request.CountriesRequest;
import com.iflix.iflix.DTO.Response.CountriesResponse;
import com.iflix.iflix.Entities.Countries;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CountriesMapper {

    Countries toCountries(CountriesRequest request);

    CountriesResponse toCountriesResponse(Countries countries);

    void updateCountries(@MappingTarget Countries countries, CountriesRequest request);
}
