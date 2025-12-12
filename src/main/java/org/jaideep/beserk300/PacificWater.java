package org.jaideep.beserk300;

import java.util.ArrayList;
import java.util.List;

class Pair{
   public int pacific=0;
   public int atlantic=0;

    public Pair(int pacific, int atlantic){
        this.pacific = pacific;
        this.atlantic = atlantic;
    }

    public int getFirst(){
        return pacific;
    }

    public int getAtlantic(){
        return atlantic;
    }
}

public class PacificWater {
    public void solutionImp(int[][] matix, List<List<Pair>> dp, List<List<Integer>> ans,int row,int col){
        int n = matix.length;
        int m = matix[0].length;
        for(int i=row; i< n; i++ ){
            for(int j=col; j< m; j++){
                //check dp
                if(dp.get(i).get(j).pacific==0)
                {
                    //up
                    //if(i)
                }
                if(dp.get(i).get(j).atlantic==0){

                }
            }
        }
    }

    private boolean isSafe(int i, int j, int n,int m) {
        return (i >= 0 && i <= n && j >= 0 && j <= m );
    }

    public void solution(int[][] matrix){
        List<List<Integer>> answer = new ArrayList<>();
        List<List<Pair>> dp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solutionImp(matrix,dp,ans,0,0);
    }
}
