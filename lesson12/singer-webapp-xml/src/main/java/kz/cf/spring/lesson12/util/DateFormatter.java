package kz.cf.spring.lesson12.util;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ruslan beyganov on 7/12/17.
 */
@Component
public class DateFormatter implements Formatter<Date> {
	public static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Date parse(String s, Locale locale) throws ParseException {
		return formatter.parse(s);
	}

	@Override
	public String print(Date date, Locale locale) {
		return formatter.format(date);
	}

}
