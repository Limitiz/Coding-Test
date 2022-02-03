package twoPointer;

import java.util.Scanner;
import java.util.Vector;

public class B1484 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        Vector<Long> v = new Vector<>();
        //from 1 to random big interger
        //why 50000? --> 50000^2 - 4999^2 = 9999
        for(int i=1; i<=50000; i++)
            v.add((long)i*i);

        int a = 0, b = 0;
        Vector<Long> answer = new Vector<>();
        while(b<v.size()) {
            long dif = v.get(b) - v.get(a);
            if (dif < g)
                b++;
            else if (dif > g)
                a++;
            else {
                answer.add((long) Math.sqrt(v.get(b)));
                b++;
            }
        }
        if(answer.size() == 0)
            System.out.println(-1);
        for(int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
        sc.close();
    }
}
