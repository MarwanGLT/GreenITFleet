/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.it.fleet;
import java.time.LocalDateTime;
import java.util.Set;

/**
 *
 * @author MCHAUMES
 */
public class GreenITFleet {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
    Station maStation = new Station("Centre-Ville");
    Velo v1 = new Velo("E-Ride 2000");
    Velo v2 = new Velo("Volt-Bike");
    maStation.ajouterVelo(v1);
    maStation.ajouterVelo(v2);
    maStation.afficherEtatStation();
    
    LocalDateTime debut = LocalDateTime.of(2026, 5, 15, 14, 0);
    LocalDateTime fin = LocalDateTime.of(2026, 5, 15, 16, 30);
    
    v1.demarrerLocation(debut);
    v1.setNiveauBatterie(45);
    v1.terminerLocation(fin);
    
    maStation.afficherEtatStation();
    v1.afficherHistorique();
}
}
    

