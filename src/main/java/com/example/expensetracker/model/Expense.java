package com.example.expensetracker.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String description;
	
	private BigDecimal amount;

	public Expense(Long id, String description, BigDecimal amount) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
	}

	

	public Expense() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	

}
