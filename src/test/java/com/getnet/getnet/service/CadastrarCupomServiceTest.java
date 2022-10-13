package com.getnet.getnet.service;

import com.getnet.getnet.domain.Voucher;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CadastrarCupomServiceTest {

    @Mock
    private CadastrarCupomService cadastrarCupomService;
    @Mock
    private VoucherRepository voucherRepository;

    @BeforeEach
    void setUp(){
        Voucher voucher =  VoucherCreator.createVoucher();
        doReturn(voucher).when(cadastrarCupomService).inserirDados(any());

        Optional<Voucher> voucherOptional = Optional.ofNullable(VoucherCreator.createVoucher());
        when(voucherRepository.findByCodigoUnico(anyString())).thenReturn(voucherOptional);

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

        Voucher voucher = cadastrarCupomService.inserirDados(ArgumentMatchers.any());

        Assertions.assertThat(voucher).isNotNull();
        Assertions.assertThat(voucher.getCodigoUnico()).isNotNull().isEqualTo(expectCodigoUnico).hasSizeGreaterThan(7);
        Assertions.assertThat(voucher.getDestinatario()).isNotNull().isEqualTo(expectDestinatario);
        Assertions.assertThat(voucher.getNome()).isNotNull().isEqualTo(expectNome);
        Assertions.assertThat(voucher.getEmail()).isNotNull().isEqualTo(expectEmail).isNotEmpty();
        Assertions.assertThat(voucher.getOfertaEspecial()).isNotNull().isEqualTo(expectOfertaEspecial);
        Assertions.assertThat(voucher.getDescontoPercentualFixo()).isNotNull().isEqualTo(expectDescontoPercentualFixo);
        Assertions.assertThat(voucher.getCodigoVoucher()).isNotNull().isEqualTo(expectCodigoVoucher);
        Assertions.assertThat(voucher.getDataValidade()).isNotNull();
        Assertions.assertThat(voucher.getDataUso()).isNotNull();

    }
}