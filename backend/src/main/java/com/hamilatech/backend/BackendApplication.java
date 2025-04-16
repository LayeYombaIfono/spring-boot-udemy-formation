package com.hamilatech.backend;

import com.hamilatech.backend.entities.Categorie;
import com.hamilatech.backend.entities.Produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);



	}

	@Override
	public void run(String... args) throws Exception {
		
		repositoryRestConfiguration.exposeIdsFor(Produit.class, Categorie.class);
		
	}

}
