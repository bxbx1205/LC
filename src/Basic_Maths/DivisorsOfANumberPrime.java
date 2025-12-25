package Basic_Maths;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class DivisorsOfANumberPrime {
    static void main(String[] args) {
        System.out.println(Arrays.toString(divisors(17)));
    }

    static int[] divisors(int n){
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i*i <=n ; i++) {
            if (n%i==0){
                list.add(i);

            if ((n/i)!=i){
                list.add(n/i);
            }
        }}


        Collections.sort(list);

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        if (ans.length>2){
            System.out.println("not Prime");
        }
        else{
            System.out.println("prime");
        }


        return ans;
    }
}
