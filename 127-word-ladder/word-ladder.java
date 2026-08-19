class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();

        for(String s : wordList){
            set.add(s);
        }
        
        if (!set.contains(endWord)) {
            return 0;
        }

        // int cnt=0;
        Queue<String []> queue = new LinkedList<>();
        queue.offer(new String[]{beginWord,"1"});

        set.remove(beginWord);

        while(!queue.isEmpty()){

            String[] current = queue.poll();
            String currentWord = current[0];
            int currentCnt=Integer.parseInt(current[1]);

            if (currentWord.equals(endWord)) {
                return currentCnt;
            }

            // two for loop to check all index and change all chars and if found remove frmo set and add to queue and increse counter and 

            for(int i=0;i<currentWord.length();i++){

                char[] arr = currentWord.toCharArray();

                for(char ch ='a';ch<='z';ch++){
                     arr[i] = ch;

                    String newWord = new String(arr);

                    if (set.contains(newWord)) {

                        set.remove(newWord);

                        queue.offer(new String[]{
                            newWord,
                            String.valueOf(currentCnt + 1)
                        });
                    }
                }
            }
        }

        return 0;
    }
}