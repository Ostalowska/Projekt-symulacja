import java.util.Random;
public class Warrior extends Hero {
// tutaj mamy klase warrior który dziedziczy po Hero jego metody i atrybuty.

    public Warrior(String name, int health, int strength) {
        super(name, health, strength); //super to odwołanie konstruktora klasy po której dziedziczymy (do Hero)
    }

    static Warrior generateRandomWarrior(){
        Random generator = new Random();
    // losujemy randomowe życie i siłe bohatera atakującego
        int heal = generator.nextInt(51)+50; // to losuje nam przedział życia od 50 do 100
        int str = generator.nextInt(21)+20;  // tu losuje nam przedział siły od 20 do 40

        return new Warrior("abc",heal, str); // tu nam zwraca nowego wojownika bo odwołaliśmy się do warrior który odwołał się do hiro.
    }

    @Override // nadpisz
    public Hero duel(Hero other) { // metoda abstrakcyjna hero wymusza na nas te metodę
 // sama ta metoda ma odpisać sposób walki jaka bedzie się toczyć miedzy warriorami.
        while(true)
        { // tutaj mamy pętle nieskończoną która przerywa się gdy któryś z boheterów umrze
            this.attack(other); //jeden atakuje drugiego
            if(!other.isAlive()) break;
            other.attack(this);
            if(!this.isAlive()) break;
        }
        if(this.isAlive()&& !other.isAlive()){ // jeśli pierwszy jest żywy a drugi martwy wyświetla zwycieżce i zwraca jego imie.
            System.out.println("Starcie wojowników wygrywa: " + this.name);
            return this;
        }
        if(other.isAlive()&& !this.isAlive()){
            System.out.println("Starcie wojowników wygrywa: " + other.name);
            return other;
        }

        return null; // pusty zwrot dla tego że metoda musi coś zwracać.

    }
}
