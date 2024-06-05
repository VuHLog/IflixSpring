package com.iflix.iflix.Mapper;

import com.iflix.iflix.DTO.Request.CategoriesRequest;
import com.iflix.iflix.DTO.Response.CategoriesResponse;
import com.iflix.iflix.Entities.Categories;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoriesMapper {

    Categories toCategories(CategoriesRequest request);

    CategoriesResponse toCategoriesResponse(Categories categories);

    void updateCategories(@MappingTarget Categories categories, CategoriesRequest request);
}
