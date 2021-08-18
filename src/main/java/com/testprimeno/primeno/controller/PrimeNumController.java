package com.testprimeno.primeno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testprimeno.primeno.service.PrimeNumService;

@RestController
@RequestMapping(path="primeNumbers")
public class PrimeNumController {
	
	@Autowired
	private PrimeNumService primeNumService;
	
	@GetMapping("/{lastNumber}")
	public ResponseEntity<Object> getPrimeNumbers(@PathVariable int lastNumber) {
		if(lastNumber < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(primeNumService.getPrimeNums(lastNumber));
	}
}
