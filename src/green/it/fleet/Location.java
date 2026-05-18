/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marwan
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package green.it.fleet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MCHAUMES
 */
public class Location {
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private int batterieConsommee;

    public Location(LocalDateTime dateDebut, LocalDateTime dateFin, int batterieConsommee) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.batterieConsommee = batterieConsommee;
    }

    public LocalDateTime getDateDebut() { return dateDebut; }
    public LocalDateTime getDateFin() { return dateFin; }
    public int getBatterieConsommee() { return batterieConsommee; }

    public void afficherInfos() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("  - Du " + dateDebut.format(formatter)
                + " au " + dateFin.format(formatter)
                + " | Batterie consommée: " + batterieConsommee + "%");
    }
}
