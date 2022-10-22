import java.util.Objects;

//Реализация списка
class Element <T>{
    T value;
    Element<T> next; //указатель на следующий элемент
    Element() {} //конструктор
}

public class List <T> {
    private Element<T> head; //указатель на начало
    private Element<T> tail; //указатель на конец

    protected void setHead(Element<T> t) {
        this.head = t;
    }
    protected void setTail(Element<T> t) {
        this.tail = t;
    }

    List() {}
    List(T data) {
        Element<T> elem = new Element<>();
        elem.next = null;
        elem.value = data;
        this.head = elem;
        this.tail = elem;
    }


    Element<T> getHead() {
        return this.head;
    }
    Element<T> getTail() {
        return this.tail;
    }

   //Добавление элемента в начало
    public void addition_head(T data) {

        if (!this.search(data)) {
            Element <T> temp = new Element<>();
            temp.value = data;

            if (this.head == null) {
                this.setHead(temp);
            }

            else {
                temp.next = this.head;
                this.head = temp;
            }
        }
    }

    //Добавление элемента в конец
    public void addition_tail(T data) {

        if (!this.search(data)) {
            Element<T> temp = new Element<>();
            temp.value = data;
            temp.next = null;

            if (this.tail == null) {
                this.setTail(temp);
            }

            else {
                this.tail.next = temp;
                this.tail = temp;
            }
        }
    }

    //Удаление
    void delete_elem(T data) {

        if (this.head != null) {

            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            }

            else if (this.head.value == data)
                this.head = this.head.next;

            else {
                for(Element<T> tmp = this.head; tmp.next != null; tmp = tmp.next) {
                    if (tmp.next.value == data) {

                        if (this.tail == tmp.next)
                            this.tail = tmp;

                        tmp.next = tmp.next.next;
                        return;
                    }
                }
            }
        }
    }

    //Метод для поиска элемента в списке
    boolean search(T data) {

        for(Element<T> tmp = this.head; tmp != null; tmp = tmp.next) {
            if (tmp.value == data) {
                return true;
            }
        }
        return false;
    }

   //Вывод на консоль
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Element<T> current = head;

        while(current != null){
            result.append(current.value);

            if(current.next != null){
                result.append(", ");
            }

            current = current.next;
        }

        return "Список: " + result;
    }

   //равенство
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        List<T> exp = (List<T>) obj;
        Element<T> a = exp.head;
        Element<T> b;

        for(b = this.head; a != null && b != null; b = b.next) {
            if (a.value != b.value)
                return false;

            a = a.next;
        }
        return true;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(head, tail);
//    }
}
