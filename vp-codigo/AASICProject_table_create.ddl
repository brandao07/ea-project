CREATE TABLE "User" (
  UserId       SERIAL NOT NULL, 
  RoleRoleId   int4 NOT NULL, 
  TeamTeamId   int4 NOT NULL, 
  Name         varchar(255), 
  Email        varchar(255), 
  Password     varchar(255), 
  Gender       varchar(255), 
  Age          int4 NOT NULL, 
  Height       float8 NOT NULL, 
  Weight       float8 NOT NULL, 
  IsActive     bool NOT NULL, 
  RegisterDate timestamp);
CREATE TABLE Trial (
  TrialId                  SERIAL NOT NULL, 
  StateStateId             int4 NOT NULL, 
  CompetitionCompetitionId int4 NOT NULL, 
  GradeGradeId             int4 NOT NULL, 
  TypeTypeId               int4 NOT NULL, 
  LocationLocationId       int4 NOT NULL, 
  UserUserId               int4 NOT NULL, 
  Name                     varchar(255), 
  StartDate                timestamp, 
  Distance                 float8 NOT NULL, 
  DistanceUnit             varchar(255), 
  NumberOfCheckpoints      int4 NOT NULL, 
  IsActive                 bool NOT NULL, 
  CreationDate             timestamp);
CREATE TABLE Competition (
  CompetitionId SERIAL NOT NULL, 
  Name          varchar(255), 
  StartDate     timestamp, 
  EndDate       timestamp, 
  IsActive      bool NOT NULL, 
  CreationDate  timestamp);
CREATE TABLE Result (
  ResultId     SERIAL NOT NULL, 
  TrialTrialId int4 NOT NULL, 
  Position     int4 NOT NULL, 
  Time         timestamp, 
  Observations varchar(255), 
  PenaltyTime  timestamp, 
  CreationDate timestamp);
CREATE TABLE Grade (
  GradeId      SERIAL NOT NULL, 
  Name         varchar(255), 
  MinAge       int4 NOT NULL, 
  MaxAge       int4 NOT NULL, 
  MinWeight    float8 NOT NULL, 
  MaxWeight    float8 NOT NULL, 
  MinHeight    float8 NOT NULL, 
  MaxHeight    float8 NOT NULL, 
  Gender       varchar(255), 
  CreationDate timestamp);
CREATE TABLE Location (
  LocationId   SERIAL NOT NULL, 
  Latitude     float4 NOT NULL, 
  Longitude    float4 NOT NULL, 
  Address      varchar(255), 
  City         varchar(255), 
  Country      varchar(255), 
  PostalCode   varchar(255), 
  CreationDate timestamp);
CREATE TABLE Notification (
  NotificationId           SERIAL NOT NULL, 
  CompetitionCompetitionId int4 NOT NULL, 
  MessageHeader            varchar(255), 
  MessageBody              varchar(255), 
  MessageType              varchar(255), 
  CreationDate             timestamp);
CREATE TABLE Club (
  ClubId       SERIAL NOT NULL, 
  Name         varchar(255), 
  IsActive     bool NOT NULL, 
  CreationDate timestamp);
CREATE TABLE Team (
  TeamId       SERIAL NOT NULL, 
  ClubClubId   int4 NOT NULL, 
  Name         varchar(255), 
  IsActive     bool NOT NULL, 
  CreationDate timestamp);
CREATE TABLE Type (
  TypeId          SERIAL NOT NULL, 
  Name            varchar(255), 
  NumberOfPersons int4 NOT NULL, 
  CreationDate    timestamp);
CREATE TABLE State (
  StateId      SERIAL NOT NULL, 
  Nome         varchar(255), 
  CreationDate timestamp);
CREATE TABLE Role (
  RoleId       SERIAL NOT NULL, 
  Name         varchar(255), 
  Description  varchar(255), 
  CreationDate timestamp);
