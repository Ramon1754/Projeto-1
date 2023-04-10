package br.com.ramon.dao;

import br.com.ramon.dao.IClienteDAO;
import br.com.ramon.domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CLienteMapDAO  implements IClienteDAO {

    private Map<Long, Cliente> map;

    public CLienteMapDAO() {
        this.map = new HashMap<>();
    }
    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;

    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);

        if (clienteCadastrado != null) {
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }
    }

    @Override
    public void alterar(br.com.ramon.domain.Cliente cLiente) {
        Cliente clienteCadastrado = this.map.get(cLiente.getCpf());
        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(clienteCadastrado.getNome());
            clienteCadastrado.setTel(clienteCadastrado.getTel());
            clienteCadastrado.setNumero(clienteCadastrado.getNumero());
            clienteCadastrado.setEnd(clienteCadastrado.getEnd());
            clienteCadastrado.setCidade(clienteCadastrado.getCidade());
            clienteCadastrado.setEstado(clienteCadastrado.getEstado());
        }

    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);

    }
    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}
