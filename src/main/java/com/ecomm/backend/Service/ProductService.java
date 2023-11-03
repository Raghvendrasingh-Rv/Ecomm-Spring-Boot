package com.ecomm.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecomm.backend.Model.Category;
import com.ecomm.backend.Model.Product;
import com.ecomm.backend.Payload.ProductDto;
import com.ecomm.backend.Repository.CategoryRepository;
import com.ecomm.backend.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
//
//	public ProductService(ProductRepository productRepository) {
//		this.productRepository = productRepository;
//	}

	public List<Product> getProduct() {
		List<Product> lt = productRepository.findAll();
		return lt;
	}

	// Pagination
//	public ProductResponse getProduct(int pageNumber, int PageSize, String sortBy, String sortDir) {
//		Sort sort = null;
//		if (sortDir.trim().toLowerCase().equals("asc")) {
//			sort = Sort.by(sortBy).ascending();
//			System.out.println(sort);
//		} else {
//			sort = Sort.by(sortBy).descending();
//			System.out.println(sort);
//		}
//
//		Pageable pageable = PageRequest.of(pageNumber, PageSize, sort);
//		Page<Product> page = this.productRepository.findAll(pageable);
//		List<Product> pageProduct = page.getContent();
//		List<Product> product = pageProduct.stream().filter(p -> p.isLive()).collect(Collectors.toList());
//		List<ProductDto> productDto = product.stream().map(p -> this.toDto(p)).collect(Collectors.toList());
//
//		ProductResponse response = new ProductResponse();
//		response.setContent(productDto);
//		response.setPageNumber(page.getNumber());
//		response.setPageSize(page.getSize());
//		response.setTotalPages(page.getTotalPages());
//		response.setLastPage(page.isLast());
//
////		List<Product> lt = productRepository.findAll();
//		return response;
//	}

	public ProductDto createProduct(ProductDto product, int categoryId) {
		Category category = categoryRepository.findById(categoryId);
		Product entity = toEntity(product);
		entity.setCategory(category);
		Product save = productRepository.save(entity);
		ProductDto dto = toDto(save);
		return dto;
	}

	public Product getProductById(int id) {
		return productRepository.findById(id);
	}

	public String deleteProductById(int id) {
		productRepository.deleteById(id);
		return "Deleted successfully";
	}

	public Product updateProduct(int id, Product newP) {
		Product oldP = productRepository.findById(id);
//		oldP.setProduct_id(newP.getProduct_id());
		oldP.setProduct_name(newP.getProduct_name());
		oldP.setProduct_prize(newP.getProduct_prize());
		oldP.setProduct_desc(newP.getProduct_desc());
		oldP.setProduct_quantity(newP.getProduct_quantity());
		oldP.setProduct_imageName(newP.getProduct_imageName());
		oldP.setStock(newP.isStock());
		oldP.setLive(newP.isLive());
		Product save = productRepository.save(oldP);
		return save;
	}

	public Product toEntity(ProductDto pDto) {
		Product p = new Product();
		p.setProduct_id(pDto.getProduct_id());
		p.setProduct_name(pDto.getProduct_name());
		p.setProduct_prize(pDto.getProduct_prize());
		p.setProduct_desc(pDto.getProduct_desc());
		p.setProduct_quantity(pDto.getProduct_quantity());
		p.setProduct_imageName(pDto.getProduct_imageName());
		p.setLive(pDto.isLive());
		p.setStock(pDto.isStock());
		return p;
	}

	public ProductDto toDto(Product p) {
		ProductDto pDto = new ProductDto();
		pDto.setProduct_id(p.getProduct_id());
		pDto.setProduct_name(p.getProduct_name());
		pDto.setProduct_prize(p.getProduct_prize());
		pDto.setProduct_desc(p.getProduct_desc());
		pDto.setProduct_quantity(p.getProduct_quantity());
		pDto.setProduct_imageName(p.getProduct_imageName());
		pDto.setLive(p.isLive());
		pDto.setStock(p.isStock());
		return pDto;
	}

	public List<Product> getProductByCategory(@PathVariable int catId) {
		Category category = this.categoryRepository.findById(catId);
		List<Product> findByCategory = this.productRepository.findByCategory(category);
		return findByCategory;
	}
}
