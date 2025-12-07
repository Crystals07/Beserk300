package org.jaideep.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueCombinations {
    public void helperCombinations(int start, int target, List<List<Integer>> ans,List<Integer> temp){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<=target; i++){
            temp.add(i);
            helperCombinations(i+1,target-i,ans, temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> getAllUniqueCombinations(int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helperCombinations(1,target-1,ans,new ArrayList<>());
        return ans;
    }
}
