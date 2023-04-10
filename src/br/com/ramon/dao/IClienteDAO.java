package br.com.ramon.dao;

import br.com.ramon.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);

    public void excluir(Long cpf);

    public void alterar(Cliente cLiente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();

}
