package com.wwegoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwegoo.dao.CategoryRepository;
import com.wwegoo.entity.CategoryEntity;
import com.wwegoo.exception.CategoryNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
    CategoryRepository categoryRepository;
	
	@Override
	public CategoryEntity save(CategoryEntity category)  {
		 return categoryRepository.save(category);
	}

	@Override
	public void delete(int categoryId) throws CategoryNotFoundException {
		CategoryEntity category = this.fetchById(categoryId);
		this.categoryRepository.deleteById(category.getId());
	}

	@Override
	public CategoryEntity fetchById(int categoryId) throws CategoryNotFoundException {
		Optional<CategoryEntity> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            return category.get();
        } else {
            throw new CategoryNotFoundException("The category not found.");
        }
	}

	@Override
	public List<CategoryEntity> fetchAllCategories() {
		 return categoryRepository.findAll();
	}

}
