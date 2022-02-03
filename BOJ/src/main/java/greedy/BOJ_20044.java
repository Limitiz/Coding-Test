package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_20044 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] student = new int[2*num];
        for(int i=0; i<2*num; i++)
            student[i] = sc.nextInt();

        Arrays.sort(student);

        int min=200000;
        for(int i=0;i<num;i++)
            min = Math.min(min, student[i] + student[num - i - 1]);

        System.out.println(min);

        sc.close();
    }
}
