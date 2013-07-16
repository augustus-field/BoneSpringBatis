package com.bone.dao;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class H2BaseDao  extends SqlMapClientDaoSupport {
	// Use annotation to call H2 datasource
	// No spring transaction involved
	@Resource(name="h2SqlMapClient")
	public void setSuperSqlMapClient(SqlMapClient client){
		super.setSqlMapClient(client);
	}
}
