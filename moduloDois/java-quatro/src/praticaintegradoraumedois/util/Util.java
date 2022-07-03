package praticaintegradoraumedois.util;

import praticaintegradoraumedois.classes.Cliente;

import java.util.List;

public interface Util <Cliente> {
    public void salvarClientes(Cliente objeto);
    public void exibeClientes();
    public Cliente buscarClientePorId(String cpf);
    public void excluiClientePorId(String cpf);
    public List<Cliente> buscarTodos();
}
