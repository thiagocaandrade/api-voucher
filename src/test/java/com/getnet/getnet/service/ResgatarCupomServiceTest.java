package com.getnet.getnet.service;

import com.getnet.getnet.domain.Voucher;
import com.getnet.getnet.dto.ResgatarCupomDto;
import com.getnet.getnet.repository.VoucherRepository;
import com.getnet.getnet.util.VoucherCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ResgatarCupomServiceTest {

    @Mock
    private ResgatarCupomService resgatarCupomService;
    @Mock
    private VoucherRepository voucherRepository;

    @BeforeEach
    void setUp(){

        ResgatarCupomDto voucher =  VoucherCreator.createResgatarCupomDtoVoucher();
        when(resgatarCupomService.buscarDados(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(voucher);

        Optional<Voucher> voucherOptional = Optional.ofNullable(VoucherCreator.createVoucher());
        when(voucherRepository.findByCodigoVoucherAndEmail(anyString(), anyString())).thenReturn(voucherOptional);
    }

    @Test
    @DisplayName("Busca informacoes do Voucher")
    void testGetSuccessVoucher() {

        String expectOfertaEspecial = VoucherCreator.createVoucher().getOfertaEspecial();
        Integer expectDescontoPercentualFixo = VoucherCreator.createVoucher().getDescontoPercentualFixo();
        String expectCodigoVoucher = VoucherCreator.createVoucher().getCodigoVoucher();

        ResgatarCupomDto voucher = resgatarCupomService.buscarDados(ArgumentMatchers.anyString(), ArgumentMatchers.anyString());

        Assertions.assertThat(voucher).isNotNull();

        Assertions.assertThat(voucher.getOfertaEspecial()).isNotNull().isEqualTo(expectOfertaEspecial);
        Assertions.assertThat(voucher.getDescontoPercentualFixo()).isNotNull().isEqualTo(expectDescontoPercentualFixo);
        Assertions.assertThat(voucher.getCodigoVoucher()).isNotNull().isEqualTo(expectCodigoVoucher);
        Assertions.assertThat(voucher.getDataUso()).isNotNull();

    }

}