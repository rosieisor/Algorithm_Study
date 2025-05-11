import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        String[] split = br.readLine().split("");
        
        for(int i=0; i<N; i++) {
            sum += Integer.parseInt(split[i]);
        }

        System.out.print(sum);
    }
}