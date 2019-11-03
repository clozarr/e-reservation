package com.clozarr.ereservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idReserva;
	private Date fechaIngresoReserva;
	private Date fechaSalidaReserva;
	private int cantidadPersonasReserva;
	private String descripcionReserva;
	
	@ManyToOne()
	@JoinColumn(name = "idCliente")
	private Cliente cliente; 

}
