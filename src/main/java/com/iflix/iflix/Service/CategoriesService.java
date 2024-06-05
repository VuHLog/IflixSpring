package com.iflix.iflix.Service;

import com.iflix.iflix.DTO.Request.CategoriesRequest;
import com.iflix.iflix.DTO.Response.CategoriesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriesService {
    public Page<CategoriesResponse> getCategories(Pageable pageable);

    public Page<CategoriesResponse> getCategoriesContains(String s,Pageable pageable);
    public CategoriesResponse getById(String id);

    public CategoriesResponse addCategories(CategoriesRequest request);

    public CategoriesResponse updateCategories(String categoriesId, CategoriesRequest request);

    public void deleteCategories(String categoriesId);
}
