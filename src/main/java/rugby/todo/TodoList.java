package rugby.todo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by msciab on 16/06/15.
 */
public class TodoList {
    List<TodoItem> list;

    public TodoList() {
       reset();
    }

    public List<TodoItem> list() {
        return list;
    }

    public List<TodoItem> add(String action) {
        list.add(new TodoItem(action));
        return list;
    }

    public List<TodoItem> remove(int position) {
        list.remove(position);
        return list;
    }

    public void reset() {
        list= new LinkedList<TodoItem>();
    }

    public String test() {
        reset();
        add("Add things to do.");
        return "OK";
    }
}

