package top.flyfire.json.named;

/**
 * Created by shyy_work on 2016/4/7.
 */
public class ObjectNamed extends Named<String> {

    public ObjectNamed(String s) {
        super(s);
    }

    public ObjectNamed(String s, Named prev) {
        super(s, prev);
    }

    @Override
    public String globalNamed() {
        if(globalNamed==null){
            globalNamed = this.prev.globalNamed()+"."+this.t;
        }
        return globalNamed;
    }

}
