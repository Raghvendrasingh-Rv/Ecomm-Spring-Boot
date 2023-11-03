package com.ecomm.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.backend.Payload.CategoryDto;
import com.ecomm.backend.Service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/createCategory")
	@ResponseBody
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
		CategoryDto newCategory = categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(newCategory, HttpStatus.CREATED);
	}

	@PutMapping("/updateCategory/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable int categoryId,
			@RequestBody CategoryDto categoryDto) {
		CategoryDto updated = categoryService.updateCategory(categoryId, categoryDto);
		return new ResponseEntity<CategoryDto>(updated, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteCategory/{categoryId}")
	public ResponseEntity<String> delete(@PathVariable Integer categoryId) {
		String del = categoryService.deleteCategory(categoryId);
		return new ResponseEntity<String>(del, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getById/{categoryId}")
	public ResponseEntity<CategoryDto> getById(@PathVariable int categoryId) {
		CategoryDto get = categoryService.getById(categoryId);
		return new ResponseEntity<CategoryDto>(get, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAllCategory")
	public ResponseEntity<List<CategoryDto>> getAll() {
		List<CategoryDto> lt = categoryService.getAll();
		return new ResponseEntity<List<CategoryDto>>(lt, HttpStatus.ACCEPTED);
	}

}
