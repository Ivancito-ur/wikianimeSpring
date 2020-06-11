package com.wiki.wikianime;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.wiki.wikianime.entities.Usuario;
import com.wiki.wikianime.repository.UsuarioRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UsuarioRepository repo ;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Test
	void main() {

		Usuario u = new Usuario();
		u.setUser("usuario");
		u.setPassword(encoder.encode("1234"));		
		u.setEmail("aaaa");
		u.setCategoria("Drama");
		
		System.out.println(u);
		System.out.println(repo);
		
		Usuario retorno = repo.save(u);

	
		assertTrue(retorno.getUser().equals(u.getUser()));

	}
	

}
