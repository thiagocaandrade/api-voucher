package com.getnet.getnet.controller;

import com.getnet.getnet.domain.Voucher;
import com.getnet.getnet.dto.ResgatarCupomDto;
import com.getnet.getnet.service.CadastrarCupomService;
import com.getnet.getnet.service.ResgatarCupomService;
import com.getnet.getnet.util.VoucherCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class VoucherControllerTest {
    @InjectMocks
    private VoucherController voucherController;

    @Mock
    private CadastrarCupomService cadastrarCupomService;

    @Mock
    private ResgatarCupomService resgatarCupomService;


    @BeforeEach
    void setUp() {
        when(cadastrarCupomService.inserirDados(ArgumentMatchers.any()))
                .thenReturn(VoucherCreator.createVoucher());
        when(resgatarCupomService.buscarDados(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
                .thenReturn(VoucherCreator.createResgatarCupomDtoVoucher());

    }

    @Test
    @DisplayName("Salva informacoes do Voucher")
    void testSaveSuccessVoucher() {

        String expectCodigoUnico = VoucherCreator.createVoucher().getCodigoUnico();
        String expectDestinatario = VoucherCreator.createVoucher().getDestinatario();
        String expectNome = VoucherCreator.createVoucher().getNome();
        String expectEmail = VoucherCreator.createVoucher().getEmail();
        String expectOfertaEspecial = VoucherCreator.createVoucher().getOfertaEspecial();
        Integer expectDescontoPercentualFixo = VoucherCreator.createVoucher().getDescontoPercentualFixo();
        String expectCodigoVoucher = VoucherCreator.createVoucher().getCodigoVoucher();

        ResponseEntity<Voucher> voucher = voucherController.save(Voucher.builder().build());

        Assertions.assertThat(voucher).isNotNull();
        Assertions.assertThat(voucher.getBody().getCodigoUnico()).isNotNull().isEqualTo(expectCodigoUnico).hasSizeGreaterThan(7);
        Assertions.assertThat(voucher.getBody().getDestinatario()).isNotNull().isEqualTo(expectDestinatario);
        Assertions.assertThat(voucher.getBody().getNome()).isNotNull().isEqualTo(expectNome);
        Assertions.assertThat(voucher.getBody().getEmail()).isNotNull().isEqualTo(expectEmail);
        Assertions.assertThat(voucher.getBody().getOfertaEspecial()).isNotNull().isEqualTo(expectOfertaEspecial);
        Assertions.assertThat(voucher.getBody().getDescontoPercentualFixo()).isNotNull().isEqualTo(expectDescontoPercentualFixo);
        Assertions.assertThat(voucher.getBody().getCodigoVoucher()).isNotNull().isEqualTo(expectCodigoVoucher);
        Assertions.assertThat(voucher.getBody().getDataValidade()).isNotNull();
        Assertions.assertThat(voucher.getBody().getDataUso()).isNotNull();

    }

    @Test
    @DisplayName("Busca informacoes do Voucher")
    void testGetSuccessVoucher() {

        String expectOfertaEspecial = VoucherCreator.createVoucher().getOfertaEspecial();
        Integer expectDescontoPercentualFixo = VoucherCreator.createVoucher().getDescontoPercentualFixo();
        String expectCodigoVoucher = VoucherCreator.createVoucher().getCodigoVoucher();

        ResponseEntity<ResgatarCupomDto> voucher = voucherController.buscar(ArgumentMatchers.anyString(), ArgumentMatchers.anyString());

        Assertions.assertThat(voucher).isNotNull();

        Assertions.assertThat(voucher.getBody().getOfertaEspecial()).isNotNull().isEqualTo(expectOfertaEspecial);
        Assertions.assertThat(voucher.getBody().getDescontoPercentualFixo()).isNotNull().isEqualTo(expectDescontoPercentualFixo);
        Assertions.assertThat(voucher.getBody().getCodigoVoucher()).isNotNull().isEqualTo(expectCodigoVoucher);

    }

}