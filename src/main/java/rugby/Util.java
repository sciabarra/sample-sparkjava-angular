package rugby;

import com.google.gson.Gson;
import spark.ResponseTransformer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        } catch (Exception ex) {
            return 0;
        }
    }

    public static long toLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (Exception ex) {
            return 0;
        }
    }

    public static float toFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (Exception ex) {
            return 0;
        }
    }

    public static double toDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (Exception ex) {
            return 0;
        }
    }
    public static Gson parse = new Gson();

    private static long currId = System.currentTimeMillis();

    public static synchronized long nextId() {
        return ++currId;
    }


    public static Map<String, ?> map(Object... args) {
        Map<String, Object> m = new HashMap<String, Object>();
        for (int i = 0; i < args.length-1; i+=2)
            m.put(args[i].toString(), args[i + 1]);
        return m;
    }


    public static List<Object> list(Object... args) {
        List<Object> list = new LinkedList<Object>();
        for (Object o : args)
            list.add(o);
        return list;
    }
}
