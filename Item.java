public class Item {

    private String name;

    private int incrHp ;
    private int incrMana ;
    private int incrStamina ;
    public Item (String name, int incrHp, int incrMana, int incrStamina){
        this.name = name;
        this.incrHp = incrHp;
        this.incrMana = incrMana;
        this.incrStamina = incrStamina;

    }

    public String getName() {return name;}
    public int getIncrMana() {return incrMana;}
    public int getIncrHp() {return incrHp;}
    public int getIncrStamina() {return incrStamina;}

}

