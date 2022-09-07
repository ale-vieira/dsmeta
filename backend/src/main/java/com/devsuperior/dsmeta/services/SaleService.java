package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

//operação que busca no banco de dados as vendas

//Registra o SaleService como sendo um componente do sistema
@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	// busca a lista de vendas pelo tipo do objeto Sale
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		//busca a data atual / fuso horário do sistema
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		//converte a data de string para formato data
		// testa se a data minima for vazia coloca a data de 1 ano atras
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		// testa se a data maxima for vazia, se sim usa data atual, se não, converte para data do local date
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		// busca todas as vendas no banco de dados
		return repository.findSales(min, max, pageable);
	}
}
