import java.util.Random;

public class TestHeros {

 //klasa testowa

    public static void main(String[] args) {

        Wizard wiz1 = Wizard.generateRandomWizard();
        Nekromanta nekro1 = Nekromanta.generateRandomNekromanta();
        Warrior war1 = Warrior.generateRandomWarrior();
        System.out.println("Pierwsza walka");
        nekro1.duel(war1);
        System.out.println("Kolejna walka");
        nekro1.duel(nekro1);
        System.out.println("Kolejna walka");
        war1.duel(wiz1);






    }

}