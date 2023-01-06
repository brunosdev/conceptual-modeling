package com.brunosanttos.mc.domain;

import com.brunosanttos.mc.domain.enums.PaymentStatus;

import jakarta.persistence.Entity;

@Entity
public class PaymentCard extends Payment{	
	private static final long serialVersionUID = 1L;
	
	private Integer numberOfInstallments;
	
	public PaymentCard() {
		
	}

	public PaymentCard(Integer id, PaymentStatus status, Order order, Integer numberOfInstallments) {
		super(id, status, order);
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}


	
	
}
