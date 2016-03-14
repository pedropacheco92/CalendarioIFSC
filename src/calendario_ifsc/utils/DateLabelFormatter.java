package calendario_ifsc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

public class DateLabelFormatter extends AbstractFormatter {

	private String datePattern = "yyyy-MM-dd";
	private SimpleDateFormat dateFormatter = new SimpleDateFormat(this.datePattern);

	@Override
	public Object stringToValue(String text) throws ParseException {
		return this.dateFormatter.parseObject(text);
	}

	@Override
	public String valueToString(Object value) throws ParseException {
		if (value != null) {
			Calendar cal = (Calendar) value;
			return this.dateFormatter.format(cal.getTime());
		}

		return "";
	}

}