package top.flyfire.json.loader;

/**
 * Created by shyy_work on 2016/4/13.
 */
public class DefaultLoaderManager implements LoaderManager {
    @Override
    public Loader array() {
        return new DefaultArrayLoader();
    }

    @Override
    public Loader object() {
        return new DefaultObjectLoader();
    }

    @Override
    public Loader primitive() {
        return new DefaultPrimitiveLoader();
    }

    @Override
    public Loader primitive(Loader prev) {
        return new DefaultPrimitiveLoader(prev);
    }

    @Override
    public Loader object(Loader prev) {
        return new DefaultObjectLoader(prev);
    }

    @Override
    public Loader array(Loader prev) {
        return new DefaultArrayLoader(prev);
    }
}
