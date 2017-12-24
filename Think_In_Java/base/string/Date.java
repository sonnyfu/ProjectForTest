package Think_In_Java.base.string;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;

public class Date {

	void return1() {
		return;
	}

	public static void main(String[] args) throws ParseException,
			UnsupportedEncodingException {
		java.util.Date d1 = new java.util.Date();
		java.util.Date d2;
		// DateFormat
		/*
		 * d1=DateFormat.getTimeInstance().parse("2016-08-31 10:16:02");
		 * d2=DateFormat.getTimeInstance().parse("2016-08-30 10:16:02");
		 */// d1=new SimpleDateFormat("yymmdd").parse("2016-08-31 10:16:02");
			// d2=new SimpleDateFormat("yymmdd").parse("2016-08-30 10:16:01");

		String req = "http://lavasoft.blog.51cto.com/62575/275589/1.html";
		req = URLEncoder.encode(req, "UTF-8");
		System.out.println(req);
		// d1.after(d1)

	}
}
