import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1149 {
    static int compare(int a, int b){       // 더 작은 것을 리턴
        if(a>b)
            return b;
        else
            return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // n =5

        int[][] price = new int[n][];
        int[][] sum = new int[n][];

        for(int i=0; i<n; i++){
            price[i] = new int[3];
            sum[i] = new int[3];
        }


        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                price[i][j] = Integer.parseInt(st.nextToken());

                if(i==0){
                    sum[i][j]= price[0][j];
                }

            }
        }



        for(int i=1; i<n; i++){

            sum[i][0] = price[i][0]+ compare(sum[i-1][1], sum[i-1][2]);
            sum[i][1] = price[i][1]+ compare(sum[i-1][0], sum[i-1][2]);
            sum[i][2] = price[i][2]+ compare(sum[i-1][0], sum[i-1][1]);

        }

        for(int i=0; i<n; i++){

            for(int j=0; j<3; j++){
                System.out.print(price[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        System.out.print("\n");

        for(int i=0; i<n; i++){

            for(int j=0; j<3; j++){
                System.out.print(sum[i][j]+" ");
            }
            System.out.print("\n");
        }

        System.out.println(Arrays.stream(sum[n-1]).min().getAsInt());

    }
}
