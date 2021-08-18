package com.testprimeno.primeno.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.testprimeno.primeno.model.PrimeResponse;

@Service
public class PrimeNumServiceImpl implements PrimeNumService{
	public PrimeResponse getPrimeNums(int lastNumber) {
		PrimeResponse response = new PrimeResponse();
		Map<Integer, String> allNumMap = getAllNumMap(lastNumber);
		for(Integer consecuNum : allNumMap.keySet()) {
			removeNonPrime(consecuNum, allNumMap);
		}
		List<Integer> primeNums = allNumMap.entrySet().stream().filter(pn->pn.getValue().equalsIgnoreCase("Y")).map(im->im.getKey()).collect(Collectors.toList());
		
		response.setTotal(primeNums.size());
		response.setPrimeNumbers(primeNums);
		return response;
	}
	
	private Map<Integer, String> getAllNumMap(int lastNumber) {
		Map<Integer, String> allNumMap = new HashMap<>();
		for(int i = 2; i <= lastNumber; i++) {
			allNumMap.put(i, "Y");
		}
		return allNumMap;
	}
	
	private void removeNonPrime(int consecuNum, Map<Integer, String> primeMap) {
		int counter = 0;
		for(Map.Entry<Integer, String> ent: primeMap.entrySet()) {
			if(ent.getKey() > consecuNum) {
				counter++;
				if(counter == consecuNum) {
					primeMap.put(ent.getKey(), "N");
					counter = 0;
				}
			}
		}
	}
}
