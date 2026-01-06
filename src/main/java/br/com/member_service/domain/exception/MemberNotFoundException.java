package br.com.member_service.domain.exception;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(Long id) {
        super("Membro não encontrado com id: " + id);
    }
}