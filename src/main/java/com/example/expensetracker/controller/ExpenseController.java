package com.example.expensetracker.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.expenseService;


@Controller
public class ExpenseController {
	@Autowired
	private expenseService expenseService;
	
	
	@GetMapping("/")
	public  String viewHomePage(Model model) {
		List<Expense> expenses=expenseService.getAllExpense();
		BigDecimal totalAmount = expenses.stream()
			    .map(Expense::getAmount)
			    .reduce(BigDecimal.ZERO, BigDecimal::add);
		model.addAttribute("expenses", expenses); // Add list of expenses
		model.addAttribute("totalAmount", totalAmount); // Add total amount
		return "index";


	}
	  @GetMapping("/addExpense")
	    public String showAddExpensePage(Model model) {
	        Expense expense = new Expense();
	        model.addAttribute("expense", expense);
	        return "add-expense";
	    }
	@PostMapping("/saveExpense")
	public String saveEpense(@ModelAttribute Expense expense,Model model) {
		expenseService.saveExpense(expense);
		return "redirect:/";
	}
	@GetMapping("/editExpense/{id}")
	public String showUpdatedEpense(@PathVariable("id") long id,Model model) {
		Expense expense=expenseService.getExpensebyId(id);
		model.addAttribute("expense",expense);
		return "update-expense";
	}
		
	

    @PostMapping("/updateExpense/{id}")
    public String updateExpense(@PathVariable("id") long id, @ModelAttribute("expense") Expense expense, Model model) {
        Expense existingExpense = expenseService.getExpensebyId(id);
        existingExpense.setDescription(expense.getDescription());
        existingExpense.setAmount(expense.getAmount());
        expenseService.saveExpense(existingExpense);
        return "redirect:/";
    }

    @GetMapping("/deleteExpense/{id}")
    public String deleteExpense(@PathVariable("id") long id) {
        expenseService.deleteExpensebyId(id);
        return "redirect:/";
    }
}
