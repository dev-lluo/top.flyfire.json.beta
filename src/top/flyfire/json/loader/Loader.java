package top.flyfire.json.loader;

/**
 * Created by shyy_work on 2016/4/8.
 */
public abstract class Loader<C,T> {

    protected Loader prev;

    protected C container;

    protected T t;

    protected abstract void init();

    public abstract boolean prepare(T t);

    public abstract void load(Object object);

    public Loader call(){
        this.prev.load(this.container);
        Loader temp = this.prev;
        this.destory();
        return temp;
    }

    protected void destory(){
        this.prev = null;
        this.container = null;
        this.t = null;
    }

    public Loader() {
        super();
        this.init();
    }

    public Loader(Loader prev) {
        this.prev = prev;
        this.init();
    }
}
