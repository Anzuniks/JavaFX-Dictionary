package KuuspisteKakkonen;

import java.util.ArrayList;
import java.util.List;

public class ValuuttaController {

    private List<Valuutta> valuutat = new ArrayList<>();

    public ValuuttaController() {
        valuutat.add(new Valuutta("Euro", 1.0));
        valuutat.add(new Valuutta("Dollari", 1.19));
        valuutat.add(new Valuutta("Punta", 0.85));
        valuutat.add(new Valuutta("Jeni", 130.0));

    }

    public List<Valuutta> getValuutat() {
        return valuutat;
    }

    public double muunna(double maara, Valuutta mista, Valuutta mihin) {
        double eurot = maara / mista.getKurssi();
        return eurot * mihin.getKurssi();
    }
}
