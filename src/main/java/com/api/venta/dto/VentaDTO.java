package com.api.venta.dto;

import org.springframework.hateoas.RepresentationModel;
import lombok.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO extends RepresentationModel<VentaDTO> {
    private Integer IdVenta;
    private Date fecha;
    private int total;

}
