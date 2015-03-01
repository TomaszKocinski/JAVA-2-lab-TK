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
public class Automat {

    private int iloscKubkow;
    private double iloscMleka;

    public Automat() {
        iloscKubkow = 10;
        iloscMleka = 100;
    }

    public Automat(int iloscKubkow, double iloscMleka) {
        if (iloscKubkow < 0) {
            iloscKubkow = 0;
        }
        if (iloscMleka < 0) {
            iloscMleka = 0;
        }
        this.iloscKubkow = iloscKubkow;
        this.iloscMleka = iloscMleka;
    }

    public void dodajKubki(int iloscKubkow) {
        if (this.iloscKubkow + iloscKubkow > 1000) {
            this.iloscKubkow = 1000;
            return;
        }
        this.iloscKubkow = this.iloscKubkow + iloscKubkow;

    }

    public void dodajMleko(double iloscMleka) {
        if (this.iloscMleka + iloscMleka > 200.0) {
            this.iloscMleka = 200.0;
            return;
        }
        this.iloscMleka = this.iloscMleka + iloscMleka;
    }

    
    public RodzajKawy podajKawe(RodzajKawy arg){
        double temp =arg.getWartosc();
        if(temp>iloscMleka || iloscKubkow==0) return null;
        iloscKubkow--;
        iloscMleka=iloscMleka-temp;
        return arg;
    }
    public RodzajKawy podajKawe(RodzajKawy arg, Moneta[] arg_mon){
        double temp =arg.getWartosc();
        if(temp>iloscMleka || iloscKubkow==0) return null;
        iloscKubkow--;
        iloscMleka=iloscMleka-temp;
        return arg;
    }
    public void oproznij(Moneta[] arg_mon){
        
        
    }

}
