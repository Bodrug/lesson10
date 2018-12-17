package ua.hillel.lesson10;
import org.junit.Test;
import static org.junit.Assert.*;
public class MyListTest {
    @Test
    public void addtest(){
        MyList<String> list = new MyList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        //list.add("4");
        MyList<String>.Node<String> tail = list.tail();
        String value = tail.getValue();
        //assertEquals(value,"3");
        //list.iterate(System.out::println);
        assertTrue(list.size() == 3);
        assertTrue(list.contains("3"));
        assertFalse(list.contains("4"));
        //list.remove("4");
        list.iterate(System.out::println);
        System.out.println(list.get(1));
        //assertArrayEquals(new Object[]{"1","2","3"},list.toArray());
        /*for (String s:list) {
            System.out.println(s);
        }*/
    }
}
