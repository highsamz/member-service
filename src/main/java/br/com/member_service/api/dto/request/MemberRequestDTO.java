package br.com.member_service.api.dto.request;

import br.com.member_service.domain.enums.Sexo;

import java.time.LocalDate;

public record MemberRequestDTO(
        String nome,
        Sexo sexo,
        LocalDate dataNascimento,
        String igreja,
        LocalDate dataFiliacao,
        String telefone,
        String email,
        String rg,
        String cpf,
        String gruposMinisterios,
        String observacoes
) {}