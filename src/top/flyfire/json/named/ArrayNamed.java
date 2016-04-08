package top.flyfire.json.named;

/**
 * Created by shyy_work on 2016/4/7.
 */
public class ArrayNamed extends Named<Integer> {

    public ArrayNamed(Integer integer) {
        super(integer);
    }

    public ArrayNamed(Integer integer, Named prev) {
        super(integer, prev);
    }

    @Override
    public String globalNamed() {
        if(globalNamed==null){
            globalNamed = this.prev.globalNamed()+"["+this.t+"]";
        }
        return globalNamed;
    }

}
