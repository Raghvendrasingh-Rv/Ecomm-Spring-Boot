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

import com.ecomm.backend.Model.Product;
import com.ecomm.backend.Payload.ProductDto;
import com.ecomm.backend.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

//	@RequestMapping("/test")
//	@ResponseBody
//	public HashMap<String, String> test() {
//		HashMap<String, String> obj = new HashMap<>();
//		obj.put("Raghvendra", "23");
//		System.out.println("Testing");
//		return obj;
//	}
	@Autowired
	private ProductService productService;

//	public HomeController(ProductService productService) {
//		this.productService = productService;
//	}

	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Product>> getProduct() {
		List<Product> lt = productService.getProduct();
		return new ResponseEntity<List<Product>>(lt, HttpStatus.ACCEPTED);
	}

//Paginaation
//	@GetMapping("/getAllProduct")
//	public ProductResponse getProduct(
//			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER_STRING, required = false) int pageNumber,
//			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE_STRING, required = false) int pageSize,
//			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY_STRING, required = false) String sortBy,
//			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR_STRING, required = false) String sortDir) {
////		List<Product> lt = productService.getProduct(pageNumber, pageSize, sortBy, sortDir);
////		return new ResponseEntity<List<Product>>(lt, HttpStatus.ACCEPTED);
//
//		ProductResponse lt = productService.getProduct(pageNumber, pageSize, sortBy, sortDir);
//		return lt;
//	}

	@PostMapping("/createProduct/{categoryId}")
	@ResponseBody
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product, @PathVariable int categoryId) {
		ProductDto createPro = productService.createProduct(product, categoryId);
		return new ResponseEntity<ProductDto>(createPro, HttpStatus.CREATED);
	}

	@GetMapping("/getProductById/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product pro = productService.getProductById(id);
		return new ResponseEntity<Product>(pro, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteProductById/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable int id) {
		String res = productService.deleteProductById(id);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}

	@PutMapping("updateProduct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product newP) {
		Product updated = productService.updateProduct(id, newP);
		return new ResponseEntity<Product>(updated, HttpStatus.ACCEPTED);
	}

	// Find product category wise
	@GetMapping("/category/{catId}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable int catId) {
		List<Product> getProductByCategory = this.productService.getProductByCategory(catId);
		return new ResponseEntity<List<Product>>(getProductByCategory, HttpStatus.ACCEPTED);
	}

}
