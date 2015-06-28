package rugby.todo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by msciab on 16/06/15.
 */
@NoArgsConstructor
public class TodoList {

    @Getter
    private int count = 0;

    @Getter
    List<TodoItem> items = new LinkedList<TodoItem>();

    public TodoList add(TodoItem item) {
        items.add(item);
        ++count;
        return this;
    }

    public TodoList update(TodoItem item) {
        Iterator<TodoItem> it = items.listIterator();
        int pos = 0;
        while (it.hasNext())
            if (it.next().getId() == item.getId())
                break;
            else
                pos++;
        if (pos < items.size())
            items.set(pos, item);

        return this;
    }

    public TodoList remove(long id) {
        Iterator<TodoItem> it = items.listIterator();
        while (it.hasNext())
            if (it.next().getId() == id)
                it.remove();
        count = items.size();
        return this;
    }

    public TodoList test() {
        items = new LinkedList<TodoItem>();
        count = 0;
        return add(new TodoItem("Add things to do.", TodoItem.Priority.NORMAL));
    }

    /*
    public static void main(String[] args) {
        TodoList l = new TodoList();
        l.test();
        System.out.println(l.items);
        l.remove(l.items.get(0).getId());
        System.out.println(l.count);
    }*/
}

