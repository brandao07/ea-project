-- Begin transaction
BEGIN;

-- Create Tables
DO
$$
BEGIN

create table "user" (
  UserId       serial not null, 
  RoleRoleId   int4 not null, 
  TeamTeamId   int4 not null, 
  Name         varchar(255), 
  Email        varchar(255), 
  Password     varchar(255), 
  Gender       varchar(255), 
  Age          int4 not null, 
  Height       float8 not null, 
  Weight       float8 not null, 
  IsActive     bool not null, 
  RegisterDate timestamp,
  PhotographyPath varchar(255));
create table Trial (
  TrialId                  serial not null, 
  StateStateId             int4 not null, 
  CompetitionCompetitionId int4 not null, 
  GradeGradeId             int4 not null, 
  TypeTypeId               int4 not null, 
  LocationLocationId       int4 not null, 
  UserUserId               int4 not null, 
  Name                     varchar(255), 
  StartDate                timestamp, 
  Distance                 float8 not null, 
  DistanceUnit             varchar(255), 
  NumberOfCheckpoints      int4 not null, 
  IsActive                 bool not null, 
  CreationDate             timestamp);
create table Competition (
  CompetitionId serial not null, 
  Name          varchar(255), 
  StartDate     timestamp, 
  EndDate       timestamp, 
  IsActive      bool not null, 
  CreationDate  timestamp);
create table Result (
  ResultId     serial not null, 
  TrialTrialId int4 not null, 
  Position     int4 not null, 
  Time         timestamp, 
  Observations varchar(255), 
  PenaltyTime  timestamp, 
  CreationDate timestamp);
create table Grade (
  GradeId      serial not null, 
  Name         varchar(255), 
  MinAge       int4 not null, 
  MaxAge       int4 not null, 
  MinWeight    float8 not null, 
  MaxWeight    float8 not null, 
  MinHeight    float8 not null, 
  MaxHeight    float8 not null, 
  Gender       varchar(255), 
  CreationDate timestamp);
create table Location (
  LocationId   serial not null, 
  Latitude     float4 not null, 
  Longitude    float4 not null, 
  Address      varchar(255), 
  City         varchar(255), 
  Country      varchar(255), 
  PostalCode   varchar(255), 
  CreationDate timestamp);
create table Notification (
  NotificationId           serial not null, 
  CompetitionCompetitionId int4 not null, 
  MessageHeader            varchar(255), 
  MessageBody              varchar(255), 
  MessageType              varchar(255), 
  CreationDate             timestamp);
create table Club (
  ClubId       serial not null, 
  Name         varchar(255), 
  IsActive     bool not null, 
  CreationDate timestamp);
create table Team (
  TeamId       serial not null, 
  ClubClubId   int4 not null, 
  Name         varchar(255), 
  IsActive     bool not null, 
  CreationDate timestamp);
create table Type (
  TypeId          serial not null, 
  Name            varchar(255), 
  NumberOfPersons int4 not null, 
  CreationDate    timestamp);
create table State (
  StateId      serial not null, 
  Nome         varchar(255), 
  CreationDate timestamp);
create table Role (
  RoleId       serial not null, 
  Name         varchar(255), 
  Description  varchar(255), 
  CreationDate timestamp);

END
$$;

-- Add primary keys and constraints
DO
$$
BEGIN

alter table "user" add primary key (UserId);
alter table Trial add primary key (TrialId);
alter table Competition add primary key (CompetitionId);
alter table Result add primary key (ResultId);
alter table Grade add primary key (GradeId);
alter table Location add primary key (LocationId);
alter table Notification add primary key (NotificationId);
alter table Club add primary key (ClubId);
alter table Team add primary key (TeamId);
alter table Type add primary key (TypeId);
alter table State add primary key (StateId);
alter table Role add primary key (RoleId);

alter table "user" add constraint Federated foreign key (TeamTeamId) references Team (TeamId);
alter table Team add constraint Owns foreign key (ClubClubId) references Club (ClubId);
alter table "user" add constraint Belongs foreign key (RoleRoleId) references Role (RoleId);
alter table Trial add constraint Participates foreign key (UserUserId) references "user" (UserId);
alter table Trial add constraint Occurs foreign key (LocationLocationId) references Location (LocationId);
alter table Trial add constraint Restricts foreign key (TypeTypeId) references Type (TypeId);
alter table Trial add constraint Requires foreign key (GradeGradeId) references Grade (GradeId);
alter table Trial add constraint Fulfill foreign key (CompetitionCompetitionId) references Competition (CompetitionId);
alter table Notification add constraint Issue foreign key (CompetitionCompetitionId) references Competition (CompetitionId);
alter table Result add constraint Publish foreign key (TrialTrialId) references Trial (TrialId);
alter table Trial add constraint Changes foreign key (StateStateId) references State (StateId);

END
$$;

-- Insert default data
DO
$$
BEGIN

INSERT INTO public.Role(
	RoleId, Name, Description, CreationDate)
	VALUES (1, 'Administrator', 'Admin Role', CURRENT_TIMESTAMP);
	
INSERT INTO public.Club(
	ClubId, Name, IsActive, CreationDate)
	VALUES (1, 'Test Club', true, CURRENT_TIMESTAMP);
	
INSERT INTO public.Team(
	TeamId, ClubClubId, Name, IsActive, CreationDate)
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
