package com.metodologias.TestUnitarios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import negocio.ContaCorrente;
import negocio.GerenciadoraContas;

public class GerenciadoraContasTest {

	private GerenciadoraContas gerContas;
	private int idConta01 = 1;
	private int idConta02 = 2;
	private int valor = 200;
	
	@BeforeEach 
	public void setUp() {
		/* ************* Montaje de Escenario ********** */
		// criando lista vazia de contas
		List<ContaCorrente> contasDoBanco = new ArrayList<>();

		// criando e inserindo duas contas na lista de contas correntes do banco
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 3000, true);
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
	}
	
	@AfterEach
	public void tearDown() {
		gerContas.limpa();
	}
	
	@Test
	public void testTransfereValor() {
		/* ************* Ejecucion ********** */
		boolean transferido = gerContas.transfereValor(idConta01, valor, idConta02);
		
		/* ************* Verificaciones ********** */
		assertThat(transferido).isTrue();
		assertThat(gerContas.pesquisaConta(idConta02).getSaldo()).isEqualTo(3200);
		assertThat(gerContas.pesquisaConta(idConta01).getSaldo()).isEqualTo(0);
	}
}
