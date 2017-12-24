package Algorithm.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImgStore {
	
	  public static boolean isChinese(char c) {    
		    Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);    
		    if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS    
		        || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS    
		        || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A    
		        || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION    
		        || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION    
		        || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {    
		      return true;    
		    }    
		    return false;    
		  }    
		    
		  public static boolean isMessyCode(String strName) {    
		    Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");    
		    Matcher m = p.matcher(strName);    
		    String after = m.replaceAll("");    
		    String temp = after.replaceAll("\\p{P}", "");    
		    char[] ch = temp.trim().toCharArray();    
		    float chLength = ch.length;    
		    float count = 0;    
		    for (int i = 0; i < ch.length; i++) {    
		      char c = ch[i];    
		      if (!Character.isLetterOrDigit(c)) {    
		    
		        if (!isChinese(c)) {    
		          count = count + 1;    
		         // System.out.print(c);    
		        }    
		      }    
		    }    
		    float result = count / chLength;    
		    if (result > 0.4) {    
		      return true;    
		    } else {    
		      return false;    
		    }    
		    
		  }
		      
	
	public static void main(String[] args) {
/*		String st="\\xF0\\x9F";
		Boolean b=st.contains();
				System.out.println(b);*/
	    System.out.println(isMessyCode("法官"));    
	    System.out.println(isMessyCode("珊??"));    
	    System.out.println(isMessyCode("菜????")); 
	    System.out.println(isMessyCode("幽若芷兰?? ")); 
	    System.out.println(isMessyCode("????。   鹏洲")); 
	    System.out.println(isMessyCode("娟儿 ")); 
	    System.out.println(isMessyCode("和???"));
	}
		
	
	
	/**
	 * 
	 **/
		
	static class EmojiFilter {


		/**
		* 检测是否有emoji字符
		* @param source
		* @return 一旦含有就抛出
		*/
		public static boolean containsEmoji(String source) {
		if (StringUtils.isBlank(source)) {
		return false;
		}

		int len = source.length();

		for (int i = 0; i < len; i++) {
		char codePoint = source.charAt(i);

		if (isEmojiCharacter(codePoint)) {
		//do nothing，移动时代，判断到了这里表明，确认有表情字符
		return true;
		}
		}

		return false;
		}


		private static boolean isEmojiCharacter(char codePoint) {
		return (codePoint == 0x0) ||
		(codePoint == 0x9) ||
		(codePoint == 0xA) ||
		(codePoint == 0xD) ||
		((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
		((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
		((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
		}

		/**
		* 过滤emoji 或者 其他非文字类型的字符
		* @param source
		* @return
		*/
		public static String filterEmoji(String source) {

		if (!containsEmoji(source)) {
		return source;//如果不包含，直接返回
		}
		return "";
		}

		}
	}
	

