package com.wwegoo.service;

import java.util.List;

import com.wwegoo.entity.CategoryEntity;

public interface CategoryService {
	public CategoryEntity save(CategoryEntity category);
	
	public void delete(int categoryId);

    public CategoryEntity fetchById(int categoryId);

    public List<CategoryEntity> fetchAllCategories();
}
