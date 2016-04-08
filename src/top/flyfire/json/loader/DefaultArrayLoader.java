package top.flyfire.json.loader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyy_work on 2016/4/8.
 */
public class DefaultArrayLoader extends Loader<List,Integer> {

    public DefaultArrayLoader(Loader prev) {
        super(prev);
    }

    public DefaultArrayLoader() {
        super();
    }

    @Override
    protected void init() {
        this.container = new ArrayList<>(10);
    }

    @Override
    public void load(Object object) {
        this.container.add(this.t,object);
    }

    @Override
    public boolean prepare(Integer integer) {
        this.t = integer;
        return true;
    }
}
