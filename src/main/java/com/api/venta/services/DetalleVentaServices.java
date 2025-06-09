package com.api.venta.services;

import com.api.venta.dto.DetalleVentaDTO;
import com.api.venta.models.DetalleVenta;
import com.api.venta.repository.DetalleVentaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;


@Service
public class DetalleVentaServices {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;
    private DetalleVentaDTO toDto(DetalleVenta detalleVenta) {
        return new DetalleVentaDTO(
            detalleVenta.getIdDetalleVenta()
        );
    }

    private DetalleVenta toEntity(DetalleVentaDTO dto) {
        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setIdDetalleVenta(dto.getIdDetalleVenta());
        return detalleVenta;
    }

    public List<DetalleVentaDTO> getAllDetalles() {
        return detalleVentaRepository.findAll().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    public DetalleVentaDTO crear(DetalleVentaDTO dto) {
        DetalleVenta detalleVenta = toEntity(dto);
        return toDto(detalleVentaRepository.save(detalleVenta));
    }

    public DetalleVentaDTO buscar(Integer id) {
        DetalleVenta detalleVenta = detalleVentaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Detalle de venta no encontrado"));
        return toDto(detalleVenta);
    }

    public DetalleVentaDTO actualizar(Integer id, DetalleVentaDTO dto) {
        DetalleVenta detalleVenta = detalleVentaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Detalle de venta no encontrado"));
        detalleVenta.setIdDetalleVenta(dto.getIdDetalleVenta());
        return toDto(detalleVentaRepository.save(detalleVenta));
    }

    public void eliminar(Integer id) {
        detalleVentaRepository.deleteById(id);
    }

}
