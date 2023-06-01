public class Characters {
    public String name;
    public int hp;
    public int initiative;
    public status_bar status;

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getInitiative() {
        return initiative;
    }
    public status_bar getStatus() {
        return status;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
    public void setStatus(status_bar status) {
        this.status = status;
    }

    public Characters addPers() {
        return null;
    }

    public Characters next() {
        return null;
    }
    public Characters(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public enum status_bar{
        BURNING, FREEZE, BLEEDING, KNOCKOUT, POISONED
    }
}