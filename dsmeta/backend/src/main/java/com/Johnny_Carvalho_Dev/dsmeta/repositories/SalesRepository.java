package com.Johnny_Carvalho_Dev.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Johnny_Carvalho_Dev.dsmeta.entities.Sale;

/*
 * @Author Johnny Carvalho
 * @Date 2022-07-17
 * 
 * Essa Interface é reponsável por acessar o banco de dados.
 * 
 * */

public interface SalesRepository extends JpaRepository<Sale, Long>{
	 
}
