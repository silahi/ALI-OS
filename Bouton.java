 
package explorer;

 
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author alhoussene
 */
public class Bouton extends JButton {
    public Bouton(String titre , ImageIcon icon){
        super(titre,icon); 
        setOpaque(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setVerticalAlignment(BOTTOM);
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(BOTTOM);  
        setFont(new Font("Arial",Font.BOLD,11));
    }
}
