package top.flyfire.json.reflect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by flyfire[dev.lluo@outlook.com] on 2016/4/7.
 */
public class ClassMetaInfo {

    private Map<String,FieldMetaInfo> fieldMetaInfoMap = new HashMap<String,FieldMetaInfo>();

    public  ClassMetaInfo(Class<?> clzz){
        Method[] clzzMethods = clzz.getMethods(); Method method;String methodName;FieldMetaInfo fieldMetaInfo;char c;
        for(int i = 0,len = clzzMethods.length;i<len;i++){
            if((c = ReflectUtil.isGetterOrSetterName(methodName = (method = clzzMethods[i]).getName()))!='\0'){
                methodName = ReflectUtil.myName(methodName);
                fieldMetaInfo = (fieldMetaInfo = fieldMetaInfoMap.get(methodName))==null
                        ? new FieldMetaInfo(methodName):fieldMetaInfo;
                if(c=='s'){
                    fieldMetaInfo.buildSetter(method);
                }else {
                    fieldMetaInfo.buildGetter(method);
                }
                if(!fieldMetaInfo.hasGetter()||!fieldMetaInfo.hasSetter()){
                    fieldMetaInfoMap.put(methodName,fieldMetaInfo);
                }
            }
        }
    }


    public FieldMetaInfo getFieldMetaInfo(String name){
        return fieldMetaInfoMap.get(name);
    }


}
