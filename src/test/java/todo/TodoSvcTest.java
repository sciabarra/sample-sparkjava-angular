package todo;

import org.fluentlenium.adapter.FluentTest;

import static org.fluentlenium.assertj.FluentLeniumAssertions.*;

import org.fluentlenium.adapter.util.SharedDriver;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import javax.swing.*;
import javax.swing.text.html.HTML;

/**
 * Created by msciab on 18/06/15.
 */
@SharedDriver(type = SharedDriver.SharedType.ONCE)
@RunWith(JUnit4.class)
public class TodoSvcTest extends FluentTest {

    FluentWebElement e;

    @Before
    public void init() {
        goTo("http://localhost:4567/todo/test");
    }

    @Test
    public void test() {
        goTo("http://localhost:4567/html/index.html");
        assertThat(find("#todolist").find("li").text()).hasText("things to do");

        fill("#actioninput").with("First");
        find("#actionbutton").click();
        e = find("#todolist").find("li", 1);
        //System.out.println("*****" + e.html());
        assertThat(e).hasText("First");
        find("input[type='radio']").get(0).click();
        //JOptionPane.showConfirmDialog(null, e);
        e = find("#todolist").find("li").first();
        assertThat(e).hasText("First");
    }

    PhantomJSDriver phjs = new PhantomJSDriver();
    @Override public WebDriver getDefaultDriver() {
        return phjs;
    }

}
