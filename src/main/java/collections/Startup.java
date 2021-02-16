package collections;

import java.util.*;

public class Startup {

    public static void main(String[] args) {
        Student[] studenti = new Student[4];
        studenti[0] = new Student("ciccio", "pasticcio");
        studenti[1] = new Student("peppe", "nappa");
        studenti[2] = new Student("gianni", "pinotto");

        studenti[0] = studenti[1];  // peppe al posto di ciccio
        studenti[1] = studenti[2];  // gianni al posto di peppe
        studenti[2] = null;

        studenti[3] = studenti[2];
        studenti[2] = studenti[1];
        studenti[1] = studenti[0];
        studenti[0] = new Student("pippo", "pluto");

//        for (int i = 0; i < studenti.length; i++) {
//            studenti[i].studia();
//            if(studenti[i].getName().equals("ciccio")) {
//                studenti[i] = new Student("pippo", "pippo");    // funziona
//            }
////            studenti[i] = new Student();
//        }

//        for (Student s : studenti) {
//            s.studia();
//            if(s.getName().equals("ciccio")) {
//                s = new Student("pippo", "pippo");  // inutile
//            }
////            s = new Student();      // non serve a nulla
//        }

        studenti[0] = null;

        System.out.println(studenti.length);

        List ss = new ArrayList();  // random access O(1)
        ss = new LinkedList();      // access O(n)

//        ss.get(3);

        List result = getList();

        for (int i = 0; i < result.size(); i++) {    // O(n^2) con una linkedlist
            System.out.println(result.get(i));
        }

        System.out.println(result.getClass().getSimpleName());  // ritorna il nome della classe dell'oggetto puntato da ss
        System.out.println(result.iterator().getClass().getSimpleName());
        for (Iterator it = result.iterator(); it.hasNext();) {
            Object o = it.next();
            System.out.println(o);
            o = new Student();      // o è una copia della reference
        }

        for(Object o : result) {
            result.remove(4);   // crash: non posso modificare la collection quando ciclo con iterator
        }

//        Object x = result.get(5);
//        if(x instanceof Student) {
//            Student s = (Student) x;
//        }
//        Student y = (Student) result.get(5);    // crash se result non contiene Student

        List<Student> ls = new ArrayList<>();
        ls.add(new Student());
//        Student z = ls.get(0);

        ArrayList lx = new ArrayList<Student>();    // ArrayList e ArrayList<Student> sono esattamente la stessa classe
        ArrayList<Student> as = new ArrayList();

        ls = new ArrayList();

        List<Student> lt = getList();
        g(lt);

        Set<Student> sx = new HashSet<>();
        Set<Student> st = new TreeSet<>();
        Student s1 = new Student("ciccio", "pasticcio");
        Student s2 = new Student("gianni", "pasticcio");

        sx.add(s1);
        sx.add(s2);
        System.out.println(sx.size());  // stamperà 2 perchè sono stati inseriti due oggetti diversi (se equals e hashcode non sono definiti in student)

        List<Student> lista = new ArrayList<>();
        lista.add(s1);
        lista.add(s2);
        Collections.sort(lista);

        StudentComparatorByNameLength comp = new StudentComparatorByNameLength();
        Collections.sort(lista, Comparator.comparingInt(o -> o.getName().length()));

        Comparable x1 = lista.get(0);
        Comparable x2 = lista.get(lista.size()-1);
        int result2 = x1.compareTo(x2);

    }

    public static void g (List x) { }

    public static List getList() {
        return new ArrayList();
//        return new LinkedList();
    }

}

class StudentComparatorByNameLength implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().length() - o2.getName().length();
    }
}