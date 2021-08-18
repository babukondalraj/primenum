package com.testprimeno.primeno.model;

import java.util.List;

import lombok.Data;

@Data
public class PrimeResponse {
	private int total;
	private List<Integer> primeNumbers;
}
