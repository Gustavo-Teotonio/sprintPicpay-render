package com.example.api_picpay.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Conta {
    @Id
    @Column(name="numero_conta")
    @Min(value=10000, message="Número da conta deve conter 4 números e 1 digito verificador")
    @Max(value=99999, message="Número da conta deve conter 4 números e 1 digito verificador")
    @Schema(description = "Número da conta", example = "45763")
    private String numeroConta;
    @Schema(description = "Saldo da conta", example = "450.25")
    private Double saldo;
    @Column(name="limite_especial")
    @Min(value=0)
    @Schema(description = "Limite especial da conta", example = "2375.24")
    private Double limiteEspecial;
    @Column(name="cliente_cpf")
    @JoinColumn(name="cpf")
    @CPF()
    @Schema(description = "CPF de um cliente já cadastrado", example = "12345678911")
    private String clienteCpf;

    public Conta(Double saldo, Double limite_especial, String cliente_cpf) {
        this.saldo = saldo;
        this.limiteEspecial = limite_especial;
        this.clienteCpf = cliente_cpf;
    }
    public Conta(){

    };

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimiteEspecial() {
        return limiteEspecial;
    }

    public void setLimiteEspecial(Double limiteEspecial) {
        this.limiteEspecial = limiteEspecial;
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    @Override
    public String toString() {
        return "ContaController{" +
                "numero_conta='" + numeroConta + '\'' +
                ", saldo=" + saldo +
                ", limite_especial=" + limiteEspecial +
                ", cliente_cpf='" + clienteCpf + '\'' +
                '}';
    }
}
