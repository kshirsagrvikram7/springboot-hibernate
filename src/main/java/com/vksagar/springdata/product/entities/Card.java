package com.vksagar.springdata.product.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Card extends Payment {

	@Column(name="cardnumber")
	private String cardNumber;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

}
