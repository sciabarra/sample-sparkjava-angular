package rugby;

import static spark.Spark.*;
import rugby.todo.Todo;

public class Main {

    public static void main(String[] args) {

        externalStaticFileLocation("target/web/public/main");

        App.routes();

        Todo.routes();

    }
}