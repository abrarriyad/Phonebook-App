package com.rashid.capp.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

// it should not independently exits in container. so no @Repository, @Service or @Component @annotation
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {
	
	@Autowired
	public void setDataSource2(DataSource datasource) {
		super.setDataSource(datasource);
	}

}
