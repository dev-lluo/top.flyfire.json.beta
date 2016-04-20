package top.flyfire.json.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

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

    static boolean aBIsogeny(Class aClzz,Class bClzz){
        return aClzz.isAssignableFrom(bClzz);
    }

    static String myName(String getterOrSetterName){
        int cursor = 3,len = getterOrSetterName.length();char sign;
        char[] temp = new char[len-cursor];
        sign = getterOrSetterName.charAt(cursor);
        temp[cursor-3] = ReflectUtil.toLower(sign);
        while (++cursor<len){
            temp[cursor-3] = getterOrSetterName.charAt(cursor);
        }
        return new String(temp);
    }

    static char toUpper(char sign){
        if(sign>='a'&&sign<='z'){
            return (char)(sign-32);
        }
        return sign;
    }

    static char toLower(char sign){
        if(sign>='A'&&sign<='Z'){
            return (char)(sign+32);
        }
        return sign;
    }

    static char isGetterOrSetterName(String methodName){
        char c;
        return (methodName.length()>3
                &&((c=methodName.charAt(1))=='e')
                &&((c=methodName.charAt(2))=='t')
                &&((c=methodName.charAt(0))=='g'||c=='s'))?c:'\0';
    }

}
