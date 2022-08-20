package com.meublogpessoal.meuBlogPessoal.repository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.meublogpessoal.meuBlogPessoal.model.UsuarioModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {

		usuarioRepository.deleteAll();

		usuarioRepository
				.save(new UsuarioModel(0L, "João Amorim", "joao@email.com.br", "01020304", "https://i.imgur.com/jpg"));

		usuarioRepository
				.save(new UsuarioModel(0L, "Iris Amorim", "iris@email.com.br", "11121314", "https://imgur.com/img"));

		usuarioRepository.save(
				new UsuarioModel(0L, "Flavia Amorim", "flavia@email.com.br", "21222324", "https://i.imgur.com/png"));

		usuarioRepository.save(
				new UsuarioModel(0L, "Afonso Rodrigues", "afonso@email.com.br", "31323334", "https://i.imgur.com/gif"));

	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<UsuarioModel> usuario = usuarioRepository.findByUsuario("joao@email.com.br");

		assertTrue(usuario.get().getUsuario().equals("joao@email.com.br"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<UsuarioModel> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Amorim");

		assertEquals(3, listaDeUsuarios.size());

		assertTrue(listaDeUsuarios.get(0).getNome().equals("João Amorim"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Iris Amorim"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Flavia Amorim"));

	}

	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}

}