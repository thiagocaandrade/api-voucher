package com.getnet.getnet.repository;

import com.getnet.getnet.domain.Voucher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoucherRepository extends MongoRepository<Voucher, Long> {

    Optional<Voucher> findByCodigoVoucherAndEmail(String codigoVoucher, String email);
    Optional<Voucher> findByEmail(String email);
}
