package com.getnet.getnet.controller;

import com.getnet.getnet.domain.Voucher;
import com.getnet.getnet.dto.ResgatarCupomDto;
import com.getnet.getnet.service.CadastrarCupomService;
import com.getnet.getnet.service.ResgatarCupomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("vouchers")
@Log4j2
@RequiredArgsConstructor
public class VoucherController {

    private final CadastrarCupomService cadastrarCupomService;
    private final ResgatarCupomService resgatarCupomService;

    @PostMapping("/save")
    @Operation(summary = "Insere informações do voucher", responses = {
            @ApiResponse(responseCode = "201", description = "Voucher cadastrado"),
            @ApiResponse(responseCode = "400", description = "Voucher inválido"),
            @ApiResponse(responseCode = "404", description = "Voucher não encontrado"),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas")})
    public ResponseEntity<Voucher> save(@RequestBody @Valid Voucher voucher) {
        return new ResponseEntity<>(cadastrarCupomService.inserirDados(voucher), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Busca informações do voucher", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "Voucher inválido"),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas"),
            @ApiResponse(responseCode = "404", description = "Voucher não encontrado")})
    public ResponseEntity<ResgatarCupomDto> buscar(@RequestParam(value = "codigoVoucher") String codigoVoucher, @RequestParam(value = "email") @Valid String email){
        return new ResponseEntity<>(resgatarCupomService.buscarDados(codigoVoucher, email), HttpStatus.OK);
    }

}
