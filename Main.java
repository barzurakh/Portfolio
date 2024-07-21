public class Main extends Exception {
    public static void main(String[] args) {
        java.util.Scanner s = new java.util.Scanner(System.in);
        System.out.println("Please be sure that compiler is on the whole screen to enjoy the game because there are a lot of text ");
        {
        System.out.println("\nHello User:)");
        System.out.println("It is little RPG Text Game and You are his Main Character)");
        System.out.println("\nHere are the rules and aspects of my game:");
        System.out.println("1.Firstly you will create the Characteristics for your Character ( all in summery should have 15 points )");
        System.out.println("\n2.Every Character has:  ");
        System.out.println("· HP - Character's health points");
        System.out.println("· Mana - is the energy for the Magic Attacks");
        System.out.println("· Stamina - is the energy for the Physical Attacks" +
                "\n· EXP - experience" +
                "\n· Damage level" +
                "\n· Items - which encrease Character's HP, Mana and Stamina");
        System.out.println("\n3.On your adventure You can meet Monsters and another Characters" +
                "\nMonsters are pure Evil and they will destroy everything on their way" +
                "\nCharacters however can be bad or good, so check their side everytime" +
                "\n\n5.Every time you meet someone You will have bunch of actions You'll be able to do" +
                "\nEvery actions have number and when choosing the action just type the number of it" +
                "\nAfter killing Bad Character all His Items move to you" +
                "\nIf you met a Good Character, he will be Your Ally and You can call him any time while attacking" +
                "\nIf You call Your Ally to attack, the damage of Attack will be Your Ally's damage level, BUT the damage from the Enemy will be divided \nbetween you all " +
                "\n\nGood luck buddy, hope You will be at home safe and happy, playing with Your children and enjoying Your lovely wife Janny " +
                "\n(I added family to Your Character to motivate You more hehe) ");
    }

        System.out.println("\nPlease type the HP, Mana and Stamina you want your Character to have:");
        System.out.println("(remember that it should be 15 in summery)");
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        if ((a + b + c)!=15) {throw new IllegalArgumentException("Please be sure that the values are 15 in summery"); }
        Item[] items = new Item[15];
        items [0] = new Item("knife", 5,2,1);

        Character  mainC = new Character(a, b, c, items, 4, "Main Character", 0);  // Main Character
        mainC.powerUp();
        System.out.println("\nYour Character was powered up with the knife");

        int n1 = (int) (Math.random()*3 +1); // number of the NotAlly Characters
        int n2 = (int) (Math.random()*3 + 2); // number of the Ally Characters
        int n3 = (int)(Math.random()*5 +3); // number of the Monsters

        Character[] character = new Character[n1 + n2];
        for (int i= 0; i< n1 + n2; i++) // Creating Characters
        {
            // Randomizers for the:
            int a1 = (int)(Math.random()*10 +1); // hp
            int b1 = (int) (Math.random()*5 +1); // mana
            int c1 = (int) (Math.random()*3 +1); // stamina
            int nI = (int)(Math.random()*3);  // number of the Items every NotAlly has
            int nI1= (int)(Math.random()*8);  // Item's hp increaser
            int nI2= (int)(Math.random()*4);  // Item's mana increaser
            int nI3= (int)(Math.random()*4);  // Item's stamina increaser
            int dam= (int) (Math.random()*5 + 1);

            Item[] items1 = new Item[15];
            for (int j= 0;j<nI;j++) {
                items1[j] = new Item("sword", nI1, nI2, nI3);
            }
            if (i<n1) {
                character[i] = new Character(a1, b1, c1, items1, dam, "Enemy");
                character[i].powerUp();
            }
            else {
                character[i] = new Character(a1, b1, c1, items1, dam, "Ally");
                character[i].powerUp();
            }
        }

        Monster[] monster = new Monster[n3];
        for (int i= 0; i< n3; i++) // Creating Monsters
        {
            monster[i] = new Monster();
//            System.out.println(monster[i]);  // Created Monsters
        }

        Character[] allies  = new Character[n2]; // Allies of the Main Character

        int i=0, l1=0;   // for the loop1: create new Enemy or Ally on the User's way
        int l2=0;   //         loop2: ask User what action he wants to do now

        int allnumb = 0; // for the Allies array
        int t = 0; // for the escaping the "if condition" if the User asked about is he Ally or not
        int al = 1; // for the allies (when User calls his ally once the damage from the Enemy is divided by 2 of them)
        int ans3 = 0;

        while (l1==0) {
            al=1;
            l2 = 0;
            t = 0;

            if (i > (n1 + n2)){ System.out.println("\nCongratulaaaaataion!!!");
                System.out.println("You have survived this adventure and now You have some story to tell to Your grandchildren) ");
                System.out.println("You can rest now, or try once again if You are that brave ;)");
                l1 = 1;
            }
            else{
                int i1 = (int) (Math.random() * 3); // randomizer, to pick the enemy ( Character of Monster)
                int i2 = (int) (Math.random() * (n1 + n2)); // randomizer, to pick one of the characters from the array
                int i3 = (int) (Math.random() * n3); // to pick one of the monsters from the array

                i++;
                if ((i1 <= 1) && (character[i2] != null)) { // if it is character on our way
                    System.out.print("\n---------------------");
                    System.out.println("\nYour " + mainC);
                    System.out.println("---------------------");

                    System.out.println("\nYou have seen the Character[" + i2 + "]");
                    System.out.println(character[i2]);
                    System.out.println("\nWhat do you want to do? :");

                    while (l2 == 0) { // Loop with the actions of the Main Character and Ally/Enemy
                        if (character[i2] != null) {

                            System.out.println("\n1.Check is it Ally or not \n2.Attack");
                            if (allies[0] != null) {
                                System.out.println("3.Call an Ally");
                            }
                            int ans = s.nextInt(); // User's answer (next action)


                            switch (ans) {
                                case 1:
                                    if (t == 0) {
                                        System.out.println(character[i2].isAlly());

                                        if ((character[i2].isAlly())) {
                                            System.out.println("\nCongrats !!! \nNow you can call your new Ally any time and he will always take your back)");
                                            allies[allnumb] = character[i2];
                                            System.out.print("(new Ally was added to your team)" + "\n ");
                                            character[i2] = null;
                                            allnumb++;
                                            l2 = 1;
                                            t = 1;

                                            break;
                                        } else {
                                            System.out.println("\nThe Character seemed to be very aggressive, I think he wants to destroy you) ");
                                            System.out.print("You have no choice but to attack him");
                                            System.out.println("(I did not add the Speed characteristic, so ,unfortunately, you can not run away)");
                                            t = 1;
                                            break;
                                        }
                                    } else {
                                        System.out.println("\nYou have already found out that he is not an Ally, You need to keep attacking him or he will kill You(");
                                        break;
                                    }
                                case 2:
                                    System.out.println("\nWhat type of attack do you prefer? :");
                                    System.out.println("\n1.Magic \n2.Physical");
                                    int ans2 = s.nextInt();
                                    switch (ans2) {
                                        case 1:
                                            mainC.attackMagChar(character[i2]);
                                            if (character[i2].hp <= 0) {
                                                character[i2] = null;
                                                l2 = 1;
                                            }
                                            break;
                                        case 2:
                                            mainC.attackPhChar(character[i2]);
                                            if (character[i2].hp <= 0) {
                                                character[i2] = null;
                                                l2 = 1;
                                            }
                                    }
                                    if ((character[i2] != null) && (character[i2].ally == "Ally")) {
                                        System.out.println("\nUnfortunately the Character you attacked was your Ally, but you did not give him a chance but to try to kill you ");
                                        character[i2].ally = "Enemy";
                                        System.out.println("He is your Enemy now(");
                                    }
                                    break;
                                case 3:
                                    System.out.print("Here are the members of your team : \n");
                                    int k = 0;
                                    while ((k < n2) && (allies[k] != null)) {
                                        System.out.println(k+1 + ". " + allies[k]);
                                        k++;
                                    }

                                    System.out.println("Please choose one of your Allies:");
                                    ans3 = s.nextInt();
                                    mainC.callAlly(allies[ans3-1], character[i2]);
                                    al++;

                                    if (character[i2].hp <= 0) {
                                        character[i2] = null;
                                        l2 = 1;
                                    }

                            }

                            if (l2 == 0) // Character's move (always attack)
                            {
                                character[i2].attackMainC(mainC, al);
                                if (al>1){ allies[ans3-1].hp -= character[i2].damage/al;
                                    System.out.println("Your Ally's HP was decreased by " + character[i2].damage/al);
                                    mainC.isAllyAlive(allies, ans3-1);
                                }

                                if (mainC.hp <= 0) {
                                    l2 = 1;
                                    l1 = 1;
                                }
                            }
                        } else l2 = 1;
                    }
                }
                if ((monster[i3] != null) && (l2 == 0)) // if it is monster on our way
                {
                    System.out.print("\n---------------------");
                    System.out.println("\nYour " + mainC);
                    System.out.println("---------------------");

                    System.out.println("\nYou have seen the Monster[" + i3 + "]");
                    System.out.println(monster[i3]);
                    System.out.print("\nWhat do you want to do? :");

                    while ((l2 == 0)) { // Loop with the actions of the Main Character and Monster
                        if (monster[i3] != null) {
                            System.out.println("\n1.Attack");
                            if (allies[0] != null) {
                                System.out.println("2.Call an Ally");
                            }
                            int ans = s.nextInt(); // User's answer (next move)


                            switch (ans) {
                                case 1:
                                    System.out.println("\nWhat type of attack do you prefer? :");
                                    System.out.println("\n1.Magic \n2.Physical");
                                    int ans2 = s.nextInt();
                                    switch (ans2) {
                                        case 1:
                                            mainC.attackMagChar(monster[i3]);
                                            if (monster[i3].hp <= 0) {
                                                System.out.println("\nYou have earned " + monster[i3].getExp() + "EXP");
                                                mainC.exp += monster[i3].getExp();

                                                if (mainC.exp > 5) {
                                                    System.out.println("\nYou have earned " + mainC.exp + "EXP. That is more than 5 EXP, so You can update your characteristics)");
                                                    monster[i3].updateChar(mainC);
                                                    mainC.damage += 1;
                                                    System.out.println("Also Your damage level was increased by 1");
                                                    mainC.exp = 0;
                                                }

                                                monster[i3] = null;
                                                l2 = 1;
                                            }
                                            break;
                                        case 2:
                                            mainC.attackPhChar(monster[i3]);
                                            if (monster[i3].hp <= 0) {
                                                System.out.println("\nYou have earned " + monster[i3].getExp() + "EXP");
                                                mainC.exp += monster[i3].getExp();
                                                if (mainC.exp > 5) {
                                                    System.out.println("\nYou have earned"+ mainC.exp + "EXP. That is more than 5 EXP, You can update your characteristics)");
                                                    monster[i3].updateChar(mainC);
                                                }
                                                monster[i3] = null;
                                                l2 = 1;
                                            }
                                    }
                                    break;
                                case 2:
                                    System.out.println("*****");
                                    System.out.print("Here are the members of your team : \n");

                                    int k = 0;
                                    while ((k <=n2) && (allies[k] != null)) {
                                        System.out.println(k+1 + ". " + allies[k]);
                                        k++;
                                    } // Printing out your Allies
                                    System.out.println("*****");

                                    System.out.println("Please choose one of your Allies:");
                                    ans3 = s.nextInt();
                                    mainC.callAlly(allies[ans3-1], monster[i3]);
                                    if (monster[i3].hp <= 0) {
                                        monster[i3] = null;
                                        l2 = 1;
                                    }
                            }

                            if (l2 == 0) // Monster's move (always attack)

                            {
                                monster[i3].attackChar(mainC);
                                if (al>1){ allies[ans3-1].hp -= monster[i3].getDamage()/al;
                                    System.out.println("Your Ally's HP was decreased by " + monster[i3].getDamage()/al);
                                    mainC.isAllyAlive(allies, ans3-1);
                                }
                                if (mainC.hp <= 0) {
                                    System.out.print("\nDon't worry, You can try one more time whenever You want)");
                                    l2 = 1;
                                    l1 = 1;
                                }
                            }
                        } else l2 = 1;
                    }

                }
            }
        }
    }
}