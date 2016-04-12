package top.flyfire.json.reflect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by flyfire[dev.lluo@outlook.com] on 2016/4/7.
 */
public class ReflectContext {

    static final Map<Class<?>,ClassMetaInfo> CLASS_META_INFO_MAP = new HashMap<Class<?>,ClassMetaInfo>();

    public static void resolve(Class<?> clzz){
        Method[] clzzMethods = clzz.getMethods();
        ClassMetaInfo classMetaInfo = new ClassMetaInfo();
        for(int i = 0,len = clzzMethods.length;i<len;i++){

        }
    }

}
