import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GuiPodstawy extends JFrame {

    private static final Dimension MIN_ROZMIAR_OKNA = new Dimension(350, 200);
    private static final Dimension ROZMIAR_OKNA = new Dimension(600, 400);

    public GuiPodstawy() {
        super("Moje pierwsze okno");
        setSize(ROZMIAR_OKNA);
        setMinimumSize(MIN_ROZMIAR_OKNA);
        setLocationRelativeTo(null);

        final JTextField text = new JTextField();
        text.setBounds(50, 100, 250, 30);

        final JCheckBox check = new JCheckBox("Czy jestem fajny?");
        check.setBounds(50, 150, 250, 30);

        final JButton button = new JButton("Nacisnij mnie");
        button.setBounds(50, 50, 200, 40);

        Container ekran = getContentPane();
        ekran.setLayout(null);

        ekran.add(text);
        ekran.add(button);
        ekran.add(check);

        ActionListener buttonListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String t = text.getText();
                if (check.isSelected()) {
                    text.setText(t + ":-)");
                } else {
                    text.setText(t + ":-(");
                }
            }
        };
        ActionListener buttonListener2 = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String t = text.getText();
                text.setText(t + " | ");

            }
        };
        button.addActionListener(buttonListener2);
        button.addActionListener(buttonListener);
    }

    public static void main(String[] args) {
        GuiPodstawy okno = new GuiPodstawy();

        okno.setVisible(true);
    }
}
