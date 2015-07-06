package rugby.elearn;

import lombok.*;
import rugby.Util;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by msciab on 16/06/15.
 */

@NoArgsConstructor
@ToString
public class Class {

    @Getter @Setter
    long id = Util.nextId();

    @Getter @Setter
    String name;

    @Getter @Setter
    List<Student> students;
}
