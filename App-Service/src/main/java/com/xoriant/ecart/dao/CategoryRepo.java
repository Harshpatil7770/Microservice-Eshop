package com.xoriant.ecart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.ecart.model.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
