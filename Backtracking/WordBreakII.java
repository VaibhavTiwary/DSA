// Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence 
// where each word is a valid dictionary word. Return all such possible sentences in any order.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

// Example 1:

// Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
// Output: ["cats and dog","cat sand dog"]

class Solution {
    ArrayList <String> ans = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList <String> temp = new ArrayList<>();
        Set <String> set = new HashSet<>();

        for(int i = 0; i < wordDict.size(); i++){
            set.add(wordDict.get(i));
        }
        solve(s, 0, set, temp);
        return ans;
    }

    void solve(String s, int index, Set <String> set, ArrayList <String> temp){
        if(index == s.length()){
            ans.add(String.join(" ", temp));

            return;
        }

        StringBuilder res = new StringBuilder();
        for(int i = index; i < s.length(); i++){
            res.append(s.charAt(i));
            if(set.contains(res.toString())){
                temp.add(res.toString());
                solve(s, i + 1, set, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}