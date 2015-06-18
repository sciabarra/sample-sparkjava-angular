package todo;

import org.fluentlenium.adapter.FluentTest;
import static org.fluentlenium.assertj.FluentLeniumAssertions.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * Created by msciab on 18/06/15.
 */
@RunWith(JUnit4.class)
public class TodoTest extends FluentTest {
    @Before public void init() {

        initFluent(new ChromeDriver());
        goTo("http://localhost:4567/todo/test");
    }
    @Test
    public void test() {
        goTo("http://localhost:4567/html/index.html");
        assertThat(find("#todolist").find("li").text()).hasText("things to do");

    }
}
