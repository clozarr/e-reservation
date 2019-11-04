package com.clozarr.ereservation.negocio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.clozarr.ereservation.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, String>{

	
	/**
	 * Consulta usando Spring JPA, anotando el médodo Query
	 * */
	 @Query("select r from Reserva r where r.fechaIngresoReserva =:fechaInicio and r.fechaSalidaReserva =:fechaSalida")
	 public List<Reserva> find(@Param("fechaInicio")Date fechaInicio, @Param("fechaSalida")Date fechaSalida);
	
}
