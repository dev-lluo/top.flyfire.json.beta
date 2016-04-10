package test;


import top.flyfire.json.Json;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by shyy_work on 2016/4/7.
 */
public class Main {

    public static void main(String[] args){
        Json json = new Json("{\"a\":123,\"b\":\"123\",\"df\":true,test:{a:123,b:false},test2:true,test3:[1,223,456],test4:\"end\"}");
        json.parse();
//         String s = "+12.3";
//        if(isNumeric(s)) {
//            System.out.println(new BigDecimal(s));
//        }
//        long start = System.currentTimeMillis();
//            for(int i = 0;i<100000;i++){
//                String temp = s+i;
//                if(isNumeric(temp))
//                new BigDecimal(temp);
//            }
//        System.out.println(System.currentTimeMillis()-start);
    }

    static int add(int a ,int b){
        int ans = a;
        while(b!=0){
            ans = a^b;
            b = (a&b)<<1;
            a = ans;
        }
        return ans;
    }

    static int sub(int a,int b){
        return add(a,negative(b));
    }

    static int mul(int a,int b){
        int ans = 0;
        while(b!=0){
            if((b&1)!=0) ans = add(ans,a);
            a = a<<1;
            b = b>>1;
        }
        return ans;
    }

    static int div(int a,int b){
        int ans = 0;
        while(a>b){
            a = sub(a,b);
            ans = add(ans,1);
        }
        return ans;
    }

    static int negative(int a){
        return add(~a,1);
    }

}
