import java.util.Random;

public class Nekromanta extends Wizard implements IMagic{
    private int mana; // dodajemy do klasy pole mana
    Szkielet szkielet; //odwołujemy się do klasy wewnętrznej

    public Nekromanta(String name, int health, int strength, int mana) {
        super(name, health, strength,mana);
        this.mana=mana; //odwołujemy się do magii
        createSzkelet((int) (health *0.4),  strength*2); //tworzymy różnice statystyk między szkieletem a nekromantem

    }

    static Nekromanta generateRandomNekromanta(){ // Tutaj generujemy nekromante
        Random generator = new Random();
        int heal = generator.nextInt(51)+50;
        int str = generator.nextInt(10)+10;
        int mana = generator.nextInt(20)+30;

        return new Nekromanta("abc",heal, str, mana); //Zwraca nam nekromente
    }



    @Override
    public Hero duel(Hero other) {
        while(true)
        {
            if(this instanceof IMagic){
                this.magicAttack(other);
            } else {
                this.attack(other);}
            if(!other.isAlive()) break;

            if(other instanceof  IMagic){
                ((IMagic) other).magicAttack(this);
            }else {
                other.attack(this);}

            if(!this.isAlive()) break;



        }
        if(this.isAlive()&& !other.isAlive()){
            System.out.println("Starcie wojowników wygrywa: " + this.name);
            return this;
        }
        if(other.isAlive()&& !this.isAlive()){
            System.out.println("Starcie wojowników wygrywa: " + other.name);
            return other;
        }

        return null;

    }

    @Override
    public void magicAttack(Hero other) {
        Random losowo = new Random();
        int dodatkoweOb = losowo.nextInt(7)-3;
        int dmg;
        if (other instanceof IMagic){
            dmg= szkielet.strength; //siła nekromaty to siła jego szkieleta
            other.health = other.health - dmg; // zdrowie atakowanego to jego zdrowie odjąć dmg atakującego.
            System.out.println(" Bohater "+this.getClass()+" "+ this.name + " Atakuje szkieletem za: "+dmg + " punktów : "+other.getClass() +" "+other.name+"Bedzie miał on teraz tyle zdrowia: "+other.health);
        }
        else {
            dmg = this.mana + dodatkoweOb;
            other.health = other.health - dmg;
            System.out.println(" Bohater "+ this.getClass()+" "+ this.name + " Atakuje magicznie za: "+dmg + " punktów : "+other.getClass() +" "+other.name+"Bedzie miał on teraz tyle zdrowia: "+other.health);
        }

    }
       private void createSzkelet(int hp, int str){ //tworzymy metode szkielet
        int szkieletHeal =(int)(hp* 0.4);
        int szkieletStr = str *2;
        szkielet =new Szkielet(szkieletHeal,szkieletStr);
       }
    class Szkielet{ //Klasa wewnętrzna szkielet
        protected int health;
        protected int strength; //pola zdrowie i siła

        void createSzkelet(int health, int strength)
        {
            new Szkielet(health,strength);}
        private Szkielet (int health, int strength){  //konstruktor klasy
            this.strength= strength;
            this.health=health;
        }

    }

}

