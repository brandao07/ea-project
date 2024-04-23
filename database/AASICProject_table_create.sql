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
  RegisterDate timestamp);
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
