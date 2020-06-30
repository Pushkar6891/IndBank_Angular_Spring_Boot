package com.indbank.indbankrestfulwebservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.indbank.indbankrestfulwebservices.entities.Register;

@Service
public class RegisterService {

	private static List<Register> registers = new ArrayList<>();
	private static int idCounter = 0;

	static {
		registers.add(new Register(++idCounter, "defaultUsername", "defaultPassword", "defaultConfirmPassword", "defaultMobile", "defaultEmail"));
	}

	public List<Register> findAll() {
		return registers;
	}

	public Register save(Register register) {
		register.setId(++idCounter);
		registers.add(register);
		return register;
	}
}
