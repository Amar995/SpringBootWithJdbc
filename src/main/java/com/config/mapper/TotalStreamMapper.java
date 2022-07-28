package com.config.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.config.Model.TotalSteam;

public class TotalStreamMapper implements RowMapper<TotalSteam> {

	@Override
	public TotalSteam mapRow(ResultSet rs, int rowNum) throws SQLException {
		TotalSteam strem=new TotalSteam();
		strem.setPublisher_id(rs.getInt("publisher_id"));
		strem.setPublisher_name(rs.getString("publisher_name"));
		strem.setStart_date(rs.getDate("start_date"));
		strem.setTotalstreams(rs.getInt("totalstreams"));
		return strem;
	}

}
