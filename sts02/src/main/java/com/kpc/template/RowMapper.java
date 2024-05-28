package com.kpc.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface RowMapper<T> {
	public abstract T row(ResultSet rs) throws SQLException;	
}
