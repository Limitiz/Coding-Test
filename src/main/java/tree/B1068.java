package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        ArrayList<Tree> list = new ArrayList<>();
        int leaf = 0;
        for(int i=0; i<n; i++)
            list.add(new Tree());
        for(int i=0; i<n; i++) {
            int p = Integer.parseInt(st.nextToken());
            list.get(i).parent = p;
            if(p != -1)
                list.get(p).children.add(i);
        }
        for(Tree t : list){
            if(t.children.isEmpty())
                leaf++;
        }

        int delete = Integer.parseInt(br.readLine());
        if(list.get(delete).parent == -1)
            leaf = 0;
        else {
            Queue<Tree> q = new LinkedList<>();
            if (list.get(delete).children.isEmpty())
                leaf--;
            else {
                q.add(list.get(delete));
                while (!q.isEmpty()) {
                    Tree t = q.poll();
                    if (t.children.isEmpty())
                        leaf--;
                    else {
                        for (int i : t.children)
                            q.add(list.get(i));
                    }
                }
            }
            int parent = list.get(delete).parent;
            if (list.get(parent).children.size() == 1)
                leaf++;
        }

        System.out.println(leaf);
    }
    static class Tree{
        int parent;
        ArrayList<Integer> children;
        public Tree(){
            parent = 0;
            children = new ArrayList<>();
        }
    }
}
