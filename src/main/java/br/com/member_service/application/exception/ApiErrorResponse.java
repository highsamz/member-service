package br.com.member_service.application.exception;

public record ApiErrorResponse(
        int status,
        String message
) {}

