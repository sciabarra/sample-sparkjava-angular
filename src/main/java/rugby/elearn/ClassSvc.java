package rugby.elearn;

import rugby.jooq.tables.records.ClassRecord;

import java.util.List;

import static rugby.Main.db;
import static rugby.Util.*;

import static rugby.jooq.Tables.CLASS;
import static spark.Spark.*;

/**
 * Created by msciab on 16/06/15.
 */
public class ClassSvc {

    static List<Class> selectAll() {
        return db.selectFrom(CLASS).fetchInto(Class.class);
    }

    public static void routes() {
        get("/class", "application/json", (q, s) -> {
            s.type("application/json");
            return selectAll();
        }, toJson);

        get("/class/:id", "application/json", (q, s) -> {
            s.type("application/json");
            return db.selectFrom(CLASS)
                    .where(CLASS.ID.eq(toLong(q.params(":id"))))
                    .fetchAny().into(Class.class);
        }, toJson);

        post("/class", "application/json", (q, s) -> {
            s.type("application/json");
            ClassRecord cr = db.newRecord(CLASS);
            cr.from(parse.fromJson(q.body(), Class.class));
            cr.store();
            return selectAll();
        }, toJson);

        put("/class", "application/json", (q, s) -> {
            s.type("application/json");
            Class clazz = parse.fromJson(q.body(), Class.class);
            ClassRecord cr = db.fetchOne(CLASS, CLASS.ID.equal(clazz.getId()));
            cr.from(clazz);
            cr.store();
            return selectAll();
        }, toJson);

        delete("/class/:id", "application/json", (q, s) -> {
            s.type("application/json");
            db.fetchOne(CLASS, CLASS.ID.equal(toLong(q.params(":id")))).delete();
            return selectAll();
        }, toJson);

        /*get("/todo/test", (q, s) -> {
            s.type("application/json");
            return tasks.test();
        }, toJson);*/
    }

}
