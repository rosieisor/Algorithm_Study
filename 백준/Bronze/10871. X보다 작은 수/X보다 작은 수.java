import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        
        int N = Integer.parseInt(split[0]);
        int X = Integer.parseInt(split[1]);
        split = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            int data = Integer.parseInt(split[i]);
            if (X > data) {
                sb.append(data + " ");
            }
        }

        System.out.print(sb.toString());
    }
}