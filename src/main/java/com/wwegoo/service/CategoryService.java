package com.wwegoo.service;

import java.util.List;

import com.wwegoo.entity.CategoryEntity;
import com.wwegoo.exception.CategoryNotFoundException;

public interface CategoryService {
	public CategoryEntity save(CategoryEntity category);
	
	public void delete(int categoryId) throws CategoryNotFoundException ;

    public CategoryEntity fetchById(int categoryId) throws CategoryNotFoundException;

    public List<CategoryEntity> fetchAllCategories();
}
