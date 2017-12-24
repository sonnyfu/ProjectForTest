package Think_In_Java.base.JavaSe;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	public static void main(String[] args) throws ParseException {
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");

		Date date = fmt.parse("2017-01-01");
		System.out.println(date);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssZ");
//		System.out.println(sdf.format("20170101010101"));
		Calendar c=Calendar.getInstance();
		c.set(Calendar.MONTH, 00);
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		  String dateString = formatter.format(c.getTime());
		System.out.println(dateString);
	}
}
