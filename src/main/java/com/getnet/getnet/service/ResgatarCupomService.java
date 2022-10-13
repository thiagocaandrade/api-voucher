package com.getnet.getnet.service;

import com.getnet.getnet.domain.Voucher;
import com.getnet.getnet.dto.ResgatarCupomDto;
import com.getnet.getnet.exception.NotFoundException;
import com.getnet.getnet.repository.VoucherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ResgatarCupomService {
    private final VoucherRepository repository;

    public ResgatarCupomDto buscarDados(String codigoVoucher, String email) {

        ResgatarCupomDto resgatarCupomDto = new ResgatarCupomDto();

        Voucher voucher = repository.findByCodigoVoucherAndEmail(codigoVoucher,
                email).orElseThrow(() -> new NotFoundException("Recurso não encontrado"));

        resgatarCupomDto.setDescontoPercentualFixo(voucher.getDescontoPercentualFixo());
        resgatarCupomDto.setDataUso(LocalDateTime.now());

        return resgatarCupomDto;
    }

}
