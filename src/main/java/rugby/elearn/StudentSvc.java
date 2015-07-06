package rugby.elearn;

import rugby.jooq.tables.records.ClassRecord;
import rugby.jooq.tables.records.StudentRecord;

import java.util.List;

import static rugby.Main.db;
import static rugby.Util.*;
import static rugby.jooq.Tables.STUDENT;
import static spark.Spark.*;

/**
 * Created by msciab on 16/06/15.
 */
public class StudentSvc {

    static List<Student> selectAll() {
        return db.selectFrom(STUDENT).fetchInto(Student.class);
    }

    public static void routes() {
        get("/student", "application/json", (q, s) -> {
            s.type("application/json");
            return selectAll();
        }, toJson);

        get("/student/:id", "application/json", (q, s) -> {
            s.type("application/json");
            return db.selectFrom(STUDENT)
                    .where(STUDENT.ID.eq(toLong(q.params(":id"))))
                    .fetchAny().into(Student.class);
        }, toJson);

        post("/student", "application/json", (q, s) -> {
            s.type("application/json");
            StudentRecord r = db.newRecord(STUDENT);
            r.from(parse.fromJson(q.body(), StudentRecord.class));
            r.store();
            return selectAll();
        }, toJson);

        put("/student", "application/json", (q, s) -> {
            s.type("application/json");
            Student student = parse.fromJson(q.body(), Student.class);
            StudentRecord r = db.fetchOne(STUDENT, STUDENT.ID.equal(student.getId()));
            r.from(student);
            r.store();
            return selectAll();
        }, toJson);

        delete("/student/:id", "application/json", (q, s) -> {
            s.type("application/json");
            db.fetchOne(STUDENT, STUDENT.ID.equal(toLong(q.params(":id")))).delete();
            return selectAll();
        }, toJson);

    }

}
