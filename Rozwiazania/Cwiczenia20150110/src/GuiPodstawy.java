import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;


public class GuiPodstawy extends JFrame {
    
    private static final Dimension MIN_ROZMIAR_OKNA = new Dimension(300, 200);
    private static final Dimension ROZMIAR_OKNA = new Dimension(600, 400);

    public GuiPodstawy() {
        super("Moje pierwsze okno");
        setSize(ROZMIAR_OKNA);
        setMinimumSize(MIN_ROZMIAR_OKNA);
        setLocationRelativeTo(null);
        
        
        JButton button = new JButton("Nacisnij mnie");
        
        Container ekran = getContentPane();
        ekran.setLayout(null);
        
        button.setBounds(50, 50, 200, 40);
        ekran.add(button);
    }

    public static void main(String[] args) {
        GuiPodstawy okno = new GuiPodstawy();
        
        okno.setVisible(true);
    }
}
