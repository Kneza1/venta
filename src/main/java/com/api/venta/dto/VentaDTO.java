package com.api.venta.dto;

import lombok.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {
    private Integer IdVenta;
    private Date fecha;
    private int total;

}
