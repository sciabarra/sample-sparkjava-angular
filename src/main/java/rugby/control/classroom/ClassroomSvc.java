package rugby.control.classroom;

import rugby.todo.TodoList;

import static rugby.Util.toInt;
import static rugby.Util.toJson;
import static spark.Spark.get;

/**
 * Created by riccardobachetti on 22/06/15.
 */
public class ClassroomSvc {
    static ClassroomList list = new ClassroomList();

    public static void routes() {
        get("/classroom/list", (q, s) -> list.list(), toJson);
        get("/classroom/add/:name", (q, s) -> list.add(q.params(":name")), toJson);
        get("/classroom/del/:index", (q, s) -> list.remove(toInt(q.params(":index"))), toJson);
        get("/classroom/test", (q, s) -> list.test());

    }
}