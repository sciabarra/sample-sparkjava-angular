package rugby;

import static spark.Spark.*;

import org.h2.tools.Server;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import rugby.elearn.ClassSvc;
import rugby.todo.TodoSvc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static DSLContext db;
    private static String driver = "org.h2.Driver";
    private static String url = String.format("jdbc:h2:file:%s/target/rugby", System.getProperty("user.dir"));
    private static String user = "SA";
    private static String password = "";

    private static void initDatabase() {
        try {
            Class.forName(driver);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Server.createWebServer("-webDaemon").start();
            db = DSL.using(conn, SQLDialect.H2);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot start database - exiting.");
            System.exit(1);
        }
    }

    private static void initRoutes() {
        externalStaticFileLocation("target/web/public/main");
        App.routes();
        TodoSvc.routes();
        ClassSvc.routes();
    }

    public static void main(String[] args) {
        initDatabase();
        initRoutes();
    }

}