package com.vksagar.springdata.product.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.vksagar.springdata.product.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

	List<Product> findByName(String name);
	
	List<Product> findByNameAndDesc1(String name, String desc1);
	
	List<Product> findByPriceGreaterThan(Double price);
	
	List<Product> findByDesc1Contains(String desc1);
	
	List<Product> findByPriceBetween(Double price1, Double price2);
	
	List<Product> findByDesc1Like(String desc1);
	
	//JPQL
	
	@Query("from Product")
	List<Product> findAllProducts();
	
	@Query("select p.name, p.desc1 from Product p")
	List<Object[]> findAllProductsPartialData();
	
	@Query("from Product where name=:name")
	List<Product> findAllProductsByName(@Param("name") String name);
	
	@Modifying
	@Query("delete from Product where name=:name")
	void deleteProductByName(@Param("name") String name);
	
	
	//Native Query
	
	@Query(value="select * from Product", nativeQuery=true)
	List<Product> findAllProductsNQ();
	
	
	@Query(value="select * from Product where name=:name", nativeQuery=true)
	List<Product> findProductsByNameNQ(@Param("name") String name);
}


