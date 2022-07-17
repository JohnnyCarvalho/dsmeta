package com.Johnny_Carvalho_Dev.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Johnny_Carvalho_Dev.dsmeta.entities.Sale;
import com.Johnny_Carvalho_Dev.dsmeta.services.SaleService;
import com.Johnny_Carvalho_Dev.dsmeta.services.SmsService;

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
	
	@Autowired
	private SmsService smsService;
	
	/*
	 * A anotação @GetMapping serve para fazer a nossa função
	 * findSales() resposnder em forma de http que é o protocolo
	 * da WEB, tendo em vista que ele vai conversar diretamente 
	 * com nosso front end.
	 * */
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			Pageable pageable) {
		return service.findSales(minDate, maxDate, pageable);
	}
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
}
