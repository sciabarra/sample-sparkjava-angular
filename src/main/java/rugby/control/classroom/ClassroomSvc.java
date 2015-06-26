package rugby.control.classroom;

import static rugby.Util.*;
import static spark.Spark.*;

/**
 * Created by riccardobachetti on 22/06/15.
 */
public class ClassroomSvc {
    static ClassroomList list = new ClassroomList();

    public static void routes() {
        get("/classroom/classe", (q, s) -> list.list(), toJson);
        get("/classroom/classe/add/:classe", (q, s) -> list.addclasse(q.params(":classe")), toJson);
        get("/classroom/classe/del/:index", (q, s) -> list.delclasse(toInt(q.params(":index"))), toJson);
        get("/classroom/classe/addS/:nome/:cognome", (q, s) -> list.addstudente(q.params(":nome"), q.params(":cognome")), toJson);
        get("/classtroom/classe/delS/:index", (q, s) -> list.delstudente(toInt(q.params(":index"))), toJson);
        get("/classroom/classe/addP/:nome/:cognome", (q, s) -> list.addprofessore(q.params(":nome"), q.params(":cognome")), toJson);
        get("/classtroom/classe/delP/:index", (q, s) -> list.delprofessore(toInt(q.params(":index"))), toJson);
        get("/classroom/classe/addM/:nome", (q, s) -> list.addmateria(q.params(":nome")), toJson);
        get("/classtroom/classe/delM/:index", (q, s) -> list.delmateria(toInt(q.params(":index"))), toJson);


    }
}


