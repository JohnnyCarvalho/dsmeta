package com.Johnny_Carvalho_Dev.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import com.Johnny_Carvalho_Dev.dsmeta.entities.Sale;
import com.Johnny_Carvalho_Dev.dsmeta.repositories.SalesRepository;

//A anotação @Service, registra a função há ela vinculada como sendo parte do sistema
@Service
public class SaleService {
	
	@Autowired
	private SalesRepository repository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		//Cria uma variável para armazenar o dia atual da máquina do usuário.
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		/*Transformando os dados recebidos como texto para LocalDate do Java, e
		 * fazendo teste de condição utilizando a condição ternária, ou seja
		 * se nenhum valor for informado no momento da requisição, o sistema
		 * vai retornar a lista de vendas do último mês a contar do dia atual da requisição.
		 * 
		*/
		LocalDate min = minDate.equals("") ? today.minusMonths(1) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		return repository.findSales(min, max, pageable);
		
	}

}
