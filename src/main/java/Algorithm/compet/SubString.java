package Algorithm.compet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class SubString {
	/*
	 * string转换编码格式方法：getbytes("charset");汉字编码若是utf-8，为3字节；GBK为2字节;
	 * string转换为char类型，方法有charAt（）；相反为string.valueof();
	 * 人和==任何引用类型可调用tostring();
	 */
	
	public static String specifiedStr(String src,int bytes){
		int i,j=0;
		StringBuffer sb=new StringBuffer();
		char a[]=src.toCharArray();
		for(i=0;i<src.length()-1;i++){
			j+=String.valueOf(a[i]).getBytes().length;
			if(j<=bytes)
				sb.append(a[i]);
			else
				break;
				
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("中文".getBytes("GBK").length);
		
		String str1;
		str1=specifiedStr("我abc",4);
		System.out.println(str1);
		str1=specifiedStr("我abc你",6);
		System.out.println(str1);
		}

}
