package com.api.venta.controllers;

import com.api.venta.services.VentaServices;
import com.api.venta.dto.VentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    
    @Autowired
    private VentaServices ventaServices;

    @GetMapping
    public ResponseEntity<List<VentaDto>> getAllVentas() {
        List<VentaDto> ventas = ventaServices.getAllVentas();
        return ResponseEntity.ok(ventas);
    }

    @PostMapping
    public ResponseEntity<VentaDto> crearVenta(@RequestBody VentaDto ventaDto) {
        VentaDto nuevaVenta = ventaServices.crear(ventaDto);
        return ResponseEntity.status(201).body(nuevaVenta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDto> buscarVenta(@PathVariable Integer id) {
        VentaDto venta = ventaServices.buscar(id);
        return ResponseEntity.ok(venta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaDto> actualizarVenta(@PathVariable Integer id, @RequestBody VentaDto ventaDto) {
        VentaDto ventaActualizada = ventaServices.actualizar(id, ventaDto);
        return ResponseEntity.ok(ventaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Integer id) {
        ventaServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
