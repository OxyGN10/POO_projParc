-- SGBD: PostgreSQL

create table COMPONENTES (
    LATTES_ID BIGINT,
    NOME VARCHAR(128) not null,

    constraint COMPONENTES_pk primary key(LATTES_ID)
);

insert into COMPONENTES VALUES(-255, 'SISTEMA');

create table PROJETOS (
    COD_PROJ INTEGER GENERATED always as identity,
    TITULO VARCHAR(256) not null,
    TIPO VARCHAR(64) not null,
    INICIO date default current_date,
    FIM date,

    constraint PROJETOS_pk primary key(COD_PROJ)
);

create table COMP_PROJ (
    COD_COMP INTEGER GENERATED always as identity,
    PROJETO INTEGER not null,
    FUNCAO VARCHAR(64) not null,
    ESTADO VARCHAR(64) not null default 'ativo' check (ESTADO in ('ativo', 'desligado', 'suspenso')),
    ENTRADA DATE not NULL default current_date,
    SAIDA DATE,

    constraint COMP_PROJ_pk primary key(COD_COMP),
    constraint COMP_PROJ_fk foreign key(PROJETO) references PROJETOS(COD_PROJ) on delete cascade
);

alter table COMP_PROJ add column COMPONENTE INTEGER
alter table COMP_PROJ ADD constraint COMP_PROJ_fk2 foreign key(COMPONENTE) references COMPONENTES(LATTES_ID) on delete CASCADE;

create table AVISOS (
    COD_AVISO INTEGER GENERATED always as identity,
    PROJETO INTEGER not null,
    REMETENTE INTEGER,
    PUBLICACAO timestamptz not null default current_timestamp,

    constraint AVISOS_pk primary key(COD_AVISO),
    constraint AVISOS_fk1 foreign key(PROJETO) references PROJETOS(COD_PROJ) on delete cascade,
    constraint AVISOS_fk2 foreign key(REMETENTE) references COMPONENTES(LATTES_ID) on delete set null
);

create table ATIVIDADES (
    COD_ATIVIDADE INTEGER generated always as identity,
    PROJETO INTEGER not null,
    INICIO DATE not null,
    FIM DATE not null,
    SITUACAO VARCHAR(64) not null default 'pendente' check (SITUACAO in ('pendente', 'em andamento', 'em atraso', 'concluida')),

    constraint ATIVIDADES_pk primary key(COD_ATIVIDADE),
    constraint ATIVIDADES_fk foreign key(PROJETO) references PROJETOS(COD_PROJ) on delete cascade
);