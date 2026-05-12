/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.it.fleet;

/**
 *
 * @author MCHAUMES
 */
public class Velo {
    private String modele;
    private int niveauBatterie; 
    private boolean estLoue;
    private int capacite;

    public Velo(String modele) {
        this.modele = modele;
        this.niveauBatterie = 100; 
        this.estLoue = false;
        this.capacite = 800;
        
    }

    // Getters et Setters de base
    public String getModele() { return modele; }
    
    public int getCapacite() { return capacite; }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
}
    
    public int getKilometrage() {
        return (capacite * niveauBatterie / 100) /5;
    }
    public int getNiveauBatterie() { return niveauBatterie; }
    public void setNiveauBatterie(int niveauBatterie) {
    if (niveauBatterie < 0) { 
        System.out.println("Veuillez saisir un niveau de batterie valide !");
    } else if (niveauBatterie > 100) {
        System.out.println("Veuillez saisir un niveau de batterie compris en 0% et 100% !");
    } else {
        this.niveauBatterie = niveauBatterie; 
    }
    }

    public boolean isEstLoue() { return estLoue; }
    public void setEstLoue(boolean estLoue) { this.estLoue = estLoue; }

    public void afficherInfos() {
        String statut = estLoue ? "Loué" : "Disponible";
        System.out.println("Velo " + modele + " | Batterie: " + niveauBatterie + "%" + " | Capacité: " + getKilometrage() +  "km | Statut: " + statut);
    }
}
