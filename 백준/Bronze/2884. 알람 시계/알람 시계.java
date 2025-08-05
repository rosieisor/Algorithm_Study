import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int H = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        StringBuilder sb = new StringBuilder();
        
        if (M >= 45) {
            sb.append(H).append(" ").append(M - 45);
        } else {
            if (H == 0) {
                sb.append(23);
            } else {
                sb.append(H-1);
            }
            sb.append(" ").append(60 + M - 45);
        }

        System.out.print(sb.toString());
    }
}