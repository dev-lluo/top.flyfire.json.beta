package test;

import top.flyfire.json.reflect.ClassMetaInfo;
import top.flyfire.json.reflect.ReflectContext;
import top.flyfire.json.reflect.ReflectUtil;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by shyy_work on 2016/4/12.
 */
public class ReflectTest {

    public static void main(String[] args) throws ReflectiveOperationException {
        long start = System.currentTimeMillis();
        ClassMetaInfo classMetaInfo = ReflectContext.resolve(ClassA.class);
        for(int i = 0;i<100000;i++){
            ClassA classA = new ClassA();
            classMetaInfo.getFieldMetaInfo("a").invokeSetter(classA,new Random().nextInt());
            classMetaInfo.getFieldMetaInfo("b").invokeSetter(classA,new Random().nextInt());
            classMetaInfo.getFieldMetaInfo("myName").invokeSetter(classA,new Random().nextInt());
            classMetaInfo.getFieldMetaInfo("corpCode").invokeSetter(classA,"a"+new Random().nextInt());
            classMetaInfo.getFieldMetaInfo("deleteFlg").invokeSetter(classA,"dsfasdfasdf"+new Random().nextInt());
            classMetaInfo.getFieldMetaInfo("date").invokeSetter(classA,"dafasdfasdfasdf"+new Random().nextInt());
        }
        System.out.println(System.currentTimeMillis()-start);

    }
}
