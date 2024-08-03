package com.hauhh.dao.impl;

import com.hauhh.dao.SysDAO;
import com.hauhh.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SysDAOImpl implements SysDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    SysDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveSysLog(SysLog sysLog) {
        StringBuffer sql = new StringBuffer("INSERT INTO sys_log");
        sql.append("(id, username, operation, time, method, params, ip, create_time) ");
        sql.append(" VALUES (seq_sys_log.nextval, :username, :operation, :time, :method, :params, :ip, :createTime)");

        NamedParameterJdbcTemplate namedParam = new NamedParameterJdbcTemplate(jdbcTemplate);
        namedParam.update(sql.toString(), new BeanPropertySqlParameterSource(sysLog));
    }
}
