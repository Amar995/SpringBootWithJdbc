package com.config.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.config.Model.TotalSteam;
import com.config.mapper.TotalStreamMapper;

@Repository
public class StreamDurationDao {
	
    @Autowired
	private JdbcTemplate jdbc;
    
    public int getTotalUser(String startDate, String endDate)
    {
    	String sql="SELECT count(*) FROM USER_AMA WHERE  START_DATE >='" + startDate + "' AND END_DATE <='" + endDate +"'";
    	System.out.println(sql);
    	return jdbc.queryForObject(sql, Integer.class);
    }
    
    public List<TotalSteam> getTotalStream(String startDate, String endDate)
    {
		String sql="select sum(totalstreams) totalstreams, start_date, publisher_id, publisher_name, platform, provider, frequency, countryname "
				+ "from publisher_totalstreams where start_date between '" + startDate +"' and '"+endDate+"' and "
			  +	"publisher_id in ('0000073e0af872ce1af9ff084d84a6c7','0013ae846a3bcb14c790f91948d92062') and frequency = 'Daily'"
				+ "group by start_date order by start_date desc";
		
		List<TotalSteam> totalStream=jdbc.query(sql,new TotalStreamMapper());
		return  totalStream;
    	
    }
    
    public List<TotalSteam> getTotalStream(String freqency)
    {
		String sql="select sum(totalstreams) totalstreams, start_date, publisher_id, publisher_name, platform, provider, frequency, countryname "
				+ "from publisher_totalstreams where  "
			  +	"publisher_id in ('0000073e0af872ce1af9ff084d84a6c7','0013ae846a3bcb14c790f91948d92062') and frequency ='"+freqency+"'"
				+ "group by start_date order by start_date desc";
		
		List<TotalSteam> totalStream=jdbc.query(sql,new TotalStreamMapper());
		return  totalStream;
    	
    }
    public List<TotalSteam> getTotalStreambypublisherName(String publisherName)
    {
		String sql="select sum(totalstreams) totalstreams, start_date, publisher_id, publisher_name, platform, provider, frequency, countryname "
				+ "from publisher_totalstreams where  "
			  +	" publisher_name ='"+publisherName+"'"
				+ "group by start_date order by start_date desc";
		
		List<TotalSteam> totalStream=jdbc.query(sql,new TotalStreamMapper());
		return  totalStream;
    	
    }
    
    public int getTotalStreamDuration()
    {
		return 0;
    	
    }

}
