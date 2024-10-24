DROP DATABASE IF EXISTS `distributed_id`;
CREATE DATABASE IF NOT EXISTS `distributed_id` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

use `distributed_id`;

DROP TABLE IF EXISTS WORKER_NODE;
CREATE TABLE WORKER_NODE
(
    ID          BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
    HOST_NAME   VARCHAR(64) NOT NULL COMMENT 'host name',
    PORT        VARCHAR(64) NOT NULL COMMENT 'port',
    TYPE        INT         NOT NULL COMMENT 'node type: ACTUAL or CONTAINER',
    LAUNCH_DATE DATE        NOT NULL COMMENT 'launch date',
    MODIFIED    TIMESTAMP   NOT NULL COMMENT 'modified time',
    CREATED     TIMESTAMP   NOT NULL COMMENT 'created time',
    PRIMARY KEY (ID)
) COMMENT ='DB WorkerID Assigner for UID Generator', ENGINE = INNODB;