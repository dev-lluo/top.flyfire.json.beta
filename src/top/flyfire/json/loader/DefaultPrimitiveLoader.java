package top.flyfire.json.loader;

/**
 * Created by shyy_work on 2016/4/8.
 */
public class DefaultPrimitiveLoader extends Loader<Object,Object> {
    public DefaultPrimitiveLoader() {
        super();
    }

    public DefaultPrimitiveLoader(Loader prev) {
        super(prev);
    }

    @Override
    public void load(Object object) {
        this.container =  object;
    }

    @Override
    public boolean prepare(Object object) {
        return true;
    }

    @Override
    protected void init() {

    }
}
