package top.flyfire.json.loader;

/**
 * Created by shyy_work on 2016/4/13.
 */
public class AdvancedLoaderManager implements LoaderManager {
    @Override
    public Loader array() {
        return new AdvancedArrayLoader();
    }

    @Override
    public Loader object() {
        return new AdvancedObjectLoader();
    }

    @Override
    public Loader primitive() {
        return new AdvancedPrimitiveLoader();
    }

    @Override
    public Loader array(Loader prev) {
        return new AdvancedArrayLoader(prev);
    }

    @Override
    public Loader object(Loader prev) {
        return new AdvancedObjectLoader(prev);
    }

    @Override
    public Loader primitive(Loader prev) {
        return new AdvancedPrimitiveLoader(prev);
    }


}
