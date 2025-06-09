package com.api.venta.controllers;

import com.api.venta.dto.DetalleVentaDTO;
import com.api.venta.services.DetalleVentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/detalles-venta")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaServices detalleVentaServices;

    @GetMapping
    public ResponseEntity<List<DetalleVentaDTO>> getAllDetalles() {
        List<DetalleVentaDTO> detalles = detalleVentaServices.getAllDetalles();
        return ResponseEntity.ok(detalles);
    }

    @PostMapping
    public ResponseEntity<DetalleVentaDTO> crearDetalle(@RequestBody DetalleVentaDTO detalleVentaDto) {
        DetalleVentaDTO nuevoDetalle = detalleVentaServices.crear(detalleVentaDto);
        return ResponseEntity.status(201).body(nuevoDetalle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVentaDTO> buscarDetalle(@PathVariable Integer id) {
        DetalleVentaDTO detalle = detalleVentaServices.buscar(id);
        return ResponseEntity.ok(detalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVentaDTO> actualizarDetalle(@PathVariable Integer id, @RequestBody DetalleVentaDTO detalleVentaDto) {
        DetalleVentaDTO detalleActualizado = detalleVentaServices.actualizar(id, detalleVentaDto);
        return ResponseEntity.ok(detalleActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Integer id) {
        detalleVentaServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
