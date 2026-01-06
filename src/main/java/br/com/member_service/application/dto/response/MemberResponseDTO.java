package br.com.member_service.application.dto.response;

import br.com.member_service.domain.enums.Sexo;

import java.time.LocalDate;

public record MemberResponseDTO(
        Long id,
        String nome,
        Sexo sexo,
        LocalDate dataNascimento,
        Integer idade,
        String igreja,
        LocalDate dataFiliacao,
        String telefone,
        String email,
        String rg,
        String cpf,
        String gruposMinisterios,
        String observacoes
) {}

