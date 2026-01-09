package br.com.member_service.api.controller;

import br.com.member_service.api.dto.request.MemberRequestDTO;
import br.com.member_service.api.dto.response.MemberResponseDTO;
import br.com.member_service.application.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @PostMapping
    public ResponseEntity<MemberResponseDTO> create(@RequestBody MemberRequestDTO dto) {
        var response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> read(@PathVariable UUID id) {
        var response = service.read(id);
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<Page<MemberResponseDTO>> readAll(Pageable pageable) {
        var response = service.readAll(pageable);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> update(
            @PathVariable UUID id,
            @RequestBody @Valid MemberRequestDTO dto
    ) {
        var response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

