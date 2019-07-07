package com.wwegoo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wwegoo.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {

}
