package com.iflix.iflix.Service.ServiceImpl;

import com.iflix.iflix.DAO.CategoriesRepository;
import com.iflix.iflix.DTO.Request.CategoriesRequest;
import com.iflix.iflix.DTO.Response.CategoriesResponse;
import com.iflix.iflix.Entities.Categories;
import com.iflix.iflix.Mapper.CategoriesMapper;
import com.iflix.iflix.Service.CategoriesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private CategoriesMapper categoriesMapper;

    @Override
    public CategoriesResponse getById(String id) {
        return categoriesMapper.toCategoriesResponse(categoriesRepository.findById(id).get());
    }

    @Override
    public CategoriesResponse addCategories(CategoriesRequest request) {
        Categories categories = categoriesMapper.toCategories(request);

        return categoriesMapper.toCategoriesResponse(categoriesRepository.save(categories));
    }

    @Override
    public Page<CategoriesResponse> getCategories(Pageable pageable) {
        return categoriesRepository.findAll(pageable).map(categoriesMapper::toCategoriesResponse);
    }

    @Override
    public Page<CategoriesResponse> getCategoriesContains(String s, Pageable pageable) {
        return categoriesRepository.findByNameContainsIgnoreCase(s, pageable).map(categoriesMapper::toCategoriesResponse);
    }

    @Override
    @Transactional
    public CategoriesResponse updateCategories(String categoriesId, CategoriesRequest request) {
        Categories categories = categoriesRepository.findById(categoriesId).get();
        categoriesMapper.updateCategories(categories, request);

        return categoriesMapper.toCategoriesResponse(categoriesRepository.saveAndFlush(categories));
    }

    @Override
    public void deleteCategories(String categoriesId) {
        categoriesRepository.deleteById(categoriesId);
    }
}
