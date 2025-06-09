package com.api.venta.services;

import com.api.venta.dto.VentaDTO;
import com.api.venta.models.Venta;
import com.api.venta.repository.VentaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class VentaServices {

    @Autowired
    private VentaRepository ventaRepository;
    private VentaDTO toDTO(Venta venta) {
        return new VentaDTO(
            venta.getIdVenta(),
            venta.getFecha(),
            venta.getTotal()
        );
    }

    private Venta toEntity(VentaDTO dto) {
        Venta venta = new Venta();
        venta.setIdVenta(dto.getIdVenta());
        venta.setFecha(dto.getFecha());
        venta.setTotal(dto.getTotal());
        return venta;
    }

    public List<VentaDTO> getAllVentas() {
        return ventaRepository.findAll().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    public VentaDTO crear(VentaDTO dto) {
        Venta venta = toEntity(dto);
        return toDto(ventaRepository.save(venta));
    }

    public VentaDTO buscar(Integer id) {
        Venta venta = ventaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        return toDTO(venta);
    }

    public VentaDTO actualizar(Integer id, VentaDTO dto) {
        Venta venta = ventaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        venta.setFecha(dto.getFecha());
        venta.setTotal(dto.getTotal());
        return toDto(ventaRepository.save(venta));
    }

    public void eliminar(Integer id) {
        ventaRepository.deleteById(id);
    }

}
