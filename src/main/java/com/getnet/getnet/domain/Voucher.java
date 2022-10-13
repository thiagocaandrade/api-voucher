package com.getnet.getnet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Voucher {

    @Id
    @Size(min = 8)
    private String codigoUnico;

    @NotNull
    private String destinatario;

    @NotNull
    private String nome;

    @Email
    @NotNull
    private String email;

    private String ofertaEspecial;

    private int descontoPercentualFixo;

    private String codigoVoucher;

    private LocalDateTime dataValidade;

    @JsonIgnore
    private LocalDateTime dataUso;
}
