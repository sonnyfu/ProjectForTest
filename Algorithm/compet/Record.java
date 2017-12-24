package compet;

import java.util.Arrays;

public class Record implements Comparable<Record>{

    //实现Comparable接口，可以利用Arrays.sort()进行自动排序
 
        private int index;
        private int count;
         
        Record(int index,int count){
            this.index=index;
            this.count=count;
        }
        
        public Record() {
			// TODO Auto-generated constructor stub
		}
        
		//题目要求为降序，所以将二者的位置颠倒了,
        public int compareTo(Record o2){
            return o2.getCount()-count;
        }

        public int getIndex(){
            return index;
        }
             
        public int getCount(){
            return count;
        }
        
     
    public String[] findCoder(String[] A, int n) {
        Record[] record=new Record[n];
        for(int i=0;i<n;i++){
            record[i]=new Record(i,countCoder(A[i]));
        }
        
        Arrays.sort(record);
        String[]result=new String[n];
         for(int i=0;i<n;i++){
            result[i]=A[record[i].getIndex()];
        }
        return result;
         
    }
     
    private int countCoder(String str){
        int count=0;
        str=str.toLowerCase();
        int index=0;
        while((index=str.indexOf("coder",index))!=-1){
            index+=5;
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
		Record r=new Record();
		String[] stest={"i am a coder","Coder Coder","Code"};
		int n=3;
		r.findCoder(stest, n);
	}

}


