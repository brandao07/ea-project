-- Begin transaction
BEGIN;

-- Insert initial default data
INSERT INTO public.role(Id, Name, Description, CreationDate)
VALUES 
    (1, 'Administrator', 'Admin Role', CURRENT_TIMESTAMP),
    (2, 'Default', 'Default Role', CURRENT_TIMESTAMP),
    (3, 'Participant', 'Participant Role', CURRENT_TIMESTAMP),
    (4, 'Judge', 'Judge Role', CURRENT_TIMESTAMP);

-- Insert clubs
INSERT INTO public.club(Id, Name, Isactive, Creationdate)
VALUES
    (1, 'Clube de Remo de Braga', true, CURRENT_TIMESTAMP),
    (2, 'Clube de Canoagem de Lisboa', true, CURRENT_TIMESTAMP),
    (3, 'Porto Paddlers', true, CURRENT_TIMESTAMP),
    (4, 'Algarve Kayakers', true, CURRENT_TIMESTAMP),
    (5, 'Canoístas de Coimbra', true, CURRENT_TIMESTAMP);

-- Insert teams
INSERT INTO public.team(Id, clubId, Name, Isactive, Creationdate)
VALUES
    (1, 2, 'Lisboa Team A', true, CURRENT_TIMESTAMP),
    (2, 2, 'Lisboa Team B', true, CURRENT_TIMESTAMP),
    (3, 3, 'Porto Team A', true, CURRENT_TIMESTAMP),
    (4, 3, 'Porto Team B', true, CURRENT_TIMESTAMP),
    (5, 4, 'Algarve Team A', true, CURRENT_TIMESTAMP),
    (6, 5, 'Coimbra Team A', true, CURRENT_TIMESTAMP),
    (7, 5, 'Coimbra Team B', true, CURRENT_TIMESTAMP),
    (8, 1, 'Braga Team A', true, CURRENT_TIMESTAMP),
    (9, 1, 'Braga Team B', true, CURRENT_TIMESTAMP);

-- Insert location data
INSERT INTO public.location(Id, Latitude, Longitude, Address, City, Country, Postalcode, Creationdate)
VALUES
    (1, 38.736946, -9.142685, 'Belem', 'Lisboa', 'Portugal', '1300-598', CURRENT_TIMESTAMP),
    (2, 41.157944, -8.629105, 'Ribeira', 'Porto', 'Portugal', '4050-553', CURRENT_TIMESTAMP),
    (3, 37.017953, -7.930834, 'Praia de Faro', 'Faro', 'Portugal', '8005-554', CURRENT_TIMESTAMP),
    (4, 40.203314, -8.410257, 'Parque Verde do Mondego', 'Coimbra', 'Portugal', '3000-393', CURRENT_TIMESTAMP),
    (5, 41.545448, -8.426507, 'Parque da Ponte', 'Braga', 'Portugal', '4700-303', CURRENT_TIMESTAMP);

-- Insert state data
INSERT INTO public.state(Id, Name, Creationdate)
VALUES
    (1, 'Em Andamento', CURRENT_TIMESTAMP),
    (2, 'Finalizado', CURRENT_TIMESTAMP),
    (3, 'Agendado', CURRENT_TIMESTAMP),
    (4, 'Cancelado', CURRENT_TIMESTAMP),
    (5, 'Adiado', CURRENT_TIMESTAMP);

-- Insert competition data
INSERT INTO public.competition(Id, Name, Startdate, Enddate, Isactive, Creationdate)
VALUES
    (1, 'Campeonato Nacional de Canoagem', '2024-07-01 09:00:00', '2024-07-10 18:00:00', true, CURRENT_TIMESTAMP),
    (2, 'Taça Regional de Canoagem', '2024-08-01 09:00:00', '2024-08-05 18:00:00', true, CURRENT_TIMESTAMP),
    (3, 'Desafio de Canoagem de Verão', '2024-09-01 09:00:00', '2024-09-03 18:00:00', true, CURRENT_TIMESTAMP),
    (4, 'Clássico de Canoagem de Outono', '2024-10-01 09:00:00', '2024-10-05 18:00:00', true, CURRENT_TIMESTAMP),
    (5, 'Desafio de Paddling de Inverno', '2024-11-01 09:00:00', '2024-11-03 18:00:00', true, CURRENT_TIMESTAMP);

-- Insert grade data
INSERT INTO public.grade(Id, Name, Minage, Maxage, Gender, Creationdate)
VALUES
    (1, 'Masculino', 18, 60, 'Masculino', CURRENT_TIMESTAMP),
    (2, 'Feminino', 18, 60, 'Feminino', CURRENT_TIMESTAMP);

-- Insert notification data
INSERT INTO public.notification(Id, competitionId, Messageheader, Messagebody, Messagetype, Creationdate)
VALUES
    (1, 1, 'Nova Prova Adicionada', 'Uma nova prova foi adicionada ao Campeonato Nacional de Canoagem.', 'Info', CURRENT_TIMESTAMP),
    (2, 2, 'Atualização da Competição', 'O cronograma da Taça Regional de Canoagem foi atualizado.', 'Update', CURRENT_TIMESTAMP),
    (3, 3, 'Lembrete', 'Não se esqueça de se inscrever no Desafio de Canoagem de Verão.', 'Reminder', CURRENT_TIMESTAMP),
    (4, 4, 'Novo Evento Adicionado', 'Um novo evento foi adicionado ao Clássico de Canoagem de Outono.', 'Info', CURRENT_TIMESTAMP),
    (5, 5, 'Alerta de Clima', 'Devido ao mau tempo esperado, o Desafio de Paddling de Inverno pode ser adiado.', 'Alert', CURRENT_TIMESTAMP);

-- Insert type data
INSERT INTO public.type(Id, Name, Numberofpersons, Creationdate)
VALUES
    (1, 'K1', 1, CURRENT_TIMESTAMP),
    (2, 'K2', 2, CURRENT_TIMESTAMP),
    (3, 'K4', 4, CURRENT_TIMESTAMP),
    (4, 'C1', 1, CURRENT_TIMESTAMP),
    (5, 'C2', 2, CURRENT_TIMESTAMP),
    (6, 'C4', 4, CURRENT_TIMESTAMP);

-- password for every user: password
INSERT INTO public."user"(Id, clubId, roleId, teamId, Name, Email, Password, Gender, Age, Height, Weight, Isactive, Registerdate, Photographypath)
VALUES 
    (1, 1, 1, null, 'Eduardo Oliveira', 'eoliveira@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 33, 186, 87, true, CURRENT_TIMESTAMP, null),
    (2, 2, 1, null, 'Miguel Senra', 'msenra@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 28, 180, 75, true, CURRENT_TIMESTAMP, null),
    (3, 3, 1, null, 'Emanuel Silva', 'esilva@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 20, 175, 70, true, CURRENT_TIMESTAMP, null),
    (4, null, 1, null, 'Dinis Estrada', 'destrada@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 18, 178, 78, true, CURRENT_TIMESTAMP, null),
    (5, null, 1, null, 'André Brandão', 'abrandao@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 25, 182, 80, true, CURRENT_TIMESTAMP, null),
    (6, null, 3, 1, 'Ana Sousa', 'asousa@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 30, 165, 60, true, CURRENT_TIMESTAMP, null),
    (7, null, 3, 2, 'Bruno Costa', 'bcosta@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 22, 178, 75, true, CURRENT_TIMESTAMP, null),
    (8, null, 3, 2, 'Carla Pinto', 'cpinto@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 27, 170, 65, true, CURRENT_TIMESTAMP, null),
    (9, null, 3, 2, 'Diogo Ferreira', 'dferreira@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 29, 180, 70, true, CURRENT_TIMESTAMP, null),
    (10, null, 3, 2, 'Eva Mendes', 'emendes@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 26, 168, 62, true, CURRENT_TIMESTAMP, null),
    (11, null, 3, 3, 'Francisco Silva', 'fsilva@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 24, 177, 72, true, CURRENT_TIMESTAMP, null),
    (12, null, 3, 3, 'Gabriela Rocha', 'grocha@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 21, 165, 58, true, CURRENT_TIMESTAMP, null),
    (13, null, 3, 3, 'Helena Cruz', 'hcruz@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 23, 168, 60, true, CURRENT_TIMESTAMP, null),
    (14, null, 3, 4, 'Igor Carvalho', 'icarvalho@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 22, 180, 74, true, CURRENT_TIMESTAMP, null),
    (15, null, 4, null, 'Manuel Ribeiro', 'fedportuguesacanoagem@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 52, 180, 80, true, CURRENT_TIMESTAMP, null),
    (16, null, 3, 4, 'João Silva', 'jsilva@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 28, 180, 75, true, CURRENT_TIMESTAMP, null),
    (17, null, 3, 4, 'Rita Santos', 'rsantos@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 24, 165, 60, true, CURRENT_TIMESTAMP, null),
    (18, null, 3, 4, 'Carlos Lima', 'clima@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 30, 175, 68, true, CURRENT_TIMESTAMP, null),
    (19, null, 3, 5, 'Maria Almeida', 'malmeida@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 27, 170, 62, true, CURRENT_TIMESTAMP, null),
    (20, null, 3, 5, 'Pedro Costa', 'pcosta@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 25, 178, 72, true, CURRENT_TIMESTAMP, null),
    (21, null, 3, 6, 'Sofia Nunes', 'snunes@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 29, 168, 64, true, CURRENT_TIMESTAMP, null),
    (22, null, 3, 6, 'Miguel Ferreira', 'mferreira@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 26, 176, 71, true, CURRENT_TIMESTAMP, null),
    (23, null, 3, 5, 'Ana Martins', 'amartins@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 28, 172, 65, true, CURRENT_TIMESTAMP, null),
    (24, null, 3, 7, 'Rui Pereira', 'rpereira@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 24, 180, 70, true, CURRENT_TIMESTAMP, null),
    (25, null, 3, 7, 'Sandra Silva', 'ssilva@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 27, 165, 58, true, CURRENT_TIMESTAMP, null),
    (26, null, 3, 8, 'Tiago Rocha', 'trocha@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 25, 177, 69, true, CURRENT_TIMESTAMP, null),
    (27, null, 3, 8, 'Paula Costa', 'pcosta@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 29, 170, 61, true, CURRENT_TIMESTAMP, null),
    (28, null, 3, 8, 'Vasco Lima', 'vlima@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 26, 179, 70, true, CURRENT_TIMESTAMP, null),
    (29, null, 3, 8, 'Helena Cruz', 'hcruz@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 24, 168, 64, true, CURRENT_TIMESTAMP, null),
    (30, null, 3, 9, 'Luis Ribeiro', 'lribeiro@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 27, 175, 68, true, CURRENT_TIMESTAMP, null),
    (31, null, 3, 9, 'Isabel Alves', 'ialves@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 28, 170, 62, true, CURRENT_TIMESTAMP, null),
    (32, null, 3, 9, 'André Lopes', 'alopes@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Masculino', 29, 178, 70, true, CURRENT_TIMESTAMP, null),
    (33, null, 3, 9, 'Carla Silva', 'csilva@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Feminino', 26, 167, 61, true, CURRENT_TIMESTAMP, null);

-- Insert trial data
INSERT INTO public.trial(Id, stateId, competitionId, gradeId, typeId, locationId, Name, Startdate, Distance, Distanceunit, Isactive, Creationdate)
    VALUES
        (1, 3, 1, 1, 1, 1, 'Prova 1 - Nacional', ('2024-07-01 09:00:00')::timestamp, 500.0, 'metros', true, CURRENT_TIMESTAMP),
        (2, 3, 2, 1, 1, 1, 'Prova 2 - Regional', ('2024-08-02 09:00:00')::timestamp, 1000.0, 'metros', true, CURRENT_TIMESTAMP),
        (3, 3, 3, 1, 1, 1, 'Prova 3 - Verão', ('2024-09-03 09:00:00')::timestamp, 1500.0, 'metros', true, CURRENT_TIMESTAMP),
        (4, 3, 4, 2, 2, 2, 'Prova 4 - Outono', ('2024-10-04 09:00:00')::timestamp, 2000.0, 'metros', true, CURRENT_TIMESTAMP),
        (5, 3, 5, 2, 2, 2, 'Prova 5 - Inverno', ('2024-11-05 09:00:00')::timestamp, 2500.0, 'metros', true, CURRENT_TIMESTAMP);

COMMIT;
