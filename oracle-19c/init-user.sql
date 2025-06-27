-- init-user.sql
-- Creates user and grants privileges on first run
ALTER SESSION SET "_ORACLE_SCRIPT"=true;
CREATE USER zeus IDENTIFIED BY pwdtrainer;
GRANT CONNECT, RESOURCE, DBA TO zeus;
