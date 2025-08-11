import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int C = Integer.parseInt(br.readLine());

        int sum = B + C;
        int plus = (B + C) / 60;
        int mod = (B + C) % 60;
        
        if (B + C >= 60) {
             if (A + plus > 23) {
                 A = (A - 24) + plus; 
             } else {
                 A += plus;
             }
            B = mod;
        } else {
            B += C;
        }

        System.out.println(A + " " + B);
    }
}