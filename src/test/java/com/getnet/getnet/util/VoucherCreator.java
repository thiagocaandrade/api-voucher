package com.getnet.getnet.util;

import com.getnet.getnet.domain.Voucher;
import com.getnet.getnet.dto.ResgatarCupomDto;

import java.time.LocalDateTime;

public class VoucherCreator {

    public static Voucher createVoucher(){
        return Voucher.builder()
                .codigoVoucher("VOUCHER30")
                .codigoUnico("1a5f134e12a6d723dc3f7e1c53fda42b87f4937e0ba8dd4b4c14dd7297d65b33")
                .dataUso(LocalDateTime.now())
                .dataValidade(LocalDateTime.now().plusDays(3))
                .descontoPercentualFixo(30)
                .destinatario("Thiago Andrade")
                .email("testando@gmail.com")
                .nome("Thiago Carlos")
                .ofertaEspecial("OFERTA30")
                .build();
    }

    public static ResgatarCupomDto createResgatarCupomDtoVoucher(){
        return ResgatarCupomDto.builder()
                .dataUso(LocalDateTime.now())
                .descontoPercentualFixo(30)
                .build();
    }

}
