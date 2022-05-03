import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1932 {

    static int compare(int a, int b){
        if(a>b)
            return a;
        else
            return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // n =5

        int[][] num = new int[n][];
        int[][] sum = new int[n][];

        for(int i=0; i<n; i++){
            num[i] = new int[n+1];
            sum[i] = new int[n+1];
        }


        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sum[0][0] = num[0][0];

        for(int i=1; i<n; i++){

            sum[i][0]= sum[i-1][0]+num[i][0];     // 맨 왼쪽 줄은 위에 꺼 그대로 가져오면 됨
            sum[i][i] = sum[i-1][i-1] + num[i][i];  // 왼 오른쪽 줄은 위에 꺼 그대로 가져오면 됨

            for(int j=1; j<i; j++){
                sum[i][j] = compare(num[i][j]+sum[i-1][j-1],num[i][j]+sum[i-1][j] );
            }
        }


        for(int i=0; i<n; i++){

            for(int j=0; j<=i; j++){
                System.out.print(num[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.print("\n");
        for(int i=0; i<n; i++){

            for(int j=0; j<=i; j++){
                System.out.print(sum[i][j]+" ");
            }
            System.out.print("\n");
        }

       // System.out.println("최대값:"+ Arrays.stream(sum[4]).max().getAsInt());
        System.out.println(Arrays.stream(sum[n-1]).max().getAsInt());



    }
}
