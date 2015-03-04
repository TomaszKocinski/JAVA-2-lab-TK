package pl.edu.uksw.wmp.prja.laboratorium2;

 // @author Kot

public class Automat {

    private int iloscKubkow;
    private double iloscMleka;
    public int[] iloscMonet;

    public Automat() {
        iloscKubkow = 10;
        iloscMleka = 100;
        iloscMonet = new int[]{5, 5, 5, 5, 5, 5};
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
        iloscMonet = new int[]{5, 5, 5, 5, 5, 5};
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

    public RodzajKawy podajKawe(RodzajKawy arg) {
        double temp = arg.getWartosc();
        if (temp > iloscMleka || iloscKubkow == 0) {
            return null;
        }
        iloscKubkow--;
        iloscMleka = iloscMleka - temp;
        return arg;
    }

    public Moneta[] podajKawe(RodzajKawy arg, Moneta[] arg_mon) {
        podajKawe(arg);
        Moneta[] monetyReszta;
        int[] iloscMonetyReszta = new int[]{0, 0, 0, 0, 0, 0};
        double price = 1.60,
                temp = arg.getWartosc();
        if (temp > 0) {
            price = 1.80;
        }
        temp = arg_mon[0].getWartosc() - price;

        int price_int = (int) Math.round(price * 100);
        while (price_int >= 500) {
            price_int -= 500;
            iloscMonet[5]++;
        }
        while (price_int >= 200) {
            price_int -= 200;
            iloscMonet[4]++;
        }
        while (price_int >= 100) {
            price_int -= 100;
            iloscMonet[3]++;
        }
        while (price_int >= 50) {
            price_int -= 50;
            iloscMonet[2]++;
        }
        while (price_int >= 10) {
            price_int -= 10;
            iloscMonet[1]++;
        }
        while (price_int >= 5) {
            price_int -= 5;
            iloscMonet[0]++;
        }

        int temp_int = (int) Math.round(temp * 100);

        while (temp_int >= 500) {
            temp_int -= 500;
            iloscMonetyReszta[5]++;
        }
        while (temp_int >= 200) {
            temp_int -= 200;
            iloscMonetyReszta[4]++;
        }
        while (temp_int >= 100) {
            temp_int -= 100;
            iloscMonetyReszta[3]++;
        }
        while (temp_int >= 50) {
            temp_int -= 50;
            iloscMonetyReszta[2]++;
        }
        while (temp_int >= 10) {
            temp_int -= 10;
            iloscMonetyReszta[1]++;
        }
        while (temp_int >= 5) {
            temp_int -= 5;
            iloscMonetyReszta[0]++;
        }
        temp_int = 0;
        for (int i = 0; i < iloscMonetyReszta.length; i++) {
            temp_int += iloscMonetyReszta[i];
        }
        monetyReszta = new Moneta[temp_int];
        for (int i = 0, j = 0; i < iloscMonetyReszta.length; i++) {
            switch (i) {
                case 0:
                    while (iloscMonetyReszta[i] != 0) {
                        monetyReszta[j++] = Moneta.GR5;
                        iloscMonetyReszta[i]--;
                    }
                case 1:
                    while (iloscMonetyReszta[i] != 0) {
                        monetyReszta[j++] = Moneta.GR10;
                        iloscMonetyReszta[i]--;
                    }
                case 2:
                    while (iloscMonetyReszta[i] != 0) {
                        monetyReszta[j++] = Moneta.GR50;
                        iloscMonetyReszta[i]--;
                    }
                case 3:
                    while (iloscMonetyReszta[i] != 0) {
                        monetyReszta[j++] = Moneta.ZL1;
                        iloscMonetyReszta[i]--;
                    }
                case 4:
                    while (iloscMonetyReszta[i] != 0) {
                        monetyReszta[j++] = Moneta.ZL2;
                        iloscMonetyReszta[i]--;
                    }
                case 5:
                    while (iloscMonetyReszta[i] != 0) {
                        monetyReszta[j++] = Moneta.ZL5;
                        iloscMonetyReszta[i]--;
                    }
            }
        }
        for (int i = 0; i < iloscMonetyReszta.length; i++) {
            if (iloscMonet[i] > 49) {
                oproznij(iloscMonet);
            }
        }
        return monetyReszta;
    }

    public void oproznij(int[] arg_mon) {
        for (int i : iloscMonet) {
            iloscMonet[i] = 5;
        }
    }

}
