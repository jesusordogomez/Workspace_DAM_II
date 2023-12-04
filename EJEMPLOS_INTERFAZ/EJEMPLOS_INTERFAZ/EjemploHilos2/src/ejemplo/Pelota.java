
package ejemplo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pelota extends JLabel {

    public Pelota() {
        setIcon(new ImageIcon(getClass().getResource("/imagenes/jugador.png")));
        setBounds(50, 400, 50, 50);
    }
}