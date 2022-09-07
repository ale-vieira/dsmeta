package com.devsuperior.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Sale> findSales() {
		// busca todas as vendas no banco de dados
		return repository.findAll();
	}
}
