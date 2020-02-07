package br.com.bertini.cadastrocliente.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bertini.cadastrocliente.domain.Cliente;
import br.com.bertini.cadastrocliente.exception.DataNotFoundException;
import br.com.bertini.cadastrocliente.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	@PostMapping()
	public Cliente createCliente(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@GetMapping()
	public List<Cliente> getAllCliente() {
		return clienteRepository.findAll();
	}

	@GetMapping("/{id}")
	public Cliente getCliente(@PathVariable(value = "id") Long clienteId) {

		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new DataNotFoundException("Cliente", "idCliente", clienteId));

	}

	@PutMapping("/{id}")
	public Cliente updateCliente(@PathVariable(value = "id") Long clienteId,
			@Valid @RequestBody Cliente clienteAtualiza) {
		Cliente clienteData = clienteRepository.findById(clienteId)
				.orElseThrow(() -> new DataNotFoundException("Cliente", "id", clienteId));
		clienteData.setNome(clienteAtualiza.getNome());
		clienteData.setIdade(clienteAtualiza.getIdade());
		clienteData.setProfissao(clienteAtualiza.getProfissao());
		clienteData.setEstadoCivil(clienteAtualiza.getEstadoCivil());
		clienteData.setDataNascimento(clienteAtualiza.getDataNascimento());

		Cliente clienteAtualizado = clienteRepository.save(clienteData);
		return clienteAtualizado;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable(value = "id") Long clienteId){
		Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new DataNotFoundException("cliente", "idCliente", clienteId));
		clienteRepository.delete(cliente);
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping("/profissao/{idProfissao}")
	public Cliente getCliente(@PathVariable(value = "idProfissao") String idProfissao) {
		return clienteRepository.findByProfissao(idProfissao);
		
	}

}
