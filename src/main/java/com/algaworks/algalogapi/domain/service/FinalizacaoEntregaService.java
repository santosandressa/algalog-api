package com.algaworks.algalogapi.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algalogapi.domain.model.Entrega;
import com.algaworks.algalogapi.domain.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {
	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@Transactional
	public void finalizar(Long entrgaId) {
		Entrega entrega = buscaEntregaService.buscar(entrgaId);
		
		entrega.finalizar();

		entregaRepository.save(entrega);
	}
	
}
