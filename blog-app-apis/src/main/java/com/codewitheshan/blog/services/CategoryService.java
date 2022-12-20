package com.codewitheshan.blog.services;

import java.util.List;

import com.codewitheshan.blog.payloads.CategoryDto;
// interface concept is used for loose coupling 
public interface CategoryService {

	// create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	// update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	// delete
	public void deleteCategory(Integer categoryId);
	
	// get 
	CategoryDto getCategory(Integer categoryId);
	
	//	get all 
	List<CategoryDto> getCategories();
}
