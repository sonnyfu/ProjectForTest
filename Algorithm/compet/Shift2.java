package compet;

import java.util.Scanner;

public class Shift2 {
    public static void main(String[] args) { 
    	//
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String s = scan.nextLine();
            char[] str = s.toCharArray();

    		
    		int begin,end=str.length-1;
    		for(begin=str.length-1;begin>=0;begin--){
    			if(str[begin]>64&&str[begin]<97){
    				if(begin==end)
    					end--;
    				else{
    					int i=begin;
    					char temp=str[begin];
    					while(i<end){
    						str[i]=str[++i];
    					}
    					str[end]=temp;
    					end--;
    				}					
    			}	
    		}
            System.out.println(new String(str));
        }

        scan.close();  
    }
}
