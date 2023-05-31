import java.util.Random;
// Stworzyliśmy abstrakcyjną klase Hero (Abstrakcyjna to taka klasa co narzuca innym podklasom żeby miały konkretne elementy takie jak ona,
// nie możemy stworzyć obiektu klasy abstrakcyjnej)
public abstract class Hero {
    protected static String[] names = {"Mateusz", "Adrian","Sebastian"};
    protected String name;
    protected int health;
    protected int strength;
 // Nasza klasa Hero składa się z pól zmiennych(atrybutów) i tablicy z listą imion.
    public Hero (String name, int health,int strength) {
        // Konstruktor Hero to metoda która tworzy obiekt danej klasy. Tutaj odwołujemy się do pól klasy Hero.
        // Tworzymy tu niejako szablon bohatera.
                Random generator = new Random();
        int dł = generator.nextInt(names.length);
        this.name=names[dł];
        // Tutaj została przywołałna metoda random, która losowo wybiera nam imie z tablicy imion ograniczając ilośc imion do długości tablicy.
    this.health=health;
    this.strength=strength;};

    // Teraz tworzymy metode czy żywy. Jeśli życie tego bohatera jest wieksze niż 0 to żyje a jak nie to jest martwy.
    // Używamy Boolean dla tego aby mieć watość True albo false.
    public boolean isAlive() {
        if
        (this.health > 0){
            return true;}
        else {
            return false;}
    }

    public void attack(Hero other) {
        // Jest to metoda która odpowiada za walkę herosów
    Random losowo = new Random();
    int dodatkoweOb = losowo.nextInt(7)-3; // tutaj powołujemy obiekt random który nam losuje dodatkowe obrażenia od -3 do 3 bo liczymy 7 - 3 gdzie - 3 jest najmniejszą wartością.
    int dmg;
    dmg = this.strength+ dodatkoweOb; // dmg to  siła tego bohatera który atakuje i dodatkowy dmg.
    other.health = other.health - dmg; // zdrowie atakowanego to jego zdrowie odjąć dmg atakującego.
    System.out.println(" Bohater "+this.getClass()+" "+ this.name + " Atakuje z siłą: "+dmg + " : " +other.name+" "+ other.getClass()+" ma teraz hp: "+other.health);
}
    public abstract Hero duel(Hero other); // To jest metoda która narzuca podklasom Hero te metode.
}
