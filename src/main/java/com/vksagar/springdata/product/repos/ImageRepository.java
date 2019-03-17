package com.vksagar.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.vksagar.springdata.product.entities.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
