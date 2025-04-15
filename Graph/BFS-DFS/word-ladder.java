// L-127

// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a 
// sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in 

// the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

// Example 1:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", 
// which is 5 words long.
// Example 2:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
// Output: 0
// Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.








class Solution {

    class Pair{
        String wrd;
        int lvl;

        Pair(String wrd, int lvl){
            this.wrd = wrd;
            this.lvl = lvl;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet <String> set = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++){
            set.add(wordList.get(i));
        }

        if(!set.contains(endWord)) return 0;

        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            String word = q.peek().wrd;
            int level = q.peek().lvl;
            q.remove();

            for(int i = 0; i < word.length(); i++){
                char[] arr = word.toCharArray();

                for(char ch = 'a'; ch <= 'z'; ch++){
                    if(arr[i] == ch) continue;
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if(newWord.equals(endWord)) return level + 1;

                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.add(new Pair(newWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}