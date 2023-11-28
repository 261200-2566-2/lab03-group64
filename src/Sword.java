public class Sword {
    private int level;
    private int damage;
    private int defense;
    private double weight;


    public Sword(int level){
        this.level = level;
        this.damage = level * 2;
        this.weight = level *4;
        this.defense = level;

    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public double getWeight() {
        return weight;
    }

    public void levelUp() {
        level++;
        damage = level *2;
        weight = level *2;
        defense = level;

    }
}
