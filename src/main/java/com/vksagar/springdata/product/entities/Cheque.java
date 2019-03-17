package com.vksagar.springdata.product.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cheque extends Payment {

	@Column(name="chequenumber")
	private String chequeNumber;

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

}
