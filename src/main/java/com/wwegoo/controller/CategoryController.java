package com.wwegoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wwegoo.entity.CategoryEntity;
import com.wwegoo.service.CategoryService;

@RestController
@RequestMapping(value = "/services")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	@PreAuthorize("hasPermission(#category, 'CREATE_CATEGORY')")
	public ResponseEntity<CategoryEntity> save(@RequestBody CategoryEntity category) {
		return new ResponseEntity<CategoryEntity>(categoryService.save(category),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/category", method = RequestMethod.PUT)
	@PreAuthorize("hasPermission(#category, 'UPDATE_CATEGORY')")
	public ResponseEntity<CategoryEntity> update(@RequestBody CategoryEntity category) {
		return new ResponseEntity<CategoryEntity>(categoryService.save(category),HttpStatus.OK);
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasPermission(#category, 'READ_CATEGORY')")
	public ResponseEntity<CategoryEntity> fetch(@PathVariable("id") Integer id) {
		return new ResponseEntity<CategoryEntity>(categoryService.fetchById(id),HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasPermission(#category, 'DELETE_CATEGORY')")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
		categoryService.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE,HttpStatus.OK); 
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	@PreAuthorize("hasPermission(#category, 'READ_CATEGORY')")
	public ResponseEntity<List<CategoryEntity>> fetch() {
		return new ResponseEntity<List<CategoryEntity>>(categoryService.fetchAllCategories(),HttpStatus.OK);
	}
}
