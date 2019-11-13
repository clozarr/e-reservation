package com.clozarr.ereservation.negocio.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import com.clozarr.ereservation.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

	/**
	 * 
	 * Consulta Usando 'Query Generation Strategy' 
	 * usando palabra reservada findBy + nombre del atributo
	 */
	public List<Cliente> findByApellidoCliente(String apellidoCliente);
	
   /**
	 * Consulta Usando JPQL, Anotando la Clase 'Cliente' en el paquete del Modelo con NamedQuery
	 */
	public Cliente findByIdentification(String identificacionCliente);
}
