package top.flyfire.json.named;

/**
 * Created by shyy_work on 2016/4/7.
 */
public abstract class Named<T> {

    protected String globalNamed;

    protected Named prev;

    protected T t;

    public Named(T t){
        this.t = t;
    }

    public Named(T t,Named prev){
        this(t);
        this.prev = prev;
    }

    public abstract String globalNamed();

    @Override
    public String toString(){
        return globalNamed();
    }

    public Named call(){
        Named named = this.prev;
        this.prev = null;
        this.t = null;
        this.globalNamed = null;
        return named;
    }

}
