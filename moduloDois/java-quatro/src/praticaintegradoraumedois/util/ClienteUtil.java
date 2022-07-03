package praticaintegradoraumedois.util;

import praticaintegradoraumedois.classes.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteUtil implements Util<Cliente> {
    List<Cliente> listaClientes;

    public ClienteUtil() {
        this.listaClientes = new ArrayList<>();
    }

    @Override
    public void salvarClientes(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void exibeClientes() {
        listaClientes.stream().forEach(System.out::println);
    }

    @Override
    public Cliente buscarClientePorId(String cpfCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpfCliente)) {
                System.out.println("---- Cliente localizado em nossa base. Seus dados são: ----");
                System.out.println("Cliente: " + cliente.getNome() + " " +
                        cliente.getSobrenome() + " identificado pelo CPF: " +
                        cliente.getCpf() + ".");
                return cliente;
            } else {
                System.out.println("\nCliente não encontrado!!!");
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void excluiClientePorId(String cpfCliente) {
        Cliente cliente = this.buscarClientePorId(cpfCliente);
        if (cliente.getCpf() == cpfCliente) {
            listaClientes.remove(cliente);
            System.out.println("\nCliente excluído com sucesso!!!");
        } else {
            System.out.println("\nNão possível excluir o cliente. Cliente não encontrado");
        }
    }

    @Override
    public List<Cliente> buscarTodos() {
        return listaClientes;
    }

}
