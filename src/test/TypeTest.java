package test;

import java.lang.reflect.*;
import java.util.*;

/**
 * Created by flyfire[dev.lluo@outlook.com] on 2016/4/13.
 */
public class TypeTest{
    Map<String,String> map = new HashMap<String,String>();
    List<String> list  = new ArrayList<>();
    public static void main(String[] args) throws ReflectiveOperationException {
        //new TypeToken(TypeTest.class.getDeclaredField("list").getGenericType()){};
        //new TypeToken<Number[]>(){};//List<String>
        new TypeToken(TypeWrapper.class.getField("field").getGenericType()){};
        List<? super Integer>  list =new ArrayList<Number>();
    }

    public static class TypeWrapper<T extends Number>{
        public T field;
        public T[] fieldA;
        public List<? super Number> filedB;
    }

    public static class TypeToken<T>{
        public TypeToken(Type type){
            typeUnWrapper(type);
        }

        public TypeToken(){
            Type pType = this.getClass().getGenericSuperclass();
            if(pType instanceof Class){
                throw new RuntimeException("Missing type parameter.");
            }
            typeUnWrapper(((ParameterizedType)pType).getActualTypeArguments()[0]);
        }
    }



    static Type typeUnWrapper(Type type){
        if(type instanceof Class){
            return type;
        }else if(type instanceof ParameterizedType){
            return type;
        }else if(type instanceof GenericArrayType){
            return type;
        }else if(type instanceof WildcardType){
            return type;
        } else{
            return type;
        }
    }

}
