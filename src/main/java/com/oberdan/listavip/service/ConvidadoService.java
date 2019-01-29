package com.oberdan.listavip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oberdan.listavip.model.Convidado;
import com.oberdan.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;

	public Iterable<Convidado> obterTodos() {
		Iterable<Convidado> convidados = repository.findAll();
		return convidados;
	}
	
	public boolean existePorId(Long id) {
		return repository.existsById(id);
	}

	public Convidado obterPorId(Long id) {
		return repository.findById(id).get();
	}

	public List<Convidado> obterPorNome(String nome) {
		return repository.findByNomeIgnoreCaseContaining(nome);
	}

	public void salvar(Convidado convidado) {
		repository.save(convidado);
	}
	
	public void remover(Long id) {
		repository.deleteById(id);
	}

	
}
