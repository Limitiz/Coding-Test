package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1991 {
    static StringBuilder sb = new StringBuilder();
    static Node tree[];
    static class Node{
        char data;
        Node left, right;
        Node(char c){
            this.data = c;
        }

        public void insert(char c, char a, char b){
            if(c == data) {
                if(a != '.')
                    left = new Node(a);
                if(b != '.')
                    right = new Node(b);
            }
            else{
                if(left != null)
                    left.insert(c, a, b);
                if(right != null)
                    right.insert(c, a, b);
            }
        }

        public void pre(){
            sb.append(data);
            if(left != null)
                left.pre();
            if(right != null)
                right.pre();
        }
        public void inorder(){
            if(left != null)
                left.inorder();
            sb.append(data);
            if(right != null)
                right.inorder();
        }
        public void post(){
            if(left != null)
                left.post();
            if(right != null)
                right.post();
            sb.append(data);
        }

        //new way
        public void post(int root){
            if(tree[root].left != null)
                post(tree[root].left.data);
            if(tree[root].right != null)
                post(tree[root].right.data);
            sb.append(tree[root].data+'A');
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Node root = new Node(s.charAt(0));
        for(int i=1; i<n; i++) {
            root.insert(s.charAt(0), s.charAt(2), s.charAt(4));
            s = br.readLine();
        }

        root.pre();
        sb.append("\n");
        root.inorder();
        sb.append("\n");
        root.post();

        System.out.println(sb);
        br.close();

        //new way
        /*for(int i=0; i<n; i++)
            tree[i] = new Node(i);
        tree = new Node[n];
        while(n-->0){
            int parent = s.charAt(0) - 'A';
            int left = s.charAt(2) - 'A';
            int right = s.charAt(4) - 'A';

            if(left >= 0)
                tree[parent].left = tree[left];
            if(right >= 0)
                tree[parent].right = tree[right];
        }*/
    }
}