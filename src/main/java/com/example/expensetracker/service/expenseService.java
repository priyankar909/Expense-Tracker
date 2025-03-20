package com.example.expensetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;

@Service
public class expenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public List<Expense> getAllExpense(){
		return expenseRepository.findAll();
		
	}
	public void saveExpense(Expense expense) {
		expenseRepository.save(expense);
	}
	public Expense getExpensebyId(Long id) {
		return expenseRepository.findById(id).orElse(null);
	}
	public void deleteExpensebyId(Long id) {
		expenseRepository.deleteById(id);
		
	}

}
