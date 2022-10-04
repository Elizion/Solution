package com.ear.core.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.ear.core.enums.PeriodicityEnum;

@Service
public class TestServiceImpl implements TestService {
		
	@Override
	public ArrayList<String> createListDates(String dateInit, String dateEnd, String timezone, String periodicity) {

		ArrayList<String> listDates = new ArrayList<String>();
		PeriodicityEnum periodicityEnum = PeriodicityEnum.getPeriodicityEnum(periodicity);
		
		SimpleDateFormat sdfTtimezone = null;
		
	    switch(periodicityEnum) {
	      case DAY:
	    	  sdfTtimezone = new SimpleDateFormat("yyyy-MM-dd");
	    	  break;
	      case HOUR:
	    	  sdfTtimezone = new SimpleDateFormat("yyyy-MM-dd HH");
	    	  dateInit = dateInit + " 00";
	    	  dateEnd = dateEnd + " 23";
	    	  break;
	      case FIVE_MINUTAL:
	    	  sdfTtimezone = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    	  dateInit = dateInit + " 00:00";
	    	  dateEnd = dateEnd + " 23:55";
	    	  break;
	    }
	    
		try {

			TimeZone tz = TimeZone.getTimeZone(timezone);
			sdfTtimezone.setTimeZone(tz);

			Calendar calendar = Calendar.getInstance(tz);

			Date dateInit_ = sdfTtimezone.parse(dateInit);
			Date dateEnd_ = sdfTtimezone.parse(dateEnd);

			calendar.setTime(dateInit_);

			while (dateInit_.compareTo(dateEnd_) <= 0) {

				String dateAsString = sdfTtimezone.format(dateInit_);
				listDates.add(dateAsString);
				calendar.add(Calendar.MINUTE, 5);
				dateInit_ = calendar.getTime();

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return listDates;
		
	}
	
}
