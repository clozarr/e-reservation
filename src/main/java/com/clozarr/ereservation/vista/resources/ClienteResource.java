/**
 * 
 */
package com.clozarr.ereservation.vista.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clozarr.ereservation.model.Cliente;
import com.clozarr.ereservation.negocio.services.ClienteService;
import com.clozarr.ereservation.vista.resources.vo.ClienteVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el servicio web de cliente
 * 
 * @author carlos
 *
 */
@RestController
@RequestMapping("/api/clientes")
@Api(tags = "clientes")
public class ClienteResource {

	private final ClienteService clienteService;

	public ClienteResource(ClienteService clienteService) {

		this.clienteService = clienteService;
	}

	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Metodo para crear un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			                @ApiResponse(code = 401, message = "Solicitud Inválida") })
	public ResponseEntity<Cliente> crearCliente(@RequestBody() ClienteVO clienteVO) {

		Cliente cliente = new Cliente();
		cliente.setNombreCliente(clienteVO.getNombreCliente());
		cliente.setApellidoCliente(clienteVO.getApellidoCliente());
		cliente.setDireccionCliente(clienteVO.getDireccionCliente());
		cliente.setTelefonoCliente(clienteVO.getTelefonoCliente());
		cliente.setEmailCliente(cliente.getEmailCliente());

		return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);

	}

	@PutMapping("/{identificacion}")
	@ApiOperation(value = "Actualizar Cliente", notes = "Metodo para actualizar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			                @ApiResponse(code = 404, message = "Cliente no encontrado") })
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable("identificacion") String identificacionCliente,
			ClienteVO clienteVO) {

		Cliente cliente = this.clienteService.findByIdentification(identificacionCliente);

		if (cliente == null) {

			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);

		} else {

			cliente.setNombreCliente(clienteVO.getNombreCliente());
			cliente.setApellidoCliente(clienteVO.getApellidoCliente());
			cliente.setDireccionCliente(clienteVO.getDireccionCliente());
			cliente.setTelefonoCliente(clienteVO.getTelefonoCliente());
			cliente.setEmailCliente(cliente.getEmailCliente());

		}

		return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);

	}

	@DeleteMapping("/{identificacion}")
	@ApiOperation(value = "Eliminar Cliente", notes = "Metodo para eliminar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			                @ApiResponse(code = 404, message = "Cliente no encontrado") })
	public void eliminarCliente(@PathVariable("identificacion") String identificacionCliente) {

		Cliente cliente = this.clienteService.findByIdentification(identificacionCliente);

		if (cliente != null) {

			this.clienteService.delete(cliente);
		}

	}

	@GetMapping
	@ApiOperation(value = "Listar Clientes", notes = "Metodo para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes encontrados"),
            @ApiResponse(code = 404, message = "Clientes NO encontrados") })
	public ResponseEntity<List<Cliente>> findAll() {

		return ResponseEntity.ok(this.clienteService.findAll());
	}

}
