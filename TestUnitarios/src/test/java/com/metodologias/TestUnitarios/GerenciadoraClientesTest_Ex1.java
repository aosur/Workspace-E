package com.metodologias.TestUnitarios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import negocio.Cliente;
import negocio.GerenciadoraClientes;

public class GerenciadoraClientesTest_Ex1 {
	
	private GerenciadoraClientes gerClientes;

	@Disabled
	@Test
	public void testPesquisaCliente() {

		/* ************* Montaje de Escenario ********** */
		// criando dois clientes e associando as contas criadas acima a eles
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);

		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/* ************* Ejecucion ********** */
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		/* ************* Verificaciones ********** */
		assertThat(cliente.getId()).isEqualTo(1);
		assertThat(cliente.getEmail()).isEqualTo("gugafarias@gmail.com");
	}

	@Test
	public void testRemoveCliente() {
		
		/* ************* Montaje de Escenario ********** */

		// criando dois clientes e associando as contas criadas acima a eles
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);

		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/* ************* Ejecucion ********** */
		boolean removed = gerClientes.removeCliente(2);
		
		/* ************* Verificaciones ********** */
		assertThat(removed).isTrue();
		assertThat(gerClientes.getClientesDoBanco().size()).isEqualTo(1);
		assertThat(gerClientes.pesquisaCliente(2)).isNull();;

	}
}
