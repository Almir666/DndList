import java.util.Scanner;
import java.util.ArrayDeque;

public class App {
    Characters hero;

    public void start(ArrayDeque<Characters> ListBattle) {
        ArrayDeque<Characters> SecondList = new ArrayDeque<>();
        Scanner in = new Scanner(System.in);
        int size_deque = ListBattle.size();
        while (true) {
            System.out.println("Для следующего хода нажмите: 1 ");
            System.out.println("Выход: 0 ");
            String key = in.next();
            switch (key) {
                case "1":
                    if (ListBattle.peekFirst() != null)  {
                        System.out.println("Ход: " + ListBattle.peekFirst().getName());
                        SecondList.add(ListBattle.pollFirst());   
                    }
                    if (ListBattle.size() != size_deque) {
                        ListBattle.add(SecondList.pollFirst());
                    }
                    break;
                case "0":
                    return;    
                    default:
                    System.out.println("Такой команды нет");
                    break;    
            }
        }
    }

}
