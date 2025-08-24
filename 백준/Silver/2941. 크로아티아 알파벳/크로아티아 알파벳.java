import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String split = br.readLine();

        split = split.replace("c=", "1");
        split = split.replace("c-", "1");
        split = split.replace("dz=", "1");
        split = split.replace("d-", "1");
        split = split.replace("lj", "1");
        split = split.replace("nj", "1");
        split = split.replace("s=", "1");
        split = split.replace("z=", "1");
        
        System.out.println(split.length());
    }
}