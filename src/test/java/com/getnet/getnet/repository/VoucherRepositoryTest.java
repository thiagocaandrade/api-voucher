package com.getnet.getnet.repository;

import com.getnet.getnet.domain.Voucher;
import com.getnet.getnet.util.VoucherCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class VoucherRepositoryTest {

    @Autowired
    private VoucherRepository voucherRepository;

    @Test
    @DisplayName("Salvando informacoes do voucher no banco de dados")
    void testSaveSuccessVoucher(){

        String expectCodigoUnico = VoucherCreator.createVoucher().getCodigoUnico();
        String expectDestinatario = VoucherCreator.createVoucher().getDestinatario();
        String expectNome = VoucherCreator.createVoucher().getNome();
        String expectEmail = VoucherCreator.createVoucher().getEmail();
        String expectOfertaEspecial = VoucherCreator.createVoucher().getOfertaEspecial();
        Integer expectDescontoPercentualFixo = VoucherCreator.createVoucher().getDescontoPercentualFixo();
        String expectCodigoVoucher = VoucherCreator.createVoucher().getCodigoVoucher();
        LocalDateTime expectDataValidade = VoucherCreator.createVoucher().getDataValidade();
        LocalDateTime expectDataUso = VoucherCreator.createVoucher().getDataUso();

        Voucher voucherToBeSaved = VoucherCreator.createVoucher();

        Voucher voucherSaved = voucherRepository.save(voucherToBeSaved);

        Assertions.assertThat(voucherSaved).isNotNull();
        Assertions.assertThat(voucherSaved.getCodigoUnico()).isNotNull().isEqualTo(expectCodigoUnico).hasSizeGreaterThan(7);
        Assertions.assertThat(voucherSaved.getDestinatario()).isNotNull().isEqualTo(expectDestinatario);
        Assertions.assertThat(voucherSaved.getNome()).isNotNull().isEqualTo(expectNome);
        Assertions.assertThat(voucherSaved.getEmail()).isNotNull().isEqualTo(expectEmail);
        Assertions.assertThat(voucherSaved.getOfertaEspecial()).isNotNull().isEqualTo(expectOfertaEspecial);
        Assertions.assertThat(voucherSaved.getDescontoPercentualFixo()).isNotNull().isEqualTo(expectDescontoPercentualFixo);
        Assertions.assertThat(voucherSaved.getCodigoVoucher()).isNotNull().isEqualTo(expectCodigoVoucher);
        Assertions.assertThat(voucherSaved.getDataValidade()).isNotNull().isEqualTo(expectDataValidade);
        Assertions.assertThat(voucherSaved.getDataUso()).isNotNull().isEqualTo(expectDataUso);

    }

}