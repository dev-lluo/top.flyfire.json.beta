package test;


import top.flyfire.json.Json;

import java.math.BigDecimal;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by shyy_work on 2016/4/7.
 */
public class Main {

    public static void main(String[] args){
//        Json json = new Json("{\"a\":123,\"b\":\"123\",\"df\":true,test:{a:123,b:false},test2:true,test3:[1,223,456],test4:\"end\"}");
//        json.parse();
         String s = "+12.3";
        if(isNumeric(s)) {
            System.out.println(new BigDecimal(s));
        }
        long start = System.currentTimeMillis();
            for(int i = 0;i<100000;i++){
                String temp = s+i;
                if(isNumeric(temp))
                new BigDecimal(temp);
            }
        System.out.println(System.currentTimeMillis()-start);
    }

    public static boolean isNumeric(String s){
        int len = s.length();
        if(len==1){
            char c = s.charAt(0);
            return c>='0'&&c<='9';
        }else{
            int cursor =0;char c;boolean signed = false;
            if((c=s.charAt(cursor))=='+'||c=='-'){
                cursor++;
                signed = true;
            }
            if((!signed&&c=='.')||(signed&&(c=s.charAt(cursor))=='.')){
                return false;
            }else if(c>='0'&&c<='9'){
                len = len -1;
                while(++cursor<len){
                    if(((c=s.charAt(cursor))<'0'||c>'9')&&c!='.'){
                        return false;
                    }
                }
                return ((c=s.charAt(len))>='0'&&c<='9') ;
            }else{
                return false;
            }

        }
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
