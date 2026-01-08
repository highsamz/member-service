CREATE TABLE member (
                        id UUID PRIMARY KEY,
                        nome VARCHAR(100) NOT NULL,
                        sexo VARCHAR(10),
                        data_nascimento DATE,
                        igreja VARCHAR(100),
                        data_filiacao DATE,
                        telefone VARCHAR(20),
                        email VARCHAR(100),
                        rg VARCHAR(20),
                        cpf VARCHAR(20),
                        grupos_ministerios TEXT,
                        observacoes TEXT,
                        status VARCHAR(20) NOT NULL DEFAULT 'ATIVO',
                        created_at TIMESTAMP NOT NULL DEFAULT NOW()
);