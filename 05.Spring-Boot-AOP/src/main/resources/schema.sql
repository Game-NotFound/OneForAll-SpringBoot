CREATE TABLE IF NOT EXISTS sys_log
(
    id          BIGINT       NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
    username    VARCHAR(50)  NULL COMMENT 'User name',
    operation   VARCHAR(50)  NULL COMMENT 'User operation',
    time        INT          NULL COMMENT 'Response time',
    method      VARCHAR(200) NULL COMMENT 'Request method',
    params      VARCHAR(500) NULL COMMENT 'Request parameters',
    ip          VARCHAR(64)  NULL COMMENT 'IP address',
    create_time DATETIME     NULL COMMENT 'Creation time',
    PRIMARY KEY (id)
);
