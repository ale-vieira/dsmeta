package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;

@RestController
@RequestMapping(value = "/sales") //o valor do caminho que vai acessar
public class SaleControler {
	
	@Autowired //injeta uma instancia do SaleService
	private SaleService service;
	@Autowired
	private SmsService smsService;
	
	@GetMapping //configura o metodo para responder por http
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue= "")String minDate, 
			@RequestParam(value = "maxDate", defaultValue= "")String maxDate, 
			Pageable pageable){
		return service.findSales(minDate, maxDate, pageable);
	}
	
	@GetMapping("{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
}
