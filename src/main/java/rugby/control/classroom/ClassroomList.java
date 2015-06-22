package rugby.control.classroom;

import rugby.todo.TodoItem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by riccardobachetti on 22/06/15.
 */
public class ClassroomList {
        List<ClassroomItem> list;

        public ClassroomList() {
            reset();
        }

        public List<ClassroomItem> list() {
            return list;
        }

        public List<ClassroomItem> add(String name) {
            list.add(new ClassroomItem(name));
            return list;
        }

        public List<ClassroomItem> remove(int position) {
            list.remove(position);
            return list;
        }

        public void reset() {
            list= new LinkedList<ClassroomItem>();
        }

        public String test() {
            reset();
            add("Add things to do.");
            return "OK";
        }
    }
