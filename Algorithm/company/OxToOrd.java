package Algorithm.company;

public class OxToOrd {
	static int OxTo(String src){
		if(src==null||src=="")
			return 0;
		else{
			int or=0;
			src=src.substring(2);
			for(int i=src.length()-1,j=0;i>=0;i--,j++){
				if(src.charAt(i)=='A'){
					or+=(10*Math.pow(16, j));
					continue;
					}
				if(src.charAt(i)=='B'){
					or+=(11*Math.pow(16, j));
					continue;
				}
				if(src.charAt(i)=='C'){
					or+=(12*Math.pow(16, j));
					continue;
				}			
				if(src.charAt(i)=='D'){
					or+=(13*Math.pow(16, j));
					continue;
				}
				if(src.charAt(i)=='E'){
					or+=(14*Math.pow(16, j));
					continue;
				}
				if(src.charAt(i)=='F'){
					or+=(15*Math.pow(16, j));
					continue;
				}
				else
					or+=(i*Math.pow(16, j));
			}
			return or;
		}
	}
	public static void main(String[] args) {
		System.out.println(OxTo("0xAB"));
	}
}
