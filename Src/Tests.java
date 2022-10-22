import org.junit.Test;
import static org.junit.Assert.*;


public class Tests {

    //тестирование метода addition_head
    @Test
    public void addition_head() {
        int data = 22;
        List<Integer> actual_list = new List<>(15);
        actual_list.addition_head(data);
        List<Integer> expected_list = new List<>(15);
        Element<Integer> tmp = new Element<>();
        tmp.next = expected_list.getHead();
        tmp.value = data;
        expected_list.setHead(tmp);
        assertEquals(expected_list, actual_list);
    }

    //тестирование метода addition_tail
    @Test
    public void addition_tail() {
        int data = 22;
        List <Integer> actual_list = new List<>(15);
        actual_list.addition_tail(data);
        List <Integer> expected_list = new List<>(15);
        Element<Integer> tmp = new Element<>();
        tmp.next = null;
        tmp.value = data;
        expected_list.getTail().next = tmp;
        expected_list.setTail(tmp);
        assertEquals(expected_list, actual_list);

    }



    //тестирование метода delete_elem
    @Test
    public void delete_elem() {
        int data = 25;
        List<Integer> expected_list = new List<>();

        for(int i = 22; i < 26; ++i) {
            expected_list.addition_tail(i);
        }
        expected_list.delete_elem(data);

       List<Integer> actual_list = new List<>();

        for(int i = 22; i < 26; ++i) {
            actual_list.addition_tail(i);
        }

        assertEquals(actual_list,expected_list);
    }
}
