package com.Johnny_Carvalho_Dev.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Johnny_Carvalho_Dev.dsmeta.entities.Sale;
import com.Johnny_Carvalho_Dev.dsmeta.repositories.SalesRepository;

//A anotação @Service, registra a função há ela vinculada como sendo parte do sistema
@Service
public class SaleService {
	
	@Autowired
	private SalesRepository repository;
	
	public List<Sale> findSales() {
		return repository.findAll();
		
	}

}
