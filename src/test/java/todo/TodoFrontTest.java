package todo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.fluentlenium.adapter.util.SharedDriver;
import org.fluentlenium.core.domain.FluentWebElement;

import org.fluentlenium.adapter.FluentTest;
import static org.fluentlenium.assertj.FluentLeniumAssertions.*;

/**
 * Created by msciab on 18/06/15.
 */
@SharedDriver(type = SharedDriver.SharedType.ONCE)
@RunWith(JUnit4.class)
public class TodoFrontTest extends FluentTest {

    FluentWebElement e;
    // NOTE: both PhantomJS, ChromeDriver must be installed
    // http://phantomjs.org/
    // https://sites.google.com/a/chromium.org/chromedriver/
    // on Mac: brew install chromedriver phantomjs

    PhantomJSDriver drv = new PhantomJSDriver();
    // use chrome driver to SEE what you do step by sted
    //ChromeDriver drv = new ChromeDriver();

    @Override
    public WebDriver getDefaultDriver() {
        return drv;
    }

    @Before
    public void init() {
        goTo("http://localhost:4567/todo/test");
    }

    @Test
    public void test() {
        goTo("http://localhost:4567/html/index.html");
        assertThat(find("#todolist").find("li").text()).hasText("things to do");

        // add second item
        fill("#actioninput").with("Second thing");
        find("#addbutton").click();
        e = find("#todolist").find("li", 1);
        assertThat(e).hasText("Second thing");

        // remove first
        find("input[type='radio']").get(0).click();
        find("#donebutton").click();
        //JOptionPane.showConfirmDialog(null, e);
        e = find("#todolist").find("li").first();
        assertThat(e).hasText("Second thing");

        // edit
        find("input[type='radio']").get(0).click();
        find("#editbutton").click();
        e = find("#actioninput").first();

        // TODO: find an assertion that can check the VALUE (not the text) of an element
        //System.out.println("### "+e.getValue());
        //assertThat(e).?????("Second thing")

        // Save
        e.fill().with("First thing");
        find("#savebutton").click();
        e = find("#todolist").find("li").first();
        assertThat(e).hasText("First thing");
    }

}
