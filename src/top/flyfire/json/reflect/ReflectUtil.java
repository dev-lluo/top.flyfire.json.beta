package top.flyfire.json.reflect;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by flyfire[dev.lluo@outlook.com] on 2016/4/7.
 */
public interface ReflectUtil {

    static boolean isJdkType(Class clzz){
        return clzz.isPrimitive()||Number.class.isAssignableFrom(clzz)||Date.class.isAssignableFrom(clzz);
    }

    static boolean isInterface(Class clzz){
        return clzz.isInterface();
    }

    static boolean aIsBParent(Class aClzz,Class bClzz){
        return aClzz.isAssignableFrom(bClzz);
    }

}
