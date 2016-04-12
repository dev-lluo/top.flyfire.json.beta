package top.flyfire.json.reflect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by flyfire[dev.lluo@outlook.com] on 2016/4/7.
 */
public class ReflectContext {

    static final Map<Class<?>,ClassMetaInfo> CLASS_META_INFO_MAP = new HashMap<Class<?>,ClassMetaInfo>();

    public static ClassMetaInfo resolve(Class<?> clzz){
        ClassMetaInfo classMetaInfo;
        if((classMetaInfo = CLASS_META_INFO_MAP.get(clzz))==null){
            classMetaInfo = new ClassMetaInfo(clzz);
            CLASS_META_INFO_MAP.put(clzz,classMetaInfo);
        }
        return classMetaInfo;
    }

}
