package com.vksagar.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.vksagar.springdata.product.entities.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {

}
