package com.curso.springboot.webflux.app.models.documents;

import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document(collection ="productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
	
	@Id
	private String id;
	
	private String nombre;
	private Double precio;
	
	public Producto(String nombre, Double precio) {
		this.nombre=nombre;
		this.precio=precio;
	}
	
	@CreatedDate
	
	private Date creatAt;
	
}
