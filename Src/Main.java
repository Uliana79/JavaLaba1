import java.util.Scanner;

public class Main {
    //интерфейс и проверка выбора
    public static int interface_() {
        int num;
        Scanner in = new Scanner(System.in);

        System.out.println("Сделайте выбор:");
        System.out.println("1.Добавить элемент в начало");
        System.out.println("2.Добавить элемент в конец");
        System.out.println("3.Удалить элемент");
        System.out.println("4.Выход");

        for (num = in.nextInt(); num <= 0 || num > 4; num = in.nextInt()) {
            System.out.println("Ошибка, попробуйте снова");
        }
        return num;
    }

   //главная часть
    public static void main(String[] args) {

        System.out.println("Введите количество элементов:");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println("Введите " + N + " элементов:");
        int num = in.nextInt();
        List<Integer> Obj = new List<>(num);

        for (int i = 1; i < N; i++) {
            num = in.nextInt();
            Obj.addition_tail(num);
        }

        System.out.println(Obj);
        num = interface_();

        while (num != 4){

            if (num == 1) {
                System.out.println("Введите элемент, который надо вставить:");
                num = in.nextInt();
                Obj.addition_head(num);
                System.out.println("Новый список:");
                System.out.println(Obj);

            } else if (num == 2) {
                System.out.println("Введите элемент, который надо вставить:");
                num = in.nextInt();
                Obj.addition_tail(num);
                System.out.println("Новый список:");
                System.out.println(Obj);

            } else if (num == 3) {
                System.out.println("Введите элемент, который надо удалить:");
                num = in.nextInt();

                if (Obj.search(num)) {
                    Obj.delete_elem(num);
                    System.out.println("Новый список:");
                    System.out.println(Obj);

                } else {
                    System.out.println("Элемент не найден!");
                }

            }

            num = interface_();
        }


    }
}