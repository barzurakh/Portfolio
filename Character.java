public class Character {
    int hp;
    int mana;
    int stamina;
    private Item[] items = new Item[15];
    String ally;
    int damage;
    int exp;
    java.util.Scanner scan = new java.util.Scanner(System.in);

        public int getHp () {return hp;}
        public int getMana (){return mana;}
        public int getStamina() {return stamina;}

    public Character (int hp, int mana, int stamina, Item[] items, int damage, String ally)
    {
        this.hp = hp;
        this.mana = mana;
        this.stamina = stamina;
        this.items = items;
        this.damage = damage;
        this.ally = ally;
    }
    public Character (int hp, int mana, int stamina, Item[] items, int damage, String ally, int exp)
    {
        this.hp = hp;
        this.mana = mana;
        this.stamina = stamina;
        this.items = items;
        this.damage = damage;
        this.ally = ally;
        this.exp = exp;

    }
//    public Character (int hp, int mana, int stamina, int damage, String ally)
//    {
//        this.hp = hp;
//        this.mana = mana;
//        this.stamina = stamina;
//        this.items = null;
//        this.damage = damage;
//        this.ally = ally;
//    }

    public String toString ()
    {
        return "Character's characteristics: \n1.HP: " + hp + "\n2.Mana: " + mana + "\n3.Stamina: " + stamina + "\n4.Damage: " + damage + /*"\n5.Position: " + ally +*/ "\n5.EXP: " + exp;
    }

    public void powerUp () {
        for (Item item : items)
        {
            if (item!=null) {
                hp += item.getIncrHp();
                mana += item.getIncrMana();
                stamina += item.getIncrStamina();
            }
        }
    }
    public void powerUpAfterDef (Character enemy) {
        for (Item item : enemy.items)
        {
            if(item!=null) {
                hp += item.getIncrHp();
                mana += item.getIncrMana();
                stamina += item.getIncrStamina();
            }
        }

        int n=0;

        if (items.length !=0) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] == null) {
                    items[i] = enemy.items[n];
                    n++;
                }
            }
        }
    }

    public void attackMagChar (Character enemy) {

            if (mana <= 0) System.out.println("Unfortunately you run out of Mana energy");
            else {
                mana = mana - 1;
                enemy.hp -= damage;

                System.out.println("Your enemy's hp was decreased by " + damage);
                System.out.println("You have used your mana energy");

                if (enemy.hp <= 0) {
                    System.out.println("Your enemy has been defeated and all his items are now yours))) ");
                    powerUpAfterDef(enemy);
                }
            }
    }

    public void attackPhChar (Character enemy) {
        if (stamina <= 0) System.out.println("Unfortunately you run out of Stamina energy");
        else {
            stamina = stamina - 1;
            enemy.hp -= damage;

            System.out.println("Your enemy's hp was decreased by " + damage);
            System.out.println("You have used your stamina energy");

            if (enemy.hp <= 0) {
                System.out.println("Your enemy has been defeated and all his items are now yours)))");
                powerUpAfterDef(enemy);
        }
        }
    }

    public Boolean isAlly ()
    {
        if (ally == "Ally") return true;
        return false;
    }
    public void callAlly (Character c, Character enemy) {
        System.out.println("You have called one of yours Allies");
        System.out.println("Please choose the type of attack: ");
        System.out.println("1.Magic \n2.Physical");
        int a = scan.nextInt();
        switch (a) {
            case 1: c.attackMagChar(enemy);
            break;
            case 2: c.attackPhChar(enemy);
        }
    }
    public void callAlly (Character c, Monster enemy) {
        System.out.println("You have called one of yours Allies");
        System.out.println("Please choose the type of attack: ");
        System.out.println("1.Magic \n2.Physical");
        int a = scan.nextInt();
        switch (a) {
            case 1: c.attackMagChar(enemy);
                break;
            case 2: c.attackPhChar(enemy);
        }
    }

    public void attackMainC (Character enemy, int al) {

        if (mana > 0) {
            mana = mana -1;
            enemy.hp = enemy.hp - damage/al;
            System.out.println("\nYour Enemy attacked you, your hp was decreased by " + damage/al);
            System.out.println("Enemy has used his mana energy \n");
        }

        else if (stamina>0) {
            stamina = stamina - 1;
            enemy.hp -= damage/al;

            System.out.println("\nYour Enemy attacked you, your hp was decreased by " + damage/al);
            System.out.println("Enemy has used his stamina energy \n");
        }

        else System.out.println("\nFortunately for You, your Enemy ran out of energy, so just kill him now");

        if (enemy.hp <= 0)
        {
                System.out.println("Unfortunately You have been defeated and killed, but the legends about Your adventures were spreading all over the world for centuries \n(not sure tho) ");
                System.out.println("GAME OVER");
                System.out.println(":(");
        }
    }
    public void attackMagChar (Monster enemy) {

        if (mana <= 0) System.out.println("Unfortunately you run out of Mana energy");
        else {
            mana = mana - 1;
            enemy.hp -= damage;

            System.out.println("\nYour enemy's hp was decreased by " + damage);
            System.out.println("You have used your mana energy");

            if (enemy.hp <= 0) {
                System.out.println("Monster has been defeated))) ");
            }
        }
    }

    public void attackPhChar (Monster enemy) {
        if (stamina <= 0) System.out.println("Unfortunately you run out of Stamina energy");
        else {
            stamina = stamina - 1;
            enemy.hp -= damage;

            System.out.println("\nYour enemy's hp was decreased by " + damage);
            System.out.println("You have used your stamina energy");

            if (enemy.hp <= 0) {
                System.out.println("Monster has been defeated)))");
            }
        }
    }
    public void isAllyAlive (Character[] ally, int id)
    {
        if (ally[id].hp < 0) {
            System.out.println("Unfortunately Your Ally died fighting for You(" +
                    "\nDon't waste his sacrifice");
            for (int i = 0; i < ally.length - 1; i++) {
                ally[i] = ally[i + 1];
            }
        }

    }

}
