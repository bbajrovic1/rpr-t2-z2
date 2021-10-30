package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
     private double pocetna_tacka, krajnja_tacka;
     private boolean pocetna_pripada, krajnja_pripada;


    public Interval(double pocetna_tacka, double krajnja_tacka, boolean pocetna_pripada, boolean krajnja_pripada) throws IllegalArgumentException {
        if(pocetna_tacka > krajnja_tacka) {
            throw new IllegalArgumentException("Neispravan interval");
        }
        this.pocetna_tacka = pocetna_tacka;
        this.krajnja_tacka = krajnja_tacka;
        this.pocetna_pripada = pocetna_pripada;
        this.krajnja_pripada = krajnja_pripada;
    }

    public Interval() {
        this.pocetna_tacka = 0;
        this.krajnja_tacka = 0;
        this.pocetna_pripada = false;
        this.krajnja_pripada = false;
    }

    public boolean isNull() {
        if(pocetna_tacka == 0 && krajnja_tacka == 0 && !pocetna_pripada && !krajnja_pripada)
            return true;
        else return false;
    }

    public boolean isIn(double t) {
        if(t >= pocetna_tacka && t < krajnja_tacka)
            return true;
        else return false;
    }

    public boolean pripadaDonja() {
        if(pocetna_pripada) {
            return true;
        }
        else return false;
    }

    public boolean pripadaGornja() {
        if(krajnja_pripada) {
            return true;
        }
        else return false;
    }

    public Interval intersect(Interval i) {
        Interval povratni = new Interval();
        if(this.pocetna_tacka >= i.pocetna_tacka) {
            povratni.pocetna_tacka = this.pocetna_tacka;
            povratni.pocetna_pripada = this.pocetna_pripada;
        }
        else {
            povratni.pocetna_tacka = i.pocetna_tacka;
            povratni.pocetna_pripada = i.pocetna_pripada;
        }

        if(this.krajnja_tacka <= i.krajnja_tacka) {
            povratni.krajnja_tacka = this.krajnja_tacka;
            povratni.krajnja_pripada = this.krajnja_pripada;
        }
        else {
            povratni.krajnja_tacka = i.krajnja_tacka;
            povratni.krajnja_pripada = i.krajnja_pripada;
        }

        return povratni;
    }

    public static Interval intersect(Interval i1, Interval i2) {
        Interval povratni = new Interval();
        if(i1.pocetna_tacka >= i2.pocetna_tacka) {
            povratni.pocetna_tacka = i1.pocetna_tacka;
            povratni.pocetna_pripada = i1.pocetna_pripada;
        }
        else {
            povratni.pocetna_tacka = i2.pocetna_tacka;
            povratni.pocetna_pripada = i2.pocetna_pripada;
        }

        if(i1.krajnja_tacka <= i2.krajnja_tacka) {
            povratni.krajnja_tacka = i1.krajnja_tacka;
            povratni.krajnja_pripada = i1.krajnja_pripada;
        }
        else {
            povratni.krajnja_tacka = i2.krajnja_tacka;
            povratni.krajnja_pripada = i2.krajnja_pripada;
        }

        return povratni;
    }



    @Override
    public String toString() {
        if(this.isNull()) {
            return "()";
        }
        else if(this.pripadaDonja() && this.pripadaGornja()){
            return "[" + this.pocetna_tacka + "," + this.krajnja_tacka + "]";
        }
        else if(!this.pripadaDonja() && this.pripadaGornja()){
            return "(" + this.pocetna_tacka + "," + this.krajnja_tacka + "]";
        }
        else if(this.pripadaDonja() && !this.pripadaGornja()){
            return "[" + this.pocetna_tacka + "," + this.krajnja_tacka + ")";
        }
        else if(!this.pripadaDonja() && !this.pripadaGornja()){
            return "(" + this.pocetna_tacka + "," + this.krajnja_tacka + ")";
        }
        else return "";
    }

    @Override
    public boolean equals(Object o) {
        Interval i = (Interval) o;
        if(this.pocetna_tacka == i.pocetna_tacka && this.krajnja_tacka == i.krajnja_tacka && this.pocetna_pripada == i.pocetna_pripada && this.krajnja_pripada == i.krajnja_pripada) {
            return true;
        }
        else return false;
    }

}
