package test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by shyy_work on 2016/4/13.
 */
public class TryTest {
    public static void main(String args[]) throws TryException {
        TryTest tryTest = new TryTest();
        for(int i = 0;i<100;i++);
        tryTest.test2();
        tryTest.test1();
    }

    public static class TryException extends Exception{
        Map map = new Map() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public Object get(Object key) {
                return null;
            }

            @Override
            public Object put(Object key, Object value) {
                return null;
            }

            @Override
            public Object remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set keySet() {
                return null;
            }

            @Override
            public Collection values() {
                return null;
            }

            @Override
            public Set<Entry> entrySet() {
                return null;
            }
        };
    }

    public TryTest() throws TryException{}

    public void test1(){
        long start = System.currentTimeMillis();
        try {
            for (int i = 0; i < 10000000; i++) {
                new TryTest();
            }
        }catch (TryException e){
            Exception temp = e;
        }
        System.out.println(System.currentTimeMillis()-start);
    }

    public void test2(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            try {
                new TryTest();
            }catch (TryException e){
                Exception temp = e;
            }
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
