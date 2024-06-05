package com.iflix.iflix.Service.ServiceImpl;

import com.iflix.iflix.DAO.CountriesRepository;
import com.iflix.iflix.DTO.Request.CountriesRequest;
import com.iflix.iflix.DTO.Response.CountriesResponse;
import com.iflix.iflix.Entities.Countries;
import com.iflix.iflix.Mapper.CountriesMapper;
import com.iflix.iflix.Service.CountriesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountriesServiceImpl implements CountriesService {

    @Autowired
    private CountriesRepository countriesRepository;

    @Autowired
    private CountriesMapper countriesMapper;

    @Override
    public CountriesResponse getById(String id) {
        return countriesMapper.toCountriesResponse(countriesRepository.findById(id).get());
    }

    @Override
    public CountriesResponse addCountries(CountriesRequest request) {
        Countries countries = countriesMapper.toCountries(request);

        return countriesMapper.toCountriesResponse(countriesRepository.save(countries));
    }

    @Override
    public Page<CountriesResponse> getCountries(Pageable pageable) {
        return countriesRepository.findAll(pageable).map(countriesMapper::toCountriesResponse);
    }

    @Override
    public Page<CountriesResponse> getCountriesContains(String s, Pageable pageable) {
        return countriesRepository.findByNameContainsIgnoreCase(s, pageable).map(countriesMapper::toCountriesResponse);
    }

    @Override
    @Transactional
    public CountriesResponse updateCountries(String countriesId, CountriesRequest request) {
        Countries countries = countriesRepository.findById(countriesId).get();
        countriesMapper.updateCountries(countries, request);

        return countriesMapper.toCountriesResponse(countriesRepository.saveAndFlush(countries));
    }

    @Override
    public void deleteCountries(String countriesId) {
        countriesRepository.deleteById(countriesId);
    }
}
