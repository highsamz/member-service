package br.com.member_service.domain.exception;

import java.util.UUID;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(UUID id) {
        super("Membro não encontrado com id: " + id);
    }
}