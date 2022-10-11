package com.getnet.getnet.service;

import com.getnet.getnet.domain.Voucher;
import com.getnet.getnet.exception.ForbiddenException;
import com.getnet.getnet.repository.VoucherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CadastrarCupomService {

    private final VoucherRepository repository;

    public Voucher inserirDados(Voucher voucher) {

        Random random = new Random();
        int numeroAleatorio = random.nextInt(10) * 10;

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] digest = md.digest(voucher.getEmail().getBytes(StandardCharsets.UTF_8));
        String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();

        if (repository.findByEmail(voucher.getEmail()).isPresent()) {
            throw new ForbiddenException("email já cadastrado.");
        } else {
            voucher.setDescontoPercentualFixo(numeroAleatorio);
            voucher.setCodigoUnico(sha256);
            voucher.setOfertaEspecial("OFERTA" + numeroAleatorio);
            voucher.setCodigoVoucher("VOUCHER" + numeroAleatorio);
            voucher.setDataValidade(LocalDateTime.now().plusDays(3));
            voucher.setDataUso(LocalDateTime.now());
        }

        return repository.save(voucher);
    }
}
