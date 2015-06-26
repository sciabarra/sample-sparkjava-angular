package rugby.control.classroom;

import rugby.todo.TodoItem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by riccardobachetti on 22/06/15.
 */
public class ClassroomList {
        List<ClassroomItem> list;
        List<Studenti> studenti;
        List<Professori> professori;
        List<Materie> materie;

        public ClassroomList() {
            reset();
        }

        public void reset() {
            list = new LinkedList<ClassroomItem>();
            studenti= new LinkedList<Studenti>();
            professori= new LinkedList<Professori>();
            materie= new LinkedList<Materie>();
        }

        public List<ClassroomItem> list() {
            return list;

        }

        public List<ClassroomItem> addclasse(String nome) {
            list.add(new ClassroomItem(nome));
            return list;
        }

        public List<ClassroomItem> delclasse(int position) {
            list.remove(position);
            return list;
        }

        public List<Studenti> addstudente(String nome,String cognome){
            studenti.add(new Studenti(nome, cognome));
            return studenti;

        }

        public List<Studenti> delstudente(int position) {
             studenti.remove(position);
             return studenti;
        }


    public List<Professori> addprofessore(String nome, String cognome){
            professori.add(new Professori(nome, cognome));
            return professori;

    }

        public List<ClassroomItem> delprofessore(int position) {
            professori.remove(position);
            return list;
        }

        public List<Materie> addmateria(String nome){
            materie.add(new Materie(nome));
            return materie;

        }

         public List<Materie> delmateria(int position) {
            materie.remove(position);
            return materie;
        }






}
