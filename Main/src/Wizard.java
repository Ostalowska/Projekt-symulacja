import java.util.Random;

public class Wizard extends Hero implements IMagic { // klasa wizard dziedziczy po hiro i implementuje interface
    private int mana; // dodajemy do klasy pole mana
    public Wizard(String name, int health, int strength, int mana) {
        super(name, health, strength); //super to odwołanie do klasy po której dziedziczymy (do Hero)
        this.mana=mana; //Dopisujemy mane bo tak było w zadaniu
    }

    static Wizard generateRandomWizard(){ // generujemy nowego wizarda
        Random generator = new Random();
        int heal = generator.nextInt(51)+50;
        int str = generator.nextInt(10)+10;
        int mana = generator.nextInt(20)+30;

        return new Wizard("abc",heal, str, mana);
    }



    @Override // nadpisz
    public Hero duel(Hero other) { // metoda abstrakcyjna hero kazała nam zrobić tą metodę tak jak w przypadku warriorów
        while(true)
        {
           if(this instanceof IMagic){ //duel prawie bez zmian dodajemy jednak odniesienie do interfejsu
               // magic dzieki temu możemy rozróźnić wojowników magicznych od nie magicznych.
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
         // tutaj powołujemy obiekt random który nam losuje dodatkowe obrażenia od -3 do 3 bo liczymy 7 - 3 gdzie - 3 jest najmniejszą wartością.
        int dodatkoweOb = losowo.nextInt(7)-3;
        int dmg;
        if (other instanceof IMagic){
            dmg=0;
        }
        else {
            dmg = this.mana + dodatkoweOb; // dmg to  siła tego bohatera który atakuje i dodatkowy dmg.

        }
        other.health = other.health - dmg; // zdrowie atakowanego to jego zdrowie odjąć dmg atakującego.
        System.out.println(" Bohater "+this.getClass()+" "+ this.name + " Atakuje magicznie za: "+dmg + " punktów : "+other.getClass()+" "+other.name+"- Ten wojownik bedzie miał teraz tyle zdrowia: "+other.health);
    }
}
