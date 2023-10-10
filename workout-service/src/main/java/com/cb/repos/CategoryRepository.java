package com.cb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cb.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
