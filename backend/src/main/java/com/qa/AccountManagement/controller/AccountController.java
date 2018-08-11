package com.qa.AccountManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qa.AccountManagement.model.Accounts;
import com.qa.AccountManagement.repo.AccountRepo;

@RestController
@RequestMapping("/Accounts/")
public class AccountController {

	@Autowired
	private AccountRepo accountRepo;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Accounts> list(){
		return accountRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Accounts account) {
			accountRepo.save(account);
		
	}
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Accounts get(@PathVariable ("id") long id) {
			return accountRepo.getOne(id); 
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Accounts> updateAccount(@PathVariable(value="id") long id, @RequestBody Accounts account){
		Accounts change =accountRepo.findOne(id);
		change.setFirstName(account.getFirstName());
		change.setLastName(account.getLastName());
		change.setAccountNumber(account.getAccountNumber());
		Accounts updateAccount = accountRepo.save(change);
		return ResponseEntity.ok().body(updateAccount);
	}
	
	@DeleteMapping("/{id}")
	//@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> deleteAccount(@PathVariable ("id") long id) {
		Accounts delete =accountRepo.findOne(id);
		accountRepo.delete(delete);
		return ResponseEntity.ok().build();
	}
}
	

