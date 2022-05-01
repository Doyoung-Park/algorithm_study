import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AtoB {     // 백준 16953
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int cnt=1;

        while(B!=A){

            if(B % 2 !=0) {    // 맨 뒷자리가 홀수라면
            B -=1;
            if(B %10 ==0){      // 2 40021 를 입력했을 때 에러가 날 수 있음!
                B /= 10;        // B를 10으로 나누었을 때 딱 나누어 떨어지지 않을 수도 있음. -> 답을 -1로 빼야함
            }
            else{
                cnt=-1;
                break;
            }

            }
            else{
                B/=2;
            }
            cnt++;

            if(B<A){
                cnt= -1;
                break;
            }
        }

        System.out.println(cnt);
    }
}
