package rugby.todo;
import static rugby.Util.*;

import static spark.Spark.*;

/**
 * Created by msciab on 16/06/15.
 */
public class Todo {

    static TodoList todos = new TodoList();

    public static void routes() {
        get("/todo/list", (q, s) ->  todos.list(), toJson);
        get("/todo/add/:action", (q, s) ->  todos.add(q.params(":action")), toJson);
        get("/todo/del/:index", (q, s) ->  todos.remove(toInt(q.params(":index"))), toJson);
        get("/todo/test", (q, s) ->  todos.test());

    }

}
