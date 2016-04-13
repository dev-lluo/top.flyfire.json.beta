package top.flyfire.json.loader;

/**
 * Created by shyy_work on 2016/4/13.
 */
public interface LoaderManager {

    LoaderManager DEFAULT = new DefaultLoaderManager();

    LoaderManager ADVANCED = new AdvancedLoaderManager();

    Loader array();

    Loader object();

    Loader primitive();

    Loader array(Loader prev);

    Loader object(Loader prev);

    Loader primitive(Loader prev);

}
