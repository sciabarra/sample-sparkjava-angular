package todo;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.parsing.Parser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import rugby.todo.TodoItem;

import java.util.Map;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static rugby.Util.*;


/**
 * Created by msciab on 27/06/15.
 */
@RunWith(JUnit4.class)
public class TodoRestTest {

    long firstId;

    @Before
    public void init() {
        /**
         * Initialize setting the parser to JSON and the port to 4567
         * Extract the id as the first one
         */
        port = 4567;
        defaultParser = Parser.JSON;
        firstId = get("/todo/test").then()
                //.log().body()
                .body("count", is(1))
                .extract().path("items[0].id")
        ;
        //System.out.println(firstId);
    }

    @Test
    public void testGet() {
        get("/todo").then()
                //.log().body()
                .body("count", is(1))
                .body("items[0].action", is("Add things to do."))
        ;
    }

    @Test
    public void testPost() {
        /**
         * Note here you constuct a json request on the fly with map(...) and list(...)
         * Example map("a", "1", "b", list(2, 3), "c", list(map("d", 4), map("d", 5))
         */
        with()
                .body(map("action", "first", "priority", "HIGH"))
                .post("/todo").then()
                //.log().body()
                .body("count", is(2))
                .body("items[1].action", is("first"))
                .body("items[1].priority", is("HIGH"))
        ;

    }

    @Test
    public void testPut() {
        with()
                .body(map("id", firstId, "action", "replaced", "priority", "LOW"))
                .put("/todo").then()
                //.log().body()
                .body("count", is(1))
                .body("items[0].action", is("replaced"))
                .body("items[0].priority", is("LOW"))
        ;
    }

    @Test
    public void testDelete() {


        // given().log().all().
        delete("/todo/{id}", firstId).then()
                //.log().body()
                .body("count", is(0))
                .body("items", is(list()))
        ;
    }


}
