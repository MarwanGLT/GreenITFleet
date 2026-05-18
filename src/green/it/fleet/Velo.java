/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.it.fleet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MCHAUMES
 */
public class Velo {
    private String modele;
    private int niveauBatterie; 
    private boolean estLoue;
    private int capacite;
    private List<Location> historiqueLocations;
    
    // Champs temporaires pour suivre la location en cours
    private LocalDateTime debutLocationCourante;
    private int batterieDebutLocation;
    
    public Velo(String modele) {
        this.modele = modele;
        this.niveauBatterie = 100; 
        this.estLoue = false;
        this.capacite = 800;
        this.historiqueLocations = new ArrayList<>();
    }
    
    public String getModele() { return modele; }
    
    public int getCapacite() { return capacite; }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    
    public int getKilometrage() {
        return (capacite * niveauBatterie / 100) / 5;
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
    
    public List<Location> getHistoriqueLocations() { return historiqueLocations; }
    
    public void demarrerLocation() {
        if (estLoue) {
            System.out.println("Ce vélo est déjà loué !");
            return;
        }
        this.estLoue = true;
        this.debutLocationCourante = LocalDateTime.now();
        this.batterieDebutLocation = this.niveauBatterie;
        System.out.println("Location du vélo " + modele + " démarrée.");
    }
    
    public void terminerLocation() {
        if (!estLoue) {
            System.out.println("Ce vélo n'est pas en cours de location !");
            return;
        }
        LocalDateTime dateFin = LocalDateTime.now();
        int batterieConsommee = batterieDebutLocation - this.niveauBatterie;
        
        Location location = new Location(debutLocationCourante, dateFin, batterieConsommee);
        historiqueLocations.add(location);
        
        this.estLoue = false;
        this.debutLocationCourante = null;
        System.out.println("Location du vélo " + modele + " terminée.");
    }
    
public void demarrerLocation(LocalDateTime dateDebut) {
    if (estLoue) {
        System.out.println("Ce vélo est déjà loué !");
        return;
    }
    this.estLoue = true;
    this.debutLocationCourante = dateDebut;
    this.batterieDebutLocation = this.niveauBatterie;
    System.out.println("Location du vélo " + modele + " démarrée.");
}

public void terminerLocation(LocalDateTime dateFin) {
    if (!estLoue) {
        System.out.println("Ce vélo n'est pas en cours de location !");
        return;
    }
    int batterieConsommee = batterieDebutLocation - this.niveauBatterie;
    
    Location location = new Location(debutLocationCourante, dateFin, batterieConsommee);
    historiqueLocations.add(location);
    
    this.estLoue = false;
    this.debutLocationCourante = null;
    System.out.println("Location du vélo " + modele + " terminée.");
}

    public void afficherHistorique() {
        System.out.println("Historique des locations du vélo " + modele + " :");
        if (historiqueLocations.isEmpty()) {
            System.out.println("  Aucune location enregistrée.");
        } else {
            for (Location loc : historiqueLocations) {
                loc.afficherInfos();
            }
        }
    }
    
    public void afficherInfos() {
        String statut = estLoue ? "Loué" : "Disponible";
        System.out.println("Velo " + modele + " | Batterie: " + niveauBatterie + "%"
                + " | Capacité: " + getKilometrage() + "km | Statut: " + statut);
    }
}