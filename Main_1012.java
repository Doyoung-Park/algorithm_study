import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012 {
    static int[][] farm;
    static boolean[][] visited;
    static int[] dx ={0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int cnt=0;
    static int M=0;
    static int N=0;
    static int[] answer;
    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int times = Integer.parseInt(bf.readLine());
        answer = new int[times];

        for(int t =0 ; t<times ; t++){
            cnt=0;

        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited= new boolean[N][M];
        farm = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                farm[i][j] = 0;
            }
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());       // x좌표
            int b = Integer.parseInt(st.nextToken());       // y좌표

            farm[b][a]=1;

        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){

                if(farm[i][j] ==1 && !visited[i][j]){
                    dfs(i, j);
                    cnt++;
                }

            }


        }
        answer[t]=cnt;

        }

        for(int i=0; i<times; i++){
            System.out.println(answer[i]);
        }

    }

    static void dfs(int i, int j){
        if( i<0 || i>N-1 || j<0 || j>M-1 )
            return;



        if(!visited[i][j] && farm[i][j]==1){
            visited[i][j]=true;

            for(int d=0; d<4; d++)
            dfs(i+dy[d], j+dx[d]);

        }
    }
}
