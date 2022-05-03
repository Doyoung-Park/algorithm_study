import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sum123 {

    public static int factorial(int x) {

        int result = 1;

        if(x==0){
            return result;
        }
        else{
            while (x > 0) {
                result *= x;
                x--;
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());        // 테스트 케이스 개수
        ArrayList<Integer> answer = new ArrayList<>();

        while(n>0){
            int a= Integer.parseInt(bf.readLine());     // 총합이 되어야 하는 수 -> 4, 7, 10

            int tempSum =0;     //  각각의 (i, j, k)의 조합의 개수

            int total=0;        // 총합이 a 가 될 수 있는 1, 2, 3의 가능한 총 개수

            for(int i=0; i<=a; i++){
                for(int j=0; j<=(a/2); j++){
                    for(int k=0; k<=(a/3); k++){

                        if((1*i)+(2*j)+(3*k) == a){
                            tempSum = factorial(i+j+k) / (factorial(i)*factorial(j)*factorial(k));
                            total +=tempSum;
                        }
                    }
                }
            }

            answer.add(total);
            n--;
        }

        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }

    }
}
