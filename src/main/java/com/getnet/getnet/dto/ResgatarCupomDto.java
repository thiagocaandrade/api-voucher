package com.getnet.getnet.dto;

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

    private int descontoPercentualFixo;

    private LocalDateTime dataUso;

}
