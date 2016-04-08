package top.flyfire.json.loader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shyy_work on 2016/4/8.
 */
public class DefaultObjectLoader extends Loader<Map<String,Object>,String> {

    public DefaultObjectLoader(Loader prev) {
        super(prev);
    }

    public DefaultObjectLoader() {
        super();
    }

    @Override
    protected void init() {
        this.container = new HashMap<>();
    }

    @Override
    public void load(Object object) {
        container.put(this.t,object);
    }

    @Override
    public boolean prepare(String s) {
        this.t = s;
        return !container.containsKey(this.t);
    }
}
