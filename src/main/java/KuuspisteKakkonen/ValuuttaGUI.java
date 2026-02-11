package KuuspisteKakkonen;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class ValuuttaGUI {
    private Laskuri laskuri = new Laskuri();

    public void luoIkkuna() {
        JFrame f = new JFrame("VALUUTTAKONVERTTERI");

        JLabel l1 = new JLabel("Eurot:");
        l1.setBounds(20, 40, 60, 30);
        JLabel l2 = new JLabel("Dollarit:");
        l2.setBounds(20, 80, 60, 30);

        JTextField t1 = new JTextField("0");
        t1.setBounds(80, 40, 100, 30);
        JTextField t2 = new JTextField("0");
        t2.setBounds(80, 80, 100, 30);

        JButton b1 = new JButton("Euroista dollareiksi");
        b1.setBounds(200, 40, 160, 30);
        JButton b2 = new JButton("Dollareista euroiksi");
        b2.setBounds(200, 80, 160, 30);

        b1.addActionListener(e -> {
            double d = Double.parseDouble(t1.getText());
            double tulos = laskuri.euroistaDollareiksi(d);
            t2.setText(String.valueOf(tulos));

        });

        b2.addActionListener(e -> {
            double d2 = Double.parseDouble(t2.getText());
            double tulos = laskuri.dollareistaEuroiksi(d2);
            t1.setText(String.valueOf(tulos));
        });

        f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(t2);
        f.add(b1);
        f.add(b2);

        f.setLayout(null);
        f.setSize(400, 200);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
