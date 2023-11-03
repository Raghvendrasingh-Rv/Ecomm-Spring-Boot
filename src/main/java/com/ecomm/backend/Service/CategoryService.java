package com.ecomm.backend.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.backend.Model.Category;
import com.ecomm.backend.Payload.CategoryDto;
import com.ecomm.backend.Repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	public ModelMapper mapper;

	public CategoryDto createCategory(CategoryDto dto) {

		Category newCat = this.mapper.map(dto, Category.class);
		Category save = categoryRepository.save(newCat);
		CategoryDto newDto = this.mapper.map(save, CategoryDto.class);
		return newDto;
	}

	public CategoryDto updateCategory(int categoryId, CategoryDto newCat) {
		Category oldCat = categoryRepository.findById(categoryId);
//		oldCat.setCategoryId(newCat.getCategoryId());
		oldCat.setTitle(newCat.getTitle());
		Category save = categoryRepository.save(oldCat);
		return this.mapper.map(save, CategoryDto.class);
	}

	public String deleteCategory(Integer CategoryId) {
		categoryRepository.deleteById(CategoryId);
		return "Deleted Successfully";
	}

	public CategoryDto getById(int categoryId) {
		Category cat = categoryRepository.findById(categoryId);
		return this.mapper.map(cat, CategoryDto.class);
	}

	public List<CategoryDto> getAll() {
		List<Category> lt = categoryRepository.findAll();
		List<CategoryDto> ltDto = new ArrayList<>();
//		List<CategoryDto> ltDto = (List<CategoryDto>) lt.stream().map(cat -> this.mapper.map(cat, CategoryDto.class));
		for (Category item : lt) {
			CategoryDto dto = this.mapper.map(item, CategoryDto.class);
			ltDto.add(dto);
		}
		return ltDto;
	}

//	public CategoryDto toDto(Category c) {
//		CategoryDto cDto = new CategoryDto();
//		cDto.setCategoryId(c.getCategoryId());
//		cDto.setTitle(c.getTitle());
//		return cDto;
//	}
//
//	public Category toEntity(CategoryDto cDto) {
//		Category c = new Category();
//		cDto.setCategoryId(c.getCategoryId());
//		cDto.setTitle(c.getTitle());
//		return c;
//	}

}
