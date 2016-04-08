package test;


import top.flyfire.json.Json;

/**
 * Created by shyy_work on 2016/4/7.
 */
public class Main {

    public static void main(String[] args){
        Json json = new Json("{\"a\":123,\"b\":\"123\",\"df\":true,test:{a:123,b:false},test2:true,test3:[1,223,456],test4:\"end\"}");
        json.parse();
    }

}
