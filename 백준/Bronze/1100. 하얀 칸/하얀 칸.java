import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] board = new int[8][8];

        int result = 0;
        for(int i=0; i<8; i++) {
            String[] split = br.readLine().split("");

            for(int j=0; j<8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0 && split[j].equals("F")) {
                       result++; 
                    }
                } else {
                    if (j % 2 != 0 && split[j].equals("F")) {
                       result++; 
                    }
                }
            }
        }

        System.out.println(result);
    }
}