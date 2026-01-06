package br.com.member_service.application.mapper;

import br.com.member_service.application.dto.request.MemberRequestDTO;
import br.com.member_service.application.dto.response.MemberResponseDTO;
import br.com.member_service.domain.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member toEntity(MemberRequestDTO dto) {
        Member m = new Member();
        m.setNome(dto.nome());
        m.setSexo(dto.sexo());
        m.setDataNascimento(dto.dataNascimento());
        m.setIgreja(dto.igreja());
        m.setDataFiliacao(dto.dataFiliacao());
        m.setTelefone(dto.telefone());
        m.setEmail(dto.email());
        m.setRg(dto.rg());
        m.setCpf(dto.cpf());
        m.setGruposMinisterios(dto.gruposMinisterios());
        m.setObservacoes(dto.observacoes());
        return m;
    }

    public MemberResponseDTO toDTO(Member m) {
        return new MemberResponseDTO(
                m.getId(),
                m.getNome(),
                m.getSexo(),
                m.getDataNascimento(),
                m.getIdade(),
                m.getIgreja(),
                m.getDataFiliacao(),
                m.getTelefone(),
                m.getEmail(),
                m.getRg(),
                m.getCpf(),
                m.getGruposMinisterios(),
                m.getObservacoes()
        );
    }
}

