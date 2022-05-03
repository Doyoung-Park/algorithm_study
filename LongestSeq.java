import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class LongestSeq {

    static int compare(int a, int b){
        if(a>b)
            return a;
        else
            return b;
    }

    static int peek(ArrayList<Integer> List){
        int size= List.size();

        return List.get(size);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] input = new int[n];

        ArrayList<Integer>[] dynamicSeq = new ArrayList[n];
        for(int i=0; i<n; i++){
            dynamicSeq[i] = new ArrayList<Integer>();
        }
//        for(int i=0; i<n; i++){
//            dynamicSeq = new int[n];
//        }

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0; i<n; i++){
            input[i]=Integer.parseInt(st.nextToken());
            dynamicSeq[0].add(input[i]);
        }

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){

                if(input[j] > peek(dynamicSeq[i])){
                    dynamicSeq[i].add(input[j]);
                }

            }
        }
        Iterator iter = dynamicSeq[0].iterator(); //Iterator 선언

        while(iter.hasNext()){//다음값이 있는지 체크
            System.out.println(iter.next()); //값 출력
        }


    }
}
