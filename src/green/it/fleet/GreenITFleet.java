/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.it.fleet;

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
        
        // Simulation d'une location
        v1.setEstLoue(true);
        v1.setNiveauBatterie(45);
        
        
        maStation.afficherEtatStation();
    }
    }
    

