package com.metodologias.TestUnitarios;

import static org.assertj.core.api.Assertions.assertThat;
import  static org.assertj.core.api.Fail.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.Cliente;
import negocio.GerenciadoraClientes;
import negocio.IdadeNaoPermitidaException;

/**
 * Classe de teste criada para garantir o funcionamento das principais opera��es
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.
 * 
 * @author Gustavo Farias
 * @date 21/01/2035 
 */
public class GerenciadoraClientesTest_Ex10 {

	private GerenciadoraClientes gerClientes;
	private int idCLiente01 = 1;
	private	int idCLiente02 = 2;
	
	@BeforeEach
	public void setUp() {
	
		/* ========== Montagem do cen�rio ========== */
		
		// criando alguns clientes
		Cliente cliente01 = new Cliente(idCLiente01, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCLiente02, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}

	@AfterEach
	public void tearDown() {
		gerClientes.limpa();
	}
	
	/**
	 * Teste b�sico da pesquisa de um cliente a partir do seu ID.
	 * 
	 * @author Gustavo Farias
	 * @date 21/01/2035
	 */
	@Test
	public void testPesquisaCliente() {

		/* ========== Execu��o ========== */
		Cliente cliente = gerClientes.pesquisaCliente(idCLiente01);
		
		/* ========== Verifica��es ========== */
		assertThat(cliente.getId()).isEqualTo(idCLiente01);
		
	}
	
	/**
	 * Teste b�sico da pesquisa por um cliente que n�o existe.
	 * 
	 * @author Gustavo Farias
	 * @date 21/01/2035
	 */
	//@Disabled
	@Test 
	public void testPesquisaClienteInexistente() {

		/* ========== Execu��o ========== */
		Cliente cliente = gerClientes.pesquisaCliente(1001);
		
		/* ========== Verifica��es ========== */
		assertThat(cliente).isNull();
		
	}
	
	/**
	 * Teste b�sico da remo��o de um cliente a partir do seu ID.
	 * 
	 * @author Gustavo Farias
	 * @date 21/01/2035
	 */
	@Test //@Disabled
	public void testRemoveCliente() {
		
		/* ========== Execu��o ========== */
		boolean clienteRemovido = gerClientes.removeCliente(idCLiente02);
		
		/* ========== Verifica��es ========== */
		assertThat(clienteRemovido).isTrue();
		assertThat(gerClientes.getClientesDoBanco().size()).isEqualTo(1);
		assertThat(gerClientes.pesquisaCliente(idCLiente02)).isNull();
		
	}
	
	/**
	 * Teste da tentativa de remo��o de um cliente inexistente.
	 * 
	 * @author Gustavo Farias
	 * @date 21/01/2035
	 */
	@Test //@Disabled
	public void testRemoveClienteInexistente() {

	
		/* ========== Execu��o ========== */
		boolean clienteRemovido = gerClientes.removeCliente(1001);
		
		/* ========== Verifica��es ========== */
		assertThat(clienteRemovido).isFalse();
		assertThat(gerClientes.getClientesDoBanco().size()).isEqualTo(2);		
	}
	
	/**
	 * Valida��o da idade de um cliente quando a mesma est� no intervalo permitido.
	 * 
	 * @author Gustavo Farias
	 * @throws IdadeNaoPermitidaException 
	 * @date 21/01/2035
	 */
	@Test //@Disabled
	public void testClienteIdadeAceitavel() throws IdadeNaoPermitidaException {

		/* ========== Montagem do Cen�rio ========== */		
		Cliente cliente = new Cliente(1, "Gustavo", 25, "guga@gmail.com", 1, true);
		
		/* ========== Execu��o ========== */
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		/* ========== Verifica��es ========== */	
		assertThat(idadeValida).isTrue();
	}
	
	/**
	 * Valida��o da idade de um cliente quando a mesma est� no intervalo permitido.
	 * 
	 * @author Gustavo Farias
	 * @throws IdadeNaoPermitidaException 
	 * @date 21/01/2035
	 */
	@Test //@Disabled
	public void testClienteIdadeAceitavel_02() throws IdadeNaoPermitidaException {

		/* ========== Montagem do Cen�rio ========== */		
		Cliente cliente = new Cliente(1, "Gustavo", 18, "guga@gmail.com", 1, true);
		
		/* ========== Execu��o ========== */
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		/* ========== Verifica��es ========== */
		assertThat(idadeValida).isTrue();	
	}
	
	/**
	 * Valida��o da idade de um cliente quando a mesma est� no intervalo permitido.
	 * 
	 * @author Gustavo Farias
	 * @throws IdadeNaoPermitidaException 
	 * @date 21/01/2035
	 */
	@Test //@Disabled
	public void testClienteIdadeAceitavel_03() throws IdadeNaoPermitidaException {

		/* ========== Montagem do Cen�rio ========== */		
		Cliente cliente = new Cliente(1, "Gustavo", 65, "guga@gmail.com", 1, true);
		
		/* ========== Execu��o ========== */
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		
		/* ========== Verifica��es ========== */
		assertThat(idadeValida).isTrue();
	}
	
	/**
	 * Valida��o da idade de um cliente quando a mesma est� abaixo intervalo permitido.
	 * 
	 * @author Gustavo Farias
	 * @throws IdadeNaoPermitidaException 
	 * @date 21/01/2035
	 */
	@Test //@Disabled
	public void testClienteIdadeAceitavel_04() throws IdadeNaoPermitidaException {

		/* ========== Montagem do Cen�rio ========== */		
		Cliente cliente = new Cliente(1, "Gustavo", 17, "guga@gmail.com", 1, true);

		/* ========== Execu��o ========== */
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail("fail");
		} catch (Exception e) {
			/* ========== Verifica��es ========== */
			assertThat(e.getMessage()).isEqualTo(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA);
		}	
	}
	
	/**
	 * Valida��o da idade de um cliente quando a mesma est� acima intervalo permitido.
	 * 
	 * @author Gustavo Farias
	 * @throws IdadeNaoPermitidaException 
	 * @date 21/01/2035
	 */
	@Test //@Disabled
	public void testClienteIdadeAceitavel_05() throws IdadeNaoPermitidaException {
		
		/* ========== Montagem do Cen�rio ========== */		
		Cliente cliente = new Cliente(1, "Gustavo", 66, "guga@gmail.com", 1, true);
		/* ========== Execu��o ========== */
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail("fail");
		} catch (Exception e) {
			/* ========== Verifica��es ========== */
			assertThat(e.getMessage()).isEqualTo(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA);
		}	
	}
	
}

// Valores Limites