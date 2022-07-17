package com.Johnny_Carvalho_Dev.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Johnny_Carvalho_Dev.dsmeta.entities.Sale;
import com.Johnny_Carvalho_Dev.dsmeta.services.SaleService;

/*
 * @Author Johnny Carvalho
 * @Date 2022-07-17
 * 
 * Essa função é resposnsável por buscar no back end os dados de venda
 * e disponibilizá-las no front end, estamo usando aqui o padrão de 
 * 3 camadas, ou seja, o controller depende do service que depende do repository
 * como lá na classe SalesService nós chamamos o Sales Repository, aqui nós
 * vamos chamar o Sales Service.
 * */

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	/*
	 * A anotação @GetMapping serve para fazer a nossa função
	 * findSales() resposnder em forma de http que é o protocolo
	 * da WEB, tendo em vista que ele vai conversar diretamente 
	 * com nosso front end.
	 * */
	@GetMapping
	public List<Sale> findSales() {
		return service.findSales();
	}
}
