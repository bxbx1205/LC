package Array.Easy;
import java.util.*;

public class unionoftwosortedarray {
    static void main() {
        int[] a ={1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(findUnion(a,b));

    }

     static ArrayList<Integer> findUnion(int a[], int b[]) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> soln = new ArrayList<>();

         for (int i = 0; i < a.length-1; i++) {
             map.put(a[i],1 );

         }
         for (int i = 0; i < b.length; i++) {
             map.put(b[i],1 );
         }

        for (int values : map.keySet()){
            soln.add(values);
        }
            Collections.sort(soln);
return soln;
    }

}

