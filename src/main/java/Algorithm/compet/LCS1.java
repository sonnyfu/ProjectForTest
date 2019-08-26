package Algorithm.compet;

public class LCS1 {
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        String one = " " + "ABCBDAB";  
        String two = " " + "BDCABA";  
  
        char x[] = one.toCharArray();  
        char y[] = two.toCharArray();  
  
        int b[][] = getLength(x, y);  
  
        myprint(b, x, x.length - 1, y.length - 1);  
    }  
  
    private static void myprint(int[][] b, char[] x, int i, int j) {  
  
        if (i == 0 || j == 0) {  
            return;  
        }  
  
        if (b[i][j] == 0) {  
            myprint(b, x, i - 1, j - 1);  
            System.out.print(x[i] + " ");  
        } else if (b[i][j] == 1) {  
            myprint(b, x, i - 1, j);  
        } else {  
            myprint(b, x, i, j - 1);  
        }  
  
    }  
  
    private static int[][] getLength(char[] x, char[] y) {  
        // TODO Auto-generated method stub  
        int b[][] = new int[x.length][y.length];  
        int c[][] = new int[x.length][y.length];  
  
        for (int i = 1; i < x.length; i++) {  
            for (int j = 1; j < y.length; j++) {  
                if (x[i] == y[j]) {  
                    c[i][j] = c[i - 1][j - 1] + 1;  
                    b[i][j] = 0; // 左上角继承  
                } else if (c[i - 1][j] >= c[i][j - 1]) {  
                    c[i][j] = c[i - 1][j];  
                    b[i][j] = 1; // 上方继承  
                } else {  
                    c[i][j] = c[i][j - 1];  
                    b[i][j] = 2; // 左方继承  
                }  
            }  
        }  
  
        return b;  
    }  
}
