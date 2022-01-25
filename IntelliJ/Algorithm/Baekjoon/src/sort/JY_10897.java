package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JY_10897 {
    public static class Student{
        String name;
        int kor;
        int eng;
        int math;
        public Student(String n, int k, int e, int m){
            name = n;
            kor = k;
            eng = e;
            math = m;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Student[] arr = new Student[n];
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            arr[n] = new Student(st.nextToken(),Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.kor == o2.kor){
                    if(o1.eng == o2.eng){
                        if(o1.math == o2.math)
                            return o1.name.compareTo(o2.name);
                        return o2.math - o1.math;
                    }
                    return o1.eng - o2.eng;
                }
                return o2.kor - o1.kor;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Student i : arr)
            sb.append(i.name+"\n");
        System.out.println(sb.toString());

        br.close();
    }
}