import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static Characters player = new Characters(1);
    static Characters enemy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerLevel = player.getLevel();
        int playerMaxHP = player.getMaxHP();
        int playerMaxMana = player.getMaxMana();
        int playerCurrentHP = player.getCurrentHP();
        int playerCurrentMana = player.getCurrentMana();
        int playerATK = player.getATK();
        int playerDEF = player.getDEF();
        double playerSpeed = player.getSpeed();

//        int BaseATK = 0; //calculator state.
//        int ATK = 0;
//        int def = 0;
//        System.out.println("what your level: ");
//        int level = scanner.nextInt();
//        System.out.println("what sword level: ");
//        int Swordlevel = scanner.nextInt();
//        System.out.println("what shiled level: ");
//        int Shieldlevel = scanner.nextInt();
//
//        for(int i = 1 ; i <= level ;i++) {
//            BaseATK = i;
//            ATK = (Swordlevel * 2) + (BaseATK *2 );
//            def = (Shieldlevel * 3) + (BaseATK);
//            System.out.println("BaseAtk: " +BaseATK +"ATK: " + ATK +"def: " + def);
//        }

        System.out.println("What your name?");
        String Name = scanner.nextLine();
        System.out.println("Player: " + Name + "    Level: " + playerLevel
                + "\nHP: " + playerCurrentHP + "/" + playerMaxHP
                + "    Mana : " + playerCurrentMana + "/" + playerMaxMana
                + "\nATK: " + playerATK + "    DEF: " + playerDEF
                + "    Speed: " + (int) playerSpeed);

        System.out.println("Do you want to equip a Sword (1), Shield (2), or Nothing (3)?");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 :
                System.out.println("Equipping Sword!!!");
                Sword sword = new Sword(1);
                player.equippedSword(sword);
                playerATK += sword.getDamage();
                playerDEF += sword.getDefense();
                playerSpeed -= sword.getWeight();
                System.out.println("HP: " + playerCurrentHP + "/" + playerMaxHP
                        + "    Mana : " + playerCurrentMana + "/" + playerMaxMana
                        + "\nATK: " + playerATK + "    DEF: " + playerDEF
                        + "    Speed: " + (int) playerSpeed);
                break;
            case 2:
                System.out.println("Equipping Shield!!!");
                Shield shield = new Shield(1);
                player.equippedShield(shield);
                playerATK += shield.getDamage();
                playerDEF += shield.getDefend();
                ;
                playerSpeed -= shield.getWeight();
                System.out.println("HP: " + playerCurrentHP + "/" + playerMaxHP
                        + "    Mana : " + playerCurrentMana + "/" + playerMaxMana
                        + "\nATK: " + playerATK + "    DEF: " + playerDEF
                        + "    Speed: " + (int) playerSpeed);
                break;
            case 3:
                System.out.println("You chose not to equip anything.");
                System.out.println("HP: " + playerCurrentHP + "/" + playerMaxHP
                        + "    Mana : " + playerCurrentMana + "/" + playerMaxMana
                        + "\nATK: " + playerATK + "    DEF: " + playerDEF
                        + "    Speed: " + (int) playerSpeed);
                break;
            default:
                System.out.println("Invalid choice. You chose not to equip anything.");

        }

        int enemyLevel = random.nextInt(3) + playerLevel;
        int enemyWeaponType = random.nextInt(3);
        enemy = new Characters(enemyLevel);

        switch (enemyWeaponType) {
            case 1:
                System.out.println("\nEnemy has Sword (Level " + enemyLevel + ")");
                Sword enemySword = new Sword(enemyLevel);
                enemy.equippedSword(enemySword);
                break;
            case 2:
                System.out.println("\nEnemy has Shield (Level " + enemyLevel + ")");
                Shield enemyShield = new Shield(enemyLevel);
                enemy.equippedShield(enemyShield);
                break;
            default:
                System.out.println("\nEnemy has no weapon.");
        }

        System.out.println("\n         Enemy Level: " + enemyLevel +
        "\nEnemy HP: " + enemy.getCurrentHP() + "/" + enemy.getMaxHP()
        +"   Enemy Mana: " + enemy.getCurrentMana() + "/" + enemy.getMaxMana()
        +"\nEnemy ATK: " + enemy.getATK()
        +"   Enemy DEF: " + enemy.getDEF()
        +"   Enemy Speed: " + (int) enemy.getSpeed());


    }
}
