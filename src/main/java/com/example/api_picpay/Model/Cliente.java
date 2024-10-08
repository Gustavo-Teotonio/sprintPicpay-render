package com.example.api_picpay.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.boot.context.properties.bind.Name;

@Entity
public class Cliente {
    @Id
    @Size(min = 11, message="O CPF deve ter 11 digitos")
    @CPF(message="CPF Inválido")
    @Schema(description = "CPF do cliente", example = "12345678911")
    private String cpf;
    @NotNull(message = "Nome não deve ser nulo")
    @Size(min=3, message="Nome deve ter mais de 3 caracteres")
    @Schema(description = "Nome do Cliente", example = "Gustavo Teotônio")
    private String nome;
    @Email(message="Email deve ser valido")
    @Schema(description = "E-mail do cliente", example = "sla@gmail.com")
    private String email;
    @Size(min = 11, message="O Número de telefone deve conter DDD: XXXXXXXXXXX")
    @Schema(description = "Número de telefone do cliente", example = "1199999999")
    private String telefone;

    public Cliente(String cpf, String nome, String email, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    public Cliente(){

    };

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "ClienteController{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
