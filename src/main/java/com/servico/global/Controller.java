package com.servico.global;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

	@Autowired
	private ServicoRepository repository;

	@GetMapping("/servicos")
	public List<ServicoModel> pegarTodos() {
		return repository.findAll();
	}
	
	@PostMapping("/servicos")
	public ServicoModel criar(@RequestBody ServicoModel model) {
		repository.save(model);
		return model;
	}
	
	
	@GetMapping("/servico/nome/{nome}")
	public List<ServicoModel> buscarPorNome(@PathVariable String nome) {
		return repository.findByNome(nome);
	}
	@GetMapping("/aluno/{id}")
	public Optional<ServicoModel> buscarPorId(@PathVariable Long id) {
		return repository.findById(id);
	}
	

	@DeleteMapping("/servicos/{id}")
	public String remover(@PathVariable Long id) {	
		repository.deleteById(id);
	return "sucesso";
	}
}







