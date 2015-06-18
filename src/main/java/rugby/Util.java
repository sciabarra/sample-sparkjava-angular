package rugby;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by msciab on 16/06/15.
 */
public class Util {

    public static class ToJson implements ResponseTransformer {
        private Gson gson = new Gson();
        @Override
        public String render(Object model) throws Exception {
            return gson.toJson(model);
        }
    }
    public static ToJson toJson = new ToJson();

    public static int toInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch(Exception ex) {
            return 0;
        }
    }
}
