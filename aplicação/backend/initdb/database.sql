-- Begin transaction
BEGIN;

-- Create Tables
DO
$$
BEGIN

create table "user" (
  Id              serial not null, 
  RoleRoleId      int4 not null, 
  TeamTeamId      int4, 
  Name            varchar(255), 
  Email           varchar(255), 
  Password        varchar(255), 
  Gender          varchar(255), 
  Age             int4 not null, 
  Height          float8 not null, 
  Weight          float8 not null, 
  IsActive        bool not null, 
  RegisterDate    timestamp, 
  PhotographyPath varchar(255));
create table trial (
  Id                       serial not null, 
  StateStateId             int4 not null, 
  CompetitionCompetitionId int4 not null, 
  GradeGradeId             int4 not null, 
  TypeTypeId               int4 not null, 
  LocationLocationId       int4 not null, 
  Name                     varchar(255), 
  StartDate                timestamp, 
  Distance                 float8 not null, 
  DistanceUnit             varchar(255), 
  NumberOfCheckpoints      int4 not null, 
  IsActive                 bool not null, 
  CreationDate             timestamp);
create table competition (
  Id           serial not null, 
  Name         varchar(255), 
  StartDate    timestamp, 
  EndDate      timestamp, 
  IsActive     bool not null, 
  CreationDate timestamp);
create table result (
  Id           serial not null, 
  TrialTrialId int4 not null, 
  Position     int4 not null, 
  Time         timestamp, 
  Observations varchar(255), 
  PenaltyTime  timestamp, 
  CreationDate timestamp);
create table grade (
  Id           serial not null, 
  Name         varchar(255), 
  MinAge       int4 not null, 
  MaxAge       int4 not null, 
  MinWeight    float8 not null, 
  MaxWeight    float8 not null, 
  MinHeight    float8 not null, 
  MaxHeight    float8 not null, 
  Gender       varchar(255), 
  CreationDate timestamp);
create table location (
  Id           serial not null, 
  Latitude     float4 not null, 
  Longitude    float4 not null, 
  Address      varchar(255), 
  City         varchar(255), 
  Country      varchar(255), 
  PostalCode   varchar(255), 
  CreationDate timestamp);
create table notification (
  Id                       serial not null, 
  CompetitionCompetitionId int4 not null, 
  MessageHeader            varchar(255), 
  MessageBody              varchar(255), 
  MessageType              varchar(255), 
  CreationDate             timestamp, 
  competitionIndex         int4);
create table club (
  Id           serial not null, 
  Name         varchar(255), 
  IsActive     bool not null, 
  CreationDate timestamp);
create table team (
  Id           serial not null, 
  ClubClubId   int4, 
  Name         varchar(255), 
  IsActive     bool not null, 
  CreationDate timestamp);
create table type (
  Id              serial not null, 
  Name            varchar(255), 
  NumberOfPersons int4 not null, 
  CreationDate    timestamp);
create table state (
  Id           serial not null, 
  name         varchar(255), 
  CreationDate timestamp);
create table role (
  Id           serial not null, 
  Name         varchar(255), 
  Description  varchar(255), 
  CreationDate timestamp);
create table trial_user (
  TrialId int4 not null, 
  UserId  int4 not null);

END
$$;

-- Add primary keys and constraints
DO
$$
BEGIN

alter table "user" add primary key (Id);
alter table trial add primary key (Id);
alter table competition add primary key (Id);
alter table result add primary key (Id);
alter table grade add primary key (Id);
alter table location add primary key (Id);
alter table notification add primary key (Id);
alter table club add primary key (Id);
alter table team add primary key (Id);
alter table type add primary key (Id);
alter table state add primary key (Id);
alter table role add primary key (Id);
alter table trial_user add primary key (TrialId, UserId);

alter table "user" add constraint Federated foreign key (TeamTeamId) references team (Id);
alter table team add constraint Owns foreign key (ClubClubId) references club (Id);
alter table "user" add constraint Belongs foreign key (RoleRoleId) references role (Id);
alter table trial add constraint Occurs foreign key (LocationLocationId) references location (Id);
alter table trial add constraint Restricts foreign key (TypeTypeId) references type (Id);
alter table trial add constraint Requires foreign key (GradeGradeId) references grade (Id);
alter table trial add constraint Fulfill foreign key (CompetitionCompetitionId) references competition (Id);
alter table notification add constraint Issue foreign key (CompetitionCompetitionId) references competition (Id);
alter table result add constraint Publish foreign key (TrialTrialId) references trial (Id);
alter table trial add constraint Changes foreign key (StateStateId) references state (Id);
alter table trial_user add constraint Participates foreign key (TrialId) references trial (Id);
alter table trial_user add constraint Participates2 foreign key (UserId) references "user" (Id);

END
$$;

-- Insert default data
DO
$$
BEGIN

INSERT INTO public.Role(
	Id, Name, Description, CreationDate)
	VALUES (1, 'Administrator', 'Admin Role', CURRENT_TIMESTAMP),
         (2, 'Default', 'Default Role', CURRENT_TIMESTAMP),
         (3, 'TeamOwner', 'Team Owner Role', CURRENT_TIMESTAMP),
         (4, 'ClubOwner', 'Club Owner Role', CURRENT_TIMESTAMP);
	
INSERT INTO public.Club(
	Id, Name, IsActive, CreationDate)
	VALUES (1, 'Test Club', true, CURRENT_TIMESTAMP);
	
INSERT INTO public.Team(
	Id, ClubClubId, Name, IsActive, CreationDate)
	VALUES (1, 1, 'Test Team', true, CURRENT_TIMESTAMP);

-- password for every user: password
INSERT INTO public.User(
    RoleRoleId, TeamTeamId, Name, Email, Password, Gender, Age, Height, Weight, IsActive, RegisterDate, PhotographyPath)
VALUES 
    (1, 1, 'Eduardo Oliveira', 'eoliveira@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Male', '33', '186', '87', true, CURRENT_TIMESTAMP, null),
    (1, 1, 'Miguel Senra', 'msenra@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Male', '28', '180', '75', true, CURRENT_TIMESTAMP, null),
    (1, 1, 'Emanuel Silva', 'esilva@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Male', '20', '175', '70', true, CURRENT_TIMESTAMP, null),
    (1, 1, 'Dinis Estrada', 'destrada@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Male', '18', '178', '78', true, CURRENT_TIMESTAMP, null),
    (1, 1, 'André Brandão', 'abrandao@mail.com', '$2a$10$e32oMMN2z4Jnhg8O471ekeAkyuxXtyq.BbzF8sqx9FCyWln8mPER.', 'Male', '25', '182', '80', true, CURRENT_TIMESTAMP, null);

END
$$;

-- Commit the transaction if no errors occurred
COMMIT;
