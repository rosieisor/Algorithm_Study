import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        StringBuilder sb = new StringBuilder();
        while((str = br.readLine()) != null) {
            sb.append(str + "\n");
        }

        System.out.println(sb.toString());
    }
}