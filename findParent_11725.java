import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
    int parent=0;
    int me=0;
}

public class findParent_11725 {

    static int n;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] parents;

   public static void main(String[] args) throws IOException {
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(bf.readLine());

       parents = new int[n+1];
       adjList = new ArrayList[n+1];
       visited = new boolean[n+1];


       for(int i=0; i<n+1; i++) {
           adjList[i] = new ArrayList<>();
           visited[i]=false;
       }

       for(int i=0; i<n-1; i++){
           StringTokenizer st = new StringTokenizer(bf.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());

           adjList[a].add(b);
           adjList[b].add(a);
           }

       for(int i=1; i<n+1; i++){
           if(!visited[i])
               dfs(i);
       }

       for(int i=2; i<n+1; i++){
           System.out.println(parents[i]);
       }

       }
       public static void dfs(int idx){

       visited[idx] =true;

       for(int child: adjList[idx]){
        if(!visited[child]){
            visited[child]=true;
            parents[child]=idx;
            dfs(child);

        }
       }
       }

}
