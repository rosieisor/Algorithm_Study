import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<9; i++) {
            sb.append(N + " * " + (i+1) + " = " + (N * (i + 1)) + "\n");
        }

        System.out.println(sb.toString());
        
    }
}