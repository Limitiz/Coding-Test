package queue.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class B19591 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Deque<Character> operator = new LinkedList<>();
        Deque<Integer> operand = new LinkedList<>();
        int i = 0;
        while(i-->s.length()){
            char c = s.charAt(i);
            StringBuilder sb = new StringBuilder();
            if(i!='*' || i!='/' || i!='+' || i!='-'){
                sb.append(i);
                continue;
            }
            else{
                operand.add(Integer.parseInt(sb.toString()));
                operator.add(c);
            }
        }

        while(!operator.isEmpty()){
            char a = operator.getFirst();
            char b = operator.getLast();
        }


    }
}
