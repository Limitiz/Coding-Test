package queue.deque;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class B1021 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int pos[] = new int[m];
        for (int i = 0; i < m; i++)
            pos[i] = sc.nextInt();
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            q.add(i);
        int count = 0;

        for (int i = 0; i < m; i++) {
            while (true) {
                int index = 0;
                Iterator<Integer> it = q.iterator();
                while (it.hasNext()) {
                    if (it.next() == pos[i])
                        break;
                    index++;
                }
                if (index == 0) {
                    q.poll();
                    break;
                }
                else if (index > q.size() / 2) {
                    q.addFirst(q.pollLast());
                    count++;
                }
                else {
                    q.addLast(q.pollFirst());
                    count++;
                }
            }
            System.out.println(count);
        }
        System.out.println(count);
        sc.close();
    }
}
