package Simple_RMI;

import java.rmi.Naming;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
             /*Cette déclaration définit la locale par défaut pour utiliser le format américain,
             où le point (.) est utilisé comme séparateur décimal.*/
            Locale.setDefault(Locale.US);
            // Récupération de l'objet RMI
            CalculatriceInterface calculatrice = (CalculatriceInterface) Naming.lookup("rmi://localhost/Calculatrice");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Choisissez une opération :");
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Quitter");

                int choix = 0;
                try {
                    choix = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez saisir un nombre valide.");
                    scanner.nextLine(); // Clear buffer
                    continue;
                }

                if (choix == 5) {
                    break;
                }
                if(choix<0 || choix>5){
                    System.out.println("Choix invalide !");
                    continue;
                }
                System.out.println("Entrez les opérandes : ");
                double a = 0;
                double b = 0;
                try {
                    a = scanner.nextDouble();
                    b = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez saisir des nombres valides.");
                    scanner.nextLine(); // Clear buffer
                    continue;
                }

                double resultat = 0;

                switch (choix) {
                    case 1:
                        resultat = calculatrice.addition(a, b);
                        break;
                    case 2:
                        resultat = calculatrice.soustraction(a, b);
                        break;
                    case 3:
                        resultat = calculatrice.multiplication(a, b);
                        break;
                    case 4:
                        try {
                            resultat = calculatrice.division(a, b);
                        } catch (Exception e) {
                            System.out.println("Erreur: Division  par 0");
                            continue;
                        }
                        break;
                }

                System.out.println("Résultat : " + resultat);
            }

            System.out.println("Fin du programme.");
            scanner.close();
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
