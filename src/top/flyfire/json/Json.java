package top.flyfire.json;

import test.ClassA;
import top.flyfire.json.loader.*;
import top.flyfire.json.named.ArrayNamed;
import top.flyfire.json.named.Named;
import top.flyfire.json.named.ObjectNamed;
import top.flyfire.json.named.RootNamed;
import top.flyfire.json.value.PrimitiveModel;

/**
 * Created by flyfire[dev.lluo@outlook.com] on 2016/4/7.
 */
public class Json {
    private ParserSet parserSet;

    private LoaderManager loaderManager;

    private Named named;

    private Loader loader;

    private String source;

    private int cursor;

    private int cursorBound;

    private boolean parsed;

    public Json(String source) {
        super();
        this.source = source;
        this.cursor = 0;
        this.cursorBound = source.length();
        this.loaderManager = LoaderManager.DEFAULT;
    }

    public Json(String source, Class<?> clzz){

    }

    public void parse(){
        this.named = new RootNamed();
        this.parserSet = new ParserSet();
        this.peek().parse();
        this.parsed = true;
    }

    private boolean roll(){
        this.cursor++;
        return this.cursor<this.cursorBound;
    }

    private Parser peek(){
        char dest = this.source.charAt(cursor);
        if(Peeker.isArrayStart(dest)){
            if(!this.roll()) throw new RuntimeException(this.source);
            this.loader = this.loaderManager.array();
            return parserSet.ArrayParser;
        }else if(Peeker.isObjectStart(dest)){
            if(!this.roll()) throw new RuntimeException(this.source);
            this.loader = this.loaderManager.object();
            return parserSet.ObjectParser;
        }else{
            this.loader = this.loaderManager.primitive();
            return parserSet.PrimitiveParser;
        }
    }

    private class ParserSet {
        Parser ObjectParser = new ObjectParser();
        Parser ObjectPrimitiveParser = new ObjectPrimitiveParser();
        Parser ArrayParser = new ArrayParser();
        Parser ArrayPrimitiveParser = new ArrayPrimitiveParser();
        Parser PrimitiveParser = new PrimitiveParser();
    }

    private class ObjectParser implements Parser {
        @Override
        public void parse() {
            if(this.startObject()) {
                do {
                    this.readProperty();
                    this.readValue();
                }while(this.hasNextObjectElement());
            }
            this.endObject();
        }

        private boolean startObject(){
            char dest = Json.this.source.charAt(Json.this.cursor);
            if(Peeker.isObjectEnd(dest)){
                Json.this.roll();
                return false;
            }else{
                return true;
            }
        }

        private void endObject(){

        }

        private void readProperty(){
            int start = Json.this.cursor;
            int end = -1;
            while(Json.this.roll()&&end==-1){
                if(Peeker.isColon(Json.this.source.charAt(Json.this.cursor))){
                    end = Json.this.cursor;
                }
            }
            String property = Json.this.source.substring(start,end);
            Json.this.named = new ObjectNamed(property,Json.this.named);
            Json.this.loader.prepare(property);
        }

        private void readValue(){
            this.peek().parse();
            Json.this.named = Json.this.named.call();
            Json.this.loader = Json.this.loader.call();
        }

        private boolean hasNextObjectElement(){
            char dest = Json.this.source.charAt(Json.this.cursor);
            Json.this.roll();
            if(Peeker.isObjectEnd(dest)){
                return false;
            }else if(Peeker.isComma(dest)){
                return true;
            }else{
                throw new RuntimeException(Json.this.source.substring(0,Json.this.cursor));
            }
        }

        private Parser peek(){
            char dest;
            if(Peeker.isArrayStart(dest = Json.this.source.charAt(Json.this.cursor))){
                if(!Json.this.roll()) throw new RuntimeException(Json.this.source);
                Json.this.loader = Json.this.loaderManager.array(Json.this.loader);
                return parserSet.ArrayParser;
            }else if(Peeker.isObjectStart(dest)){
                if(!Json.this.roll()) throw new RuntimeException(Json.this.source);
                Json.this.loader = Json.this.loaderManager.object(Json.this.loader);
                return parserSet.ObjectParser;
            }else{
                Json.this.loader = Json.this.loaderManager.primitive(Json.this.loader);
                return parserSet.ObjectPrimitiveParser;
            }
        }

    }

    private class ObjectPrimitiveParser implements Parser {
        @Override
        public void parse() {
            int start = Json.this.cursor, end = -1;char dest,skip = ((skip = Json.this.source.charAt(Json.this.cursor))=='\"'||skip=='\'')?skip:'\0';
            while(Json.this.roll()&&end==-1){
                if(((skip=((dest = Json.this.source.charAt(Json.this.cursor))==skip?'\0':skip))=='\0')&&Peeker.isComma(dest = Json.this.source.charAt(Json.this.cursor))
                        ||Peeker.isObjectEnd(dest)){
                    end = Json.this.cursor;
                    break;
                }
            }
            Json.this.loader.load(new PrimitiveModel(Json.this.source.substring(start, end)).val());
        }
    }

    private class ArrayParser implements Parser {
        @Override
        public void parse() {
            if(this.startArray()) {
                int index = 0;
                do {
                    this.prevRead(index++);
                    this.readCell();
                }while(this.hasNextArrayCell());
            }
            this.endArray();
        }

        private boolean startArray(){
            char dest;
            if(Peeker.isArrayEnd(dest = Json.this.source.charAt(Json.this.cursor))){
                Json.this.roll();
                return false;
            }else{
                return true;
            }
        }

        private void prevRead(int i){
            Json.this.named = new ArrayNamed(i,Json.this.named);
            Json.this.loader.prepare(i);
        }

        public void readCell(){
            this.peek().parse();
            Json.this.named = Json.this.named.call();
            Json.this.loader = Json.this.loader.call();
        }

        private boolean hasNextArrayCell(){
            char dest = Json.this.source.charAt(Json.this.cursor);
            Json.this.roll();
            if (Peeker.isArrayEnd(dest)){
                return false;
            }else if(Peeker.isComma(dest)){
                return true;
            }else{
                throw new RuntimeException(Json.this.source.substring(0,Json.this.cursor));
            }
        }

        private void endArray(){

        }

        private Parser peek(){
            char dest ;
            if(Peeker.isArrayStart(dest = Json.this.source.charAt(cursor))){
                if(!Json.this.roll()) throw new RuntimeException(Json.this.source);
                Json.this.loader = Json.this.loaderManager.array(Json.this.loader);
                return parserSet.ArrayParser;
            }else if(Peeker.isObjectStart(dest)){
                if(!Json.this.roll()) throw new RuntimeException(Json.this.source);
                Json.this.loader = Json.this.loaderManager.object(Json.this.loader);
                return parserSet.ObjectParser;
            }else{
                Json.this.loader = Json.this.loaderManager.primitive(Json.this.loader);
                return parserSet.ArrayPrimitiveParser;
            }
        }
    }

    private class ArrayPrimitiveParser implements Parser {
        @Override
        public void parse() {
            int start = Json.this.cursor,end = -1;char dest ,skip = ((skip = Json.this.source.charAt(Json.this.cursor))=='\"'||skip=='\'')?skip:'\0';
            while(Json.this.roll()&&end==-1){
                if(((skip=((dest = Json.this.source.charAt(Json.this.cursor))==skip?'\0':skip))=='\0')&&(Peeker.isComma(dest)||Peeker.isArrayEnd(dest))){
                    end = Json.this.cursor;
                    break;
                }
            }
            Json.this.loader.load(new PrimitiveModel(Json.this.source.substring(start, end)));
        }
    }

    private class PrimitiveParser implements Parser {
        @Override
        public void parse() {
            Json.this.loader.load(new PrimitiveModel(Json.this.source).val());
        }
    }
}
