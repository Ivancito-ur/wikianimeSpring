package com.wiki.wikianime;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	// static UsuarioRepository repUsuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// Usuario u = new Usuario();
		// u.setUser("usuario");
		// u.setPassword("1234");
		// u.setEmail("aaaa");
		// u.setCategoria("Drama");
		// Date a = new Date(2020, 05, 05);
		// u.setFechaIngreso(a);
		// System.out.println(u);
		// System.out.println(1);

		// repUsuarioRepository.save(u);	
		
	}

}
