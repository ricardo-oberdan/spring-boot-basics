package com.oberdan.listavip.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.oberdan.listavip.model.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {
	
	List<Convidado> findByNomeIgnoreCaseContaining(String nome);

}
