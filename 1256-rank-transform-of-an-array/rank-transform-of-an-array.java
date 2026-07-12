class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(sorted);
        int rank=1;

        for(int num:sorted){
            if(!map.containsKey(num)){
                map.put(num,rank++);
            }
        }

        for(int i=0;i<arr.length;i++){
            int ranks=map.get(arr[i]);
            arr[i]=ranks;
        }

    return arr;
    }
}