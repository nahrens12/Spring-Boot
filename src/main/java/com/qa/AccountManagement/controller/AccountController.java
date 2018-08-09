package com.qa.AccountManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qa.AccountManagement.model.Accounts;
import com.qa.AccountManagement.repo.AccountRepo;

@RestController
@RequestMapping("/Accounts")
public class AccountController {

	@Autowired
	private AccountRepo accountRepo;
	
	@GetMapping
	public List<Accounts> list(){
		return accountRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Accounts account) {
			accountRepo.save(account);
		
	}
	@GetMapping("/{id}")
	public Accounts get(@PathVariable ("id") long id) {
			return accountRepo.getOne(id); 
	}
	
}
	

