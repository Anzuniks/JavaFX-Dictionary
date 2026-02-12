package KuuspisteKakkonen;

public class Valuutta {
    private String nimi;
    private double kurssi;

    public Valuutta(String nimi, double kurssi) {
        this.nimi = nimi;
        this.kurssi = kurssi;
    }


    public String getNimi() {
        return nimi;
    }
    public double getKurssi() {
        return kurssi;
    }

    @Override
    public String toString() {
        return nimi;
    }
}
