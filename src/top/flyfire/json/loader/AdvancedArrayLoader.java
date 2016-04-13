package top.flyfire.json.loader;

import java.util.List;

/**
 * Created by shyy_work on 2016/4/13.
 */
public class AdvancedArrayLoader extends Loader<List,Integer> {
    @Override
    protected void init() {

    }

    @Override
    public boolean prepare(Integer integer) {
        this.t = integer;
        return true;
    }

    @Override
    public void load(Object object) {

    }

    public AdvancedArrayLoader() {
        super();
    }

    public AdvancedArrayLoader(Loader prev) {
        super(prev);
    }
}
