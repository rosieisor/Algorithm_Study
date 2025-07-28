import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] split = br.readLine().split(" ");
        
        System.out.print(Integer.parseInt(split[0]) + Integer.parseInt(split[1]));
    }
}