package br.com.member_service.domain.entity;

import br.com.member_service.domain.enums.Sexo;
import br.com.member_service.domain.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Entity
@Table(name = "member")
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid")
    private UUID id;

    private String nome;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "igreja")
    private String igreja;

    @Column(name = "data_filiacao")
    private LocalDate dataFiliacao;

    private String telefone;
    private String email;

    private String rg;
    private String cpf;

    @Column(name = "grupos_ministerios")
    private String gruposMinisterios;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Transient
    public Integer getIdade() {
        return (dataNascimento != null)
                ? Period.between(dataNascimento, LocalDate.now()).getYears()
                : null;
    }

}

