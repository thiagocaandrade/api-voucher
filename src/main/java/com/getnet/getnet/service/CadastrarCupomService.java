package com.getnet.getnet.service;

import com.getnet.getnet.domain.Voucher;
import com.getnet.getnet.exception.ForbiddenException;
import com.getnet.getnet.repository.VoucherRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CadastrarCupomService {

    private final VoucherRepository repository;
    public Voucher inserirDados(Voucher voucher) {

        Random random = new Random();
        int numeroAleatorio = random.nextInt(10) * 10;

        String generatedString = RandomStringUtils.randomAlphanumeric(8);


        if (repository.findByCodigoUnico(generatedString.toString()).isPresent()) {
            throw new ForbiddenException("email e codigo unico já cadastrado.");
        } else {
            voucher.setDescontoPercentualFixo(numeroAleatorio);
            voucher.setCodigoUnico(generatedString);
            voucher.setOfertaEspecial("OFERTA" + numeroAleatorio);
            voucher.setCodigoVoucher(generatedString + "VOUCHER" + numeroAleatorio);
            voucher.setDataValidade(LocalDateTime.now().plusDays(3));
        }

        return repository.save(voucher);
    }

}
