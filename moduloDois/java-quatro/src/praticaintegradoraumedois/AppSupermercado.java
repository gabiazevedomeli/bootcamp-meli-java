package praticaintegradoraumedois;

import praticaintegradoraumedois.classes.Cliente;
import praticaintegradoraumedois.util.ClienteUtil;

public class AppSupermercado {
    public static void main(String[] args) {

        ClienteUtil listaClientes = new ClienteUtil();

        Cliente clienteUm = new Cliente("123.456.789-00", "Marcos", "Chaves");
        Cliente clienteDois = new Cliente("987.654.321-09", "Iuri", "Frigoletto");
        Cliente clienteTres = new Cliente("321.789.456-87", "Ana Clara", "Pereira");

        listaClientes.salvarClientes(clienteUm);
        listaClientes.salvarClientes(clienteDois);
        listaClientes.salvarClientes(clienteTres);

        listaClientes.exibeClientes();
        listaClientes.buscarClientePorId("123.456.789-00");
        listaClientes.excluiClientePorId("123.456.789-00");

        System.out.println("\n---- Lista de Clientes após exclusão ----\n");
        listaClientes.buscarTodos().stream().forEach(System.out::println);
    }
}
