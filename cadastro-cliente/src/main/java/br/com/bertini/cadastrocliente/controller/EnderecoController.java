package br.com.bertini.cadastrocliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bertini.cadastrocliente.domain.Endereco;
import br.com.bertini.cadastrocliente.repository.AddressRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping("cep/{cep}")
	public Endereco getCliente(@PathVariable(value = "cep") String cep) {
		return addressRepository.getEndereco(cep);
		
		
	}

}
