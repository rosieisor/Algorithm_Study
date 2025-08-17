import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        String[] split = br.readLine().split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++) {
            int data = Integer.parseInt(split[i]);

            max = Math.max(max, data);
            min = Math.min(min, data);
        }

        System.out.print(min + " " + max);
    }
}