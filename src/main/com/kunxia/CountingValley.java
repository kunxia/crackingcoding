package main.com.kunxia;

public class CountingValley {
    // Complete the countingValleys function below.
    public int countingValleys(int n, String s) {
        if(n==1) return 0;
        char[] chars = s.toCharArray();
        int sum=0;
        int count=0;
        for(char c: chars){
            if(c=='U'){
                sum = sum + 1;
            }else{//assume otherwise D
                sum = sum - 1;
            }
            if(sum==0 && c=='U'){
                ++count;
            }
        }
        return count;
    }

}
