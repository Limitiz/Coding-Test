package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5639 {
    static StringBuilder sb = new StringBuilder();
    static class Node{
        int num;
        Node right, left;

        Node(int num){
            this.num = num;
        }

        public void insert(int element){
            if(element < num) {
                if(this.left == null)
                    this.left = new Node(element);
                else
                    this.left.insert(element);
            }
            else{
                if(this.right == null)
                    this.right = new Node(element);
                else
                    this.right.insert(element);
            }
        }

        public void post(){
            if(left != null)
                left.post();
            if(right != null)
                right.post();
            sb.append(num+"\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String s;
        while((s = br.readLine()) != null && s.length() != 0)
            root.insert(Integer.parseInt(s));

        root.post();
        System.out.print(sb);
        br.close();
    }
}