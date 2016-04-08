package top.flyfire.json.named;

/**
 * Created by shyy_work on 2016/4/7.
 */
public class RootNamed extends Named<String> {

    public RootNamed(){
        super("#");
        this.globalNamed = "#";
    }

    @Override
    public String globalNamed() {
        return globalNamed;
    }
}
