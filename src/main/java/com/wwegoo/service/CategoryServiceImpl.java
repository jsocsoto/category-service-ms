package com.wwegoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwegoo.dao.CategoryRepository;
import com.wwegoo.entity.CategoryEntity;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
    CategoryRepository categoryRepository;
	
	@Override
	public CategoryEntity save(CategoryEntity category) {
		 return categoryRepository.save(category);
	}

	@Override
	public void delete(int categoryId) {
		 this.categoryRepository.deleteById(categoryId);
	}

	@Override
	public CategoryEntity fetchById(int categoryId) {
		Optional<CategoryEntity> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            return category.get();
        } else {
            return null;
        }
	}

	@Override
	public List<CategoryEntity> fetchAllCategories() {
		 return categoryRepository.findAll();
	}

}
