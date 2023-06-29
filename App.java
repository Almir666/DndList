import java.util.Scanner;
import java.util.ArrayDeque;

public class App {

    public ArrayDeque<Characters> Del_hero(ArrayDeque<Characters> ListBattle, String name) {
        Boolean Recover = true;
        String Recover_point = ListBattle.peekFirst().getName();
        int ListSize = ListBattle.size();
        for (int i = 0; i < ListSize; i++) {
            if (ListBattle.peekFirst().getName().equals(name)) {
                ListBattle.pollFirst();
            }
            ListBattle.addLast(ListBattle.pollFirst());
        }
        while (Recover) {
            if (ListBattle.peekFirst().getName().equals(Recover_point)) {
                Recover = false;
            }
            ListBattle.addLast(ListBattle.pollFirst());
        }
        return ListBattle;
    }

    public ArrayDeque<Characters> Clear_List(ArrayDeque<Characters> List) {
        for (int i = 0; i < List.size() + 1; i++) {
            List.pollFirst();
        }
        return List;
    }

    public ArrayDeque<Characters> Add_hero(ArrayDeque<Characters> List) {
        return null;
    }

    public void start(ArrayDeque<Characters> ListBattle) {
        System.out.println("Бой начался!");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Ход: " + ListBattle.peekFirst().getName());
            System.out.println("Для следующего хода нажмите: 1 ");
            System.out.println("Другое меню: 0 ");
            String key = in.next();
            switch (key) {
                case "1":
                    ListBattle.addLast(ListBattle.pollFirst());
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
