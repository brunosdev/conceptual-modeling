package com.brunosanttos.mc.domain;

import java.util.Date;

import com.brunosanttos.mc.domain.enums.PaymentStatus;

import jakarta.persistence.Entity;

@Entity
public class PaymentSlip extends Payment{
	private static final long serialVersionUID = 1L;
	
	private Date dueDate;
	private Date payDay;
	
	public PaymentSlip() {
		
	}

	public PaymentSlip(Integer id, PaymentStatus status, Order order, Date dueDate, Date payDay) {
		super(id, status, order);
		this.dueDate = dueDate;
		this.payDay = payDay;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPayDay() {
		return payDay;
	}

	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}
}
