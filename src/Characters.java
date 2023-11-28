public class Characters {
    private int level;
    private int maxHP;
    private int maxMana;
    private int currentHP;
    private int currentMana;
    private int ATK;
    private int DEF;
    private double Speed;
    private Sword equippedSword;
    private Shield equippedShield;


    public Characters(int level){
        this.level = level;
        this.maxHP = level * 10;
        this.maxMana = level * 5;
        this.currentHP = maxHP;
        this.currentMana = maxMana;
        this.ATK = level;
        this.DEF = level;
        this.Speed = 100;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int getATK() {
        return ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public double getSpeed() {
        return Speed;
    }

    public Sword getEquippedSword() {
        return equippedSword;
    }

    public void equippedSword(Sword sword) {
        equippedSword = sword;
        Speed -= sword.getWeight();
        ATK += sword.getDamage();
        DEF += sword.getDefense();
    }

    public Shield getEquippedShield() {
        return equippedShield;
    }

    public void equippedShield(Shield shield){
        equippedShield = shield;
        Speed -= shield.getWeight();
        ATK += shield.getDamage();
        DEF += shield.getDefend();
    }

    public void levelUp(){
        level++;
        maxHP = level * 10;
        maxMana = level * 5;
        currentHP = maxHP;
        currentMana = maxMana;
        ATK =level;
        DEF =level;
        Speed = 100;
    }

    public void attack(Characters target){
        int playerATK =ATK;
        int damage = 0;
        int defense = DEF;


        if (equippedSword != null) {
            playerATK += equippedSword.getDamage();
        } else if (equippedShield != null) {
            playerATK += equippedShield.getDamage();
        }

        if (playerATK > defense) {
            damage = playerATK - defense;
        }

        currentHP -= damage;
        reduceMana(20);
        target.takeDamage(Math.max(0,damage - defense));

    }

    private void reduceMana(int amount){
        currentMana -= 20;
        if (currentMana <= 0){
            currentMana = 0;
            System.out.println("Mana: " + currentMana);
        }
    }

    public void takeDamage(int damage) {
        int baseDefense = level;
        int effectiveDefense;

        if (equippedShield != null) {
            effectiveDefense = equippedShield.getDefend() + (baseDefense);
        } else {
            effectiveDefense = baseDefense;
        }

        damage = Math.max(0, damage - effectiveDefense);

        currentHP -= damage;

        if (currentHP <= 0) {
            System.out.println("YOU DEAD!!!");
        }else {
            System.out.println("HP: " + currentHP +"/"+ maxHP + "Mana: " + currentMana+"/"+maxMana);
        }
    }

}
