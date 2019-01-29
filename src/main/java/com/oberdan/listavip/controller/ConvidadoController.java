package com.oberdan.listavip.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oberdan.listavip.error.NaoEncontradoException;
import com.oberdan.listavip.model.Convidado;
import com.oberdan.listavip.service.ConvidadoService;

@RestController
@RequestMapping("vips")
public class ConvidadoController {

	@Autowired
    private ConvidadoService service;

	//@RequestMapping(method=RequestMethod.GET) 
	@GetMapping
	public ResponseEntity<?> listaConvidados() {
		Iterable<Convidado> lista = service.obterTodos();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	//@RequestMapping(method=RequestMethod.GET, path="/{id}")
	@GetMapping(path="/{id}")
	public ResponseEntity<?> listaPorId(@PathVariable("id") Long id) {
		verificaSeConvidadoExiste(id);
		Convidado convidado = service.obterPorId(id);
		return new ResponseEntity<>(convidado, HttpStatus.OK);
	}

	@GetMapping(path="/listaPorNome/{nome}")
	public ResponseEntity<?> listaPorNome(@PathVariable String nome) {
		return new ResponseEntity<>(service.obterPorNome(nome), HttpStatus.OK);
	}

	//@RequestMapping(method=RequestMethod.POST)
	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Convidado convidado) {		
		service.salvar(convidado);
		
		//new EmailService().enviar(nome, email);

		return new ResponseEntity<>(convidado, HttpStatus.CREATED);
	}

	//@RequestMapping(method=RequestMethod.PUT)
	@PutMapping
	public ResponseEntity<?> alterar(@Valid @RequestBody Convidado convidado) {
		service.salvar(convidado);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//@RequestMapping(method=RequestMethod.DELETE, path="/{id}")
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		service.remover(id);
		return new ResponseEntity<>(HttpStatus.GONE);
	}

	private void verificaSeConvidadoExiste(Long id) {
		if (service.existePorId(id) == false)
			throw new NaoEncontradoException("Convidado nao existe");
	}

}
