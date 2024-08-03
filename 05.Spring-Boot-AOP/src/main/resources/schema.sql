CREATE TABLE IF NOT EXISTS sys_log
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    username    VARCHAR(50)  NULL,
    operation   VARCHAR(50)  NULL,
    time        INT          NULL,
    method      VARCHAR(200) NULL,
    params      VARCHAR(500) NULL,
    ip          VARCHAR(64)  NULL,
    create_time DATETIME     NULL,
    PRIMARY KEY (id)
);
COMMENT ON COLUMN SYS_LOG.USERNAME IS 'User name';
COMMENT ON COLUMN SYS_LOG.OPERATION IS 'User operation';
COMMENT ON COLUMN SYS_LOG.TIME IS 'Response time';
COMMENT ON COLUMN SYS_LOG.METHOD IS 'Request method';
COMMENT ON COLUMN SYS_LOG.PARAMS IS 'Request parameters';
COMMENT ON COLUMN SYS_LOG.IP IS 'IP address';
COMMENT ON COLUMN SYS_LOG.CREATE_TIME IS 'Creation time';
CREATE SEQUENCE seq_sys_log START WITH 1 INCREMENT BY 1;