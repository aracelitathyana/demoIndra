package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TipoCambio;
import com.example.demo.repository.TipoCambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TipoCambioController {
	@Autowired
	private TipoCambioRepository tipoCambioRepository;

	@GetMapping("/tipocambio")
	public List<TipoCambio> getAllTipoCambio() {
		return tipoCambioRepository.findAll();
	}

	//Lee los datos segun el id seleccionado
	@GetMapping("/tipocambio/{id}")
	public ResponseEntity<TipoCambio> getTipoCambioById(
			@PathVariable(value = "id") Long tipoCambioId
	) throws ResourceNotFoundException {
		TipoCambio tipoCambio = tipoCambioRepository.findById(tipoCambioId).orElseThrow(() -> new ResourceNotFoundException("No se escuentra tipo de cambio con id:: " + tipoCambioId));
		return ResponseEntity.ok().body(tipoCambio);
	}

	//Registra un nuevo tipo de cambio en la bd
	@PostMapping("/tipocambio")
	public TipoCambio createTipoCambio(@RequestBody TipoCambio tipoCambio) {
		return tipoCambioRepository.save(tipoCambio);
	}

	//Actualiza el tipo de cambio para el id seleccionado
	@PutMapping("/tipocambio/{id}")
	public ResponseEntity<TipoCambio> updateEmployee(@PathVariable(value = "id") Long tipoCambioId, @RequestBody TipoCambio tipoCambioDetalle) throws ResourceNotFoundException {
		TipoCambio tipoCambio = tipoCambioRepository.findById(tipoCambioId).orElseThrow(() -> new ResourceNotFoundException("No se escuentra tipo de cambio con id :: " + tipoCambioId));

		//Calcula el nuevo monto con el tipo de cambio ingresado:
		float montoConTipoCambio = tipoCambioDetalle.getMonto() * tipoCambioDetalle.getTipoDeCambio();

		tipoCambio.setMonto(tipoCambioDetalle.getMonto());
		tipoCambio.setMontoConTipoCambio(montoConTipoCambio);
		tipoCambio.setMonedaOrigen(tipoCambioDetalle.getMonedaOrigen());
		tipoCambio.setMonedaDestino(tipoCambioDetalle.getMonedaDestino());
		tipoCambio.setTipoDeCambio(tipoCambioDetalle.getTipoDeCambio());

		final TipoCambio update = tipoCambioRepository.save(tipoCambio);
		return ResponseEntity.ok(update);
	}

	//Elimina el id segun el tipo de cambio seleccionado
	@DeleteMapping("/tipocambio/{id}")
	public Map<String, Boolean> deleteTipoCambio(@PathVariable(value = "id") Long tipoCambioId) throws ResourceNotFoundException {
		TipoCambio tipoCambio = tipoCambioRepository.findById(tipoCambioId).orElseThrow(() -> new ResourceNotFoundException("No se escuentra tipo de cambio con id :: " + tipoCambioId));

		tipoCambioRepository.delete(tipoCambio);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
