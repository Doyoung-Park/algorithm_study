import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.util.Collections.sort;

public class Main_2583 {

    static int M;   // 세로방향으로 M개
    static int N;   // 가로방향으로 N개
    static int K;   // 사각형 3개 입력

    static int cnt=0;
    static ArrayList<Integer> answer;

    static int[] dx ={0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] rect;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        rect = new int[M][N];
        visited = new boolean[M][N];
        answer = new ArrayList<>();

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                rect[i][j] = 0;
                visited[i][j] = false;
            }
        }


        for(int i=0; i<K; i++){
            st = new StringTokenizer(bf.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j=y1; j<y2; j++){
                for(int k=x1; k<x2; k++){

                    rect[j][k]=1;
                }
            }
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){

                cnt=0;

                if(rect[i][j] == 0 && !visited[i][j]){
                    dfs(i, j);
                    answer.add(cnt);

                }
            }
        }

        sort(answer);
        System.out.println(answer.size());
        for(int t=0; t<answer.size(); t++){
            System.out.print(answer.get(t)+" ");
        }

    }

    static void dfs(int i, int j){

        if(i<0 || i>M-1 || j <0 || j>N-1)
            return;

        if(rect[i][j]==0 && !visited[i][j]){
            visited[i][j]=true;
            cnt++;

            for(int m=0; m<4; m++){
                dfs(i+dy[m], j+dx[m]);
            }

        }
    }
}
