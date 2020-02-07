package br.com.bertini.cadastrocliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bertini.cadastrocliente.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	public Cliente findByProfissao(String profissao);

}
