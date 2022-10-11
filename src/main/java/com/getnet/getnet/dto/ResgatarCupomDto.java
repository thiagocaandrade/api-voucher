package com.getnet.getnet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResgatarCupomDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int descontoPercentualFixo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime dataUso;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String codigoVoucher;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ofertaEspecial;
}
