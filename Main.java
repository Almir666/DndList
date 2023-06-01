import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Characters Hero1 = new Characters("Yotun", 100);
        Characters Hero2 = new Characters("Jaina", 50);
        Characters Hero3 = new Characters("Rakot", 75);
        Characters Mob1 = new Characters("Zombie", 50);
        Characters Mob2 = new Characters("Skeleton", 30);

        ArrayDeque<Characters> PersList = new ArrayDeque<>();
        PersList.add(Hero1);
        PersList.add(Hero2);
        PersList.add(Hero3);
        PersList.add(Mob1);
        PersList.add(Mob2);

        App action = new App();
        action.start(PersList);
    }
}
