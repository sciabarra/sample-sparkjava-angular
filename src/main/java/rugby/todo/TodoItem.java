package rugby.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import rugby.Util;

/**
 * Created by msciab on 16/06/15.
 */

@RequiredArgsConstructor
public class TodoItem {

    public enum Priority {
        HIGH,
        NORMAL,
        LOW
    }

    @Getter
    @Setter
    private long id = Util.nextId();

    @Getter
    final private String action;

    @Getter
    final private Priority priority;

}
