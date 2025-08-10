import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();

            String[] split = str.split(" ");

            int A = Integer.parseInt(split[0]);
            int B = Integer.parseInt(split[1]);

            if (A == 0 && B == 0) {
                break;
            }

            sb.append(A + B + "\n");
        }
        
        System.out.println(sb.toString());
    }
}