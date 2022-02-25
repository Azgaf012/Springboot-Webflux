package com.curso.springboot.webflux.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.springboot.webflux.app.models.dao.ProductoDao;
import com.curso.springboot.webflux.app.models.documents.Producto;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootWebfluxApplication implements CommandLineRunner{

	@Autowired
	private ProductoDao dao;
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootWebfluxApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Flux.just(
				new Producto("TV Panasonic",456.89),
				new Producto("Apple iPod",177.89),
				new Producto("Sony notebook",46.89),
				new Producto("Multifuncional",846.89),
				new Producto("TV Panasonic",456.89)
				)
		.flatMap(p->dao.save(p))
		.subscribe(p->log.info("Insert: " + p));
		
	}

}
