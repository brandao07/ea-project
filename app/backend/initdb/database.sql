-- Begin transaction
BEGIN;

-- Create Tables
DO
$$
BEGIN

create table "user" (
  Id              int4 not null, 
  clubId          int4, 
  roleId          int4 not null, 
  teamId          int4, 
  Name            varchar(255), 
  Email           varchar(255), 
  Password        varchar(255), 
  Gender          varchar(255), 
  Age             int4 not null, 
  Height          float8 not null, 
  Weight          float8 not null, 
  Isactive        bool not null, 
  Registerdate    timestamp, 
  Photographypath varchar(255));
create table trial (
  Id            int4 not null, 
  stateId       int4 not null,
  competitionId int4 not null,
  locationId    int4 not null,
  Name          varchar(255),
  Startdate     timestamp,
  Modality      varchar(255),
  Distance      float8 not null, 
  Distanceunit  varchar(255), 
  Isactive      bool not null, 
  Creationdate  timestamp);
create table competition (
  Id           int4 not null,
  Name    varchar(255),
  gradeId int4 not null,
  gender  varchar(255),
  typeId  int4 not null,
  userId  int4 not null,
  Startdate    timestamp,
  Enddate timestamp,
  Isactive     bool not null, 
  Creationdate timestamp);
create table result (
  Id           int4 not null, 
  Position     int4 not null, 
  Time         timestamp, 
  Observations varchar(255), 
  Penaltytime  timestamp, 
  Creationdate timestamp);
create table grade (
  Id           int4 not null, 
  Name         varchar(255), 
  Minage       int4 not null,
  Maxage int4 not null,
  Creationdate timestamp);
create table location (
  Id           int4 not null, 
  Latitude     float8 not null, 
  Longitude    float8 not null, 
  Address      varchar(255), 
  City         varchar(255), 
  Country      varchar(255), 
  Postalcode   varchar(255), 
  Creationdate timestamp);
create table notification (
  Id              int4 not null, 
  competitionId   int4 not null, 
  Messageheader   varchar(255), 
  Messagebody     varchar(255), 
  Messagetype     varchar(255), 
  Photographypath varchar(255), 
  Creationdate    timestamp);
create table club (
  Id           int4 not null, 
  Name         varchar(255), 
  Isactive     bool not null, 
  Creationdate timestamp);
create table team (
  Id           int4 not null, 
  clubId       int4, 
  Name         varchar(255), 
  Isactive     bool not null, 
  Creationdate timestamp);
create table type (
  Id              int4 not null, 
  Name            varchar(255), 
  Numberofpersons int4, 
  Creationdate    timestamp);
create table state (
  Id           int4 not null, 
  Name         varchar(255), 
  Creationdate timestamp);
create table role (
  Id           int4 not null, 
  Name         varchar(255), 
  Description  varchar(255), 
  Creationdate timestamp);
create table result_trial (
  ResultId int4 not null, 
  TrialId  int4 not null);
create table trial_team (
  TrialId int4 not null, 
  TeamId  int4 not null);


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
alter table result_trial add primary key (ResultId, TrialId);
alter table trial_team add primary key (TrialId, TeamId);


alter table "user" add constraint Federated foreign key (teamId) references team (Id);
alter table team add constraint Owns foreign key (clubId) references club (Id);
alter table "user" add constraint Belongs foreign key (roleId) references role (Id);
alter table trial add constraint Occurs foreign key (locationId) references location (Id);
alter table competition
    add constraint Restricts foreign key (typeId) references type (Id);
alter table competition
    add constraint Requires foreign key (userId) references "user" (Id);
alter table competition
    add constraint Requires2 foreign key (gradeId) references grade (Id);
alter table trial add constraint Fulfill foreign key (competitionId) references competition (Id);
alter table result_trial add constraint Publish foreign key (ResultId) references result (Id);
alter table result_trial add constraint Publish2 foreign key (TrialId) references trial (Id);
alter table trial add constraint Changes foreign key (stateId) references state (Id);
alter table "user" add constraint Owns2 foreign key (clubId) references club (Id);
alter table notification add constraint Issue foreign key (competitionId) references competition (Id);
alter table trial_team add constraint Participates foreign key (TrialId) references trial (Id);
alter table trial_team add constraint Participates2 foreign key (TeamId) references team (Id);

END
$$;

-- Commit the transaction if no errors occurred
COMMIT;
