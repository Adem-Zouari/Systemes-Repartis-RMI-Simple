package Simple_RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] args) {
        try {
            // Création du registre RMI
            LocateRegistry.createRegistry(1099);

            // Création de l'objet RMI
            CalculatriceImpl calculatrice = new CalculatriceImpl();

            // Enregistrement de l'objet RMI
            Naming.rebind("rmi://localhost/Calculatrice", calculatrice);

            System.out.println("Serveur prêt !");
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
