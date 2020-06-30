package com.indbank.indbankrestfulwebservices.controller;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.indbank.indbankrestfulwebservices.entities.Account;
import com.indbank.indbankrestfulwebservices.entities.WelcomeBean;
import com.indbank.indbankrestfulwebservices.service.AccountHardcodedService;

@RestController("/")
//@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

	@Autowired
	private AccountHardcodedService hardcodedService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello!";
	}

	@GetMapping("/welcome")
	public WelcomeBean welcome() {
		return new WelcomeBean("Hello World!!");
	}

	@GetMapping("/welcomePathVariable/{name}")
	public WelcomeBean welcomePathVariable(@PathVariable String name) {
		return new WelcomeBean("Hello World!! " + name);
	}

	@GetMapping("/account")
	public Account accountDetails() {
		int id = 101;
		String accountNumber = "123";
		int balance = 123;
		String description = "Dummy Description";
		String note = "Dummy Note";
		boolean select = false;
		Date openingDate = new Date();
		String mobile = "+919826396465";
		String email = "pushkarchauhan91@gmail.com";
		return new Account(id, accountNumber, balance, description, note, select, openingDate, mobile, email);
	}

	@GetMapping("/account/path-variable/{name}")
	public Account accountDetailsPathVariable(@PathVariable String name) {
		int id = 101;
		String accountNumber = "123";
		int balance = 123;
		String description = String.format("Hello %s", name);
		String note = "Dummy Note";
		boolean select = false;
		Date openingDate = new Date();
		String mobile = "+919826396465";
		String email = "pushkarchauhan91@gmail.com";
		return new Account(id, accountNumber, balance, description, note, select, openingDate, mobile, email);
	}

	@GetMapping("/users/{username}/account")
	public List<Account> getAllAccounts(@PathVariable String username) {
		return hardcodedService.findAll();
	}

	@GetMapping("/users/{username}/account/{id}")
	public Account getAllAccounts(@PathVariable String username, @PathVariable long id) {
		return hardcodedService.findById(id);
	}

	@DeleteMapping("/users/{username}/account/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable String username, @PathVariable long id) {
		Account account = hardcodedService.deleteById(id);
		if (account != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/users/{username}/account/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable String username, @PathVariable long id,
			@RequestBody Account account) {
		Account updatedAccount = hardcodedService.save(account);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	@PostMapping("/users/{username}/account")
	public Account createAccount(@PathVariable String username, @RequestBody Account account) {
		Account createdAccount = hardcodedService.save(account);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
				.buildAndExpand(createdAccount.getId()).toUri();
		return createdAccount;
	}
	
	
}
