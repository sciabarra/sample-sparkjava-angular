package rugby;

import static spark.Spark.*;

import rugby.control.classroom.ClassroomSvc;
import rugby.todo.TodoSvc;

public class Main {

    public static void main(String[] args) {

        externalStaticFileLocation("target/web/public/main");
        TodoSvc.routes();
        ClassroomSvc.routes();


    }
}
