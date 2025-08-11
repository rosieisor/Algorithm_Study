import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            
            if (str == null) {
                break;
            }

            String[] split = str.split(" ");

            sb.append(Integer.parseInt(split[0]) + Integer.parseInt(split[1]) + "\n");
        }
        
        System.out.println(sb.toString());
    }
}