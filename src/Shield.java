public class Shield {
    private int level;
    private int damage;
    private int defend;
    private double weight;

    public Shield(int level){
        this.level = level;
        this.damage = level;
        this.defend = level *3;
        this.weight = level *5;
    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefend(){
        return defend;
    }

    public double getWeight() {
        return weight;
    }

    public void levelup(){
        level++;
        damage = level;
        defend = level*3;
        weight = level *2;

    }


}
