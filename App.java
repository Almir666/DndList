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

    public ArrayDeque<Characters> Add_hero(ArrayDeque<Characters> ListBattle, Characters pers) {
        ListBattle.addLast(ListBattle.pollFirst());
        ListBattle.addFirst(pers);
        return ListBattle;
    }

    public void Battle(ArrayDeque<Characters> ListBattle) {
        System.out.println("Бой начался!");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Ход: " + ListBattle.peekFirst().getName());
            System.out.println("Для следующего хода нажмите: 1 ");
            System.out.println("Другое меню: 0 ");
            String step = in.next();
            switch (step) {
                case "1":
                    ListBattle.addLast(ListBattle.pollFirst());
                    break;
                case "0":
                    System.out.println("Убрать персонажа: 1\nДобавить персонажа: 2\nВыход: 0");
                    String menu = in.next();
                    switch (menu) {
                        case "0":
                            in.close();
                            return;
                        case "1":
                            System.out.println("Имя персонажа: ");
                            String keyHero = in.next();
                            ListBattle = Del_hero(ListBattle, keyHero);
                            break;
                        case "2":
                            System.out.println("Введите имя персонажа");
                            String Pers_name = in.next();
                            System.out.println("Введите колличесто HP");
                            String Pers_hp = in.next();
                            int Hp = Integer.parseInt(Pers_hp);
                            Characters Pers = new Characters(Pers_name, Hp);
                            Add_hero(ListBattle, Pers);
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
