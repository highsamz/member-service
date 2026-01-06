package br.com.member_service.application.controller;

import br.com.member_service.application.dto.request.MemberRequestDTO;
import br.com.member_service.application.dto.response.MemberResponseDTO;
import br.com.member_service.application.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<MemberResponseDTO> read(@PathVariable Long id) {
        var response = service.read(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<MemberResponseDTO>> readAll(Pageable pageable) {
        var response = service.readAll(pageable);
        return ResponseEntity.ok(response);
    }

}

