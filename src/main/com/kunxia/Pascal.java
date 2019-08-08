package com.kunxia;

import static sun.misc.Version.println;

public class Pascal {

    public static void main(String[] args){
        for(int i=0; i<5; i++){
           // int sum =1;
            System.out.println();
            for(int j=0; j<=i; j++){
                System.out.print(pascal(i,j));
                //sum=sum*(i-j)/(j+1);
            }

        }

    }
    //C(n,k)=C(n-1,k-1)+C(n-1,k);
    public static int pascal(int x, int y){
        if((x+1)==1 || (y+1)==1 ||x==y){
            return 1;
        }else{
            return pascal(x-1,y-1)+pascal(x-1,y);
        }
    }
}
