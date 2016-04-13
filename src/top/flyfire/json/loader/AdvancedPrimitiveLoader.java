package top.flyfire.json.loader;

/**
 * Created by shyy_work on 2016/4/13.
 */
public class AdvancedPrimitiveLoader extends Loader<Object,Object> {
    @Override
    protected void init() {

    }

    @Override
    public boolean prepare(Object o) {
        return false;
    }

    @Override
    public void load(Object object) {

    }

    public AdvancedPrimitiveLoader() {
        super();
    }

    public AdvancedPrimitiveLoader(Loader prev) {
        super(prev);
    }
}
