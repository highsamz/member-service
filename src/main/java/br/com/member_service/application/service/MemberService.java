package br.com.member_service.application.service;

import br.com.member_service.application.dto.request.MemberRequestDTO;
import br.com.member_service.application.dto.response.MemberResponseDTO;
import br.com.member_service.application.mapper.MemberMapper;
import br.com.member_service.domain.enums.Status;
import br.com.member_service.domain.exception.MemberNotFoundException;
import br.com.member_service.infrastructure.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MemberService {

    private final MemberRepository repository;
    private final MemberMapper mapper;


    public MemberService(MemberRepository repository, MemberMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public MemberResponseDTO create(MemberRequestDTO dto) {
        var entity = mapper.toEntity(dto);
        var saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    public MemberResponseDTO read(UUID id) {
        var member = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));
        return mapper.toDTO(member);
    }

    public Page<MemberResponseDTO> readAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDTO);
    }

    public MemberResponseDTO update(UUID id, MemberRequestDTO dto) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));
        entity.setNome(dto.nome());
        entity.setSexo(dto.sexo());
        entity.setDataNascimento(dto.dataNascimento());
        entity.setIgreja(dto.igreja());
        entity.setDataFiliacao(dto.dataFiliacao());
        entity.setTelefone(dto.telefone());
        entity.setEmail(dto.email());
        entity.setRg(dto.rg());
        entity.setCpf(dto.cpf());
        entity.setGruposMinisterios(dto.gruposMinisterios());
        entity.setObservacoes(dto.observacoes());

        var updated = repository.save(entity);

        return mapper.toDTO(updated);
    }

    public void delete(UUID id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));

        entity.setStatus(Status.INATIVO);
        repository.save(entity);
    }




}
