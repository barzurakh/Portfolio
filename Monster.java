import java.util.Scanner;

public class Monster {

    Scanner scan = new Scanner(System.in);
    int hp = (int)(Math.random()*5 + 1);
    private int ExpToGive = (int)(Math.random()*3 + 1);
    private int damage = (int)(((Math.random() * 10)%3) + 1);
//    public Monster (int hp)
//    {
//        this.hp = hp;
//    }

    public int getDamage (){return damage;}

    public void attackChar (Character enemy) {
        enemy.hp -= damage;

        System.out.println("\nMonster has attacked you");
            System.out.println("Your hp was decreased by " + damage + "\n");
        if (enemy.hp <= 0)
        {
            System.out.println("Unfortunately You have been defeated, and You are dead now");
            System.out.println("GAME OVER");
            System.out.println(":(");
        }
    }

    public void updateChar(Character mainC)
    {
        int t=0;
        while (t==0) {
            System.out.println("\nPlease type the number of Energy you want to update with the earned EXP  your HP, Mana and Stamina");
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            if ((a + b + c) != mainC.exp) {
                System.out.println("\nPlease be sure that your limit is " + mainC.exp + "EXP");
                System.out.println("Retype the values please)");
            }
            else
            {
                mainC.hp += a;
                mainC.mana += b;
                mainC.stamina += c;
                System.out.println("\nYour characteristics have been increased");
                System.out.println(mainC);
                t=1;
            }
        }
    }
    public int getExp () {return ExpToGive;}

    public String toString ()
    {
        return "Monster's characteristics: \n1.HP: " + hp + "\n2.Damage: " + damage + "\nExp: " + ExpToGive;
    }
}
