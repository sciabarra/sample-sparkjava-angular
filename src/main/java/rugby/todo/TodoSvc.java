package rugby.todo;

import rugby.Util;

import static rugby.Util.*;

import static spark.Spark.*;

/**
 * Created by msciab on 16/06/15.
 */
public class TodoSvc {

    static TodoList todos = new TodoList();

    public static void routes() {

        get("/todo", "application/json", (q, s) -> {
            s.type("application/json");
            return todos;
        }, toJson);

        post("/todo", "application/json", (q, s) -> {
            s.type("application/json");
            TodoItem item = parse.fromJson(q.body(), TodoItem.class);
            item.setId(Util.nextId());
            return todos.add(item);
        }, toJson);

        put("/todo", "application/json", (q, s) -> {
            s.type("application/json");
            TodoItem item = parse.fromJson(q.body(), TodoItem.class);
            return todos.update(item);
        }, toJson);

        delete("/todo/:id", "application/json", (q, s) -> {
            s.type("application/json");
            long id = toLong(q.params(":id"));
            System.out.println("*** removing "+id+" in "+todos.getItems());
            return todos.remove(id);
        }, toJson);

        get("/todo/test", (q, s) -> {
            s.type("application/json");
            return todos.test();
        }, toJson);
    }

}
