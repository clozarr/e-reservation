/**
 * 
 */
package com.clozarr.ereservation.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clozarr.ereservation.model.Cliente;
import com.clozarr.ereservation.negocio.repository.ClienteRepository;

/**
 * @author carlos
 *
 */
@Service
@Transactional(readOnly = true) // cuando la anotación se coloca a nivel de clase, indica que todos los métodos que NO estén anotados, heredarán esta anotación. en este caso puntual, las operaciones de consulta solo tendrán transaccionalidad READONLY 
public class ClienteService {
	
	private final ClienteRepository  clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
	
		this.clienteRepository = clienteRepository;
	}

	/**
	 * Operación para crear un cliente 
	 */
	@Transactional
	public Cliente create(Cliente cliente) {
		
		return this.clienteRepository.save(cliente);
	}
	/**
	 * Operación para actualizar un cliente 
	 */
	@Transactional
	public Cliente update(Cliente cliente) {
		
		return this.clienteRepository.save(cliente);
	}
	/**
	 * Operación para eliminar un cliente 
	 */
	@Transactional
	public void delete(Cliente cliente) {
		
		this.clienteRepository.delete(cliente);
	}
	
	public Cliente findByIdentification(String identificacionCliente) {
		
		return this.clienteRepository.findByIdentification(identificacionCliente);
	}

	public List<Cliente> findAll() {
		
		return this.clienteRepository.findAll();
	}
}
