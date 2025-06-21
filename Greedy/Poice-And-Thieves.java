// Given an array arr[], where each element contains either a 'P' for policeman or a 'T' for thief.
//  Find the maximum number of thieves that can be caught by the police. 
// Keep in mind the following conditions :

// Each policeman can catch only one thief.
// A policeman cannot catch a thief who is more than k units away from him.


class Solution {
    public int catchThieves(char[] arr, int k) {
        
        int n = arr.length;
        List<Integer> police = new ArrayList<>();
        List<Integer> thief = new ArrayList<>();
    
        for(int i = 0; i < n; i++) {
            if(arr[i] == 'P') police.add(i);
            else if(arr[i] == 'T') thief.add(i);
        }
    
        int i = 0, j = 0, count = 0;
    
        while(i < police.size() && j < thief.size()) {
            if(Math.abs(police.get(i) - thief.get(j)) <= k) {
                count++;    
                i++;
                j++;
            } else if(police.get(i) < thief.get(j)) {
                i++;  
            } else {
                j++;  
            }
        }

        return count;
        
        
        
    }
}
