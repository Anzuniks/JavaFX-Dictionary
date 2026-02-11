package KuuspisteKakkonen;

public class Laskuri {
    private final double KURSSI = 1.19;

    public double euroistaDollareiksi(double eurot) {
        return eurot / KURSSI;
    }

    public double dollareistaEuroiksi(double dollarit) {
        return dollarit * KURSSI;
    }
}
