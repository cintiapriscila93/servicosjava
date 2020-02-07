package br.com.bertini.cadastrocliente.repository;

import br.com.bertini.cadastrocliente.domain.Endereco;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Content-Type:application/x-www-form-urlencoded")
public interface AddressRepository {
	@RequestLine("GET ws/{cep}/json")
	Endereco getEndereco(@Param(value = "cep") String cep);

}
