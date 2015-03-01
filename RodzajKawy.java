/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uksw.wmp.prja.laboratorium2;

/**
 *
 * @author Kot
 */
public enum RodzajKawy {

    KAWA_Z_MLEKIEM(0.5), KAWA_CZARNA(0.0), KAWA_Z_MLEKIEM_I_CUKREM(0.3), KAWA_CZARNA_Z_CUKREM(0.0);

    RodzajKawy(double wartosc) {
        this.wartosc = wartosc;
    }

    public double getWartosc() {
        return wartosc;
    }
    private double wartosc;
}
