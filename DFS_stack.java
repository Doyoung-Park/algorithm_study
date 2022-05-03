import java.util.Stack;

public class DFS_stack {
    static boolean[] visited = new boolean[9];

    static int[][] graph = { {} ,{2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args){
        stack.push(1);  // 시작 노드를 스택에 넣어줌

        visited[1]=true;

        while(!stack.isEmpty()){

            int nodeIdx = stack.pop();

            System.out.println(nodeIdx +" ");

            for(int LinkedNode : graph[nodeIdx]){
                if(!visited[LinkedNode]){
                    visited[LinkedNode]= true;
                    stack.push(LinkedNode);
                }
            }
        }

    }
}
