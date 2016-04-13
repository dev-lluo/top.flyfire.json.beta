package top.flyfire.json.loader;

import top.flyfire.json.reflect.ClassMetaInfo;
import top.flyfire.json.reflect.FieldMetaInfo;

/**
 * Created by shyy_work on 2016/4/13.
 */
public class AdvancedObjectLoader extends Loader<Object,String> {

    private ClassMetaInfo classMetaInfo;

    private FieldMetaInfo fieldMetaInfo;

    @Override
    protected void init() {
        this.container = this.classMetaInfo.newInstance();
    }

    @Override
    public boolean prepare(String s) {
        this.t = s;
        return (this.fieldMetaInfo = this.classMetaInfo.getFieldMetaInfo(this.t))!=null;
    }

    @Override
    public void load(Object object) {
        this.fieldMetaInfo.invokeSetter(this.container,object);
    }

    public AdvancedObjectLoader(Loader prev) {
        super(prev);
    }

    public AdvancedObjectLoader() {
        super();
    }
}
