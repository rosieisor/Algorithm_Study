import java.util.*;
import java.io.*;

class Person {
    int index;
    int age;
    String name;

    Person(int index, int age, String name) {
        this.index = index;
        this.age = age;
        this.name = name;
    }
}

class Main {

    static int N;
    
    public static void main(String[] args) throws IOException {

        List<Person> list = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ");
            list.add(new Person(i, Integer.parseInt(split[0]), split[1]));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.age == o2.age) {
                if (o1.index > o2.index) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (o1.age > o2.age) {
                return 1;
            } else {
                return -1;
            }
        });

        for(Person p : list) {
            System.out.println(p.age + " " + p.name);
        }
    }
}