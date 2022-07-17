package com.Johnny_Carvalho_Dev.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Johnny_Carvalho_Dev.dsmeta.entities.Sale;

/*
 * @Author Johnny Carvalho
 * @Date 2022-07-17
 * 
 * Essa Interface é reponsável por acessar o banco de dados.
 * 
 * */

public interface SalesRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
	 
}
