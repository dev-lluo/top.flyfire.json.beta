package top.flyfire.json.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by flyfire[dev.lluo@outlook.com] on 2016/4/11.
 */
public class FieldMetaInfo {

    private Method getter;

    private boolean hasGetter;

    private Method setter;

    private boolean hasSetter;

    private Class<?> type;

    private boolean isPrimitive;

    private String name;

    public FieldMetaInfo(String name) {
        super();
        this.name = name;
    }

    public void buildGetter(Method getter){
        this.getter = getter;
        this.type = getter.getReturnType();
        this.isPrimitive = type.isPrimitive()
                ||String.class.isAssignableFrom(type)
                ||Number.class.isAssignableFrom(type)
                ||Date.class.isAssignableFrom(type)
                ||Boolean.class.isAssignableFrom(type);
        this.hasGetter = true;
    }

    public Object invokeGetter(Object target) throws ReflectiveOperationException {
        return this.getter.invoke(target);
    }

    public void buildSetter(Method setter){
        this.setter = setter;
        this.hasSetter = true;
    }

    public void invokeSetter(Object target,Object value) throws ReflectiveOperationException {
        this.setter.invoke(target,value);
    }

    public boolean hasGetter(){
        return this.hasGetter;
    }

    public boolean hasSetter(){
        return this.hasSetter;
    }
}
