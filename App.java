import java.util.Scanner;
import java.util.ArrayDeque;

public class App {
    Characters hero;

    public ArrayDeque<Characters> Del_hero(ArrayDeque<Characters> List, String name) {
        ArrayDeque<Characters> SecondList = new ArrayDeque<>();
        for (int i = 0; i < List.size(); i++) {
            if (List.peekFirst() != null) {    
                if (!List.peekFirst().getName().equals(name)) {
                    SecondList.add(List.pollFirst());
                } else {
                    List.pollFirst();
                }
            }    
        }
        return SecondList;
    }
    public ArrayDeque<Characters> Add_hero(ArrayDeque<Characters> List) {
        return null;
    }

    public void start(ArrayDeque<Characters> ListBattle) {
        ArrayDeque<Characters> SecondList = new ArrayDeque<>();
        Scanner in = new Scanner(System.in);
        int size_deque = ListBattle.size();
        while (true) {
            System.out.println("Для следующего хода нажмите: 1 ");
            System.out.println("Другое меню: 0 ");
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
                    System.out.println("Убрать персонажа: 1\nДобавить персонажа: 2\nВыход: 0");  
                    String key2 = in.next();
                    switch (key2) {
                        case "0":
                            in.close();
                            return;
                        case "1":
                        System.out.println("Имя персонажа: ");
                        String keyHero = in.next();
                            ListBattle = Del_hero(ListBattle, keyHero);
                            SecondList = Del_hero(SecondList, keyHero);
                            size_deque = ListBattle.size() + SecondList.size();
                            break;
                        case "2":
                            Add_hero(ListBattle);
                            break;        
                    }
                    break;
                    default:
                    System.out.println("Такой команды нет");
                    break;    
            }
        }
    }

}
