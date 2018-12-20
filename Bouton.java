 
package explorer;

import java.awt.Color;
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
        setFont(new Font("Arial",Font.BOLD , 11));
        setBackground(new Color(237,237,237));
        setOpaque(false);
        setBorderPainted(false);
        setVerticalAlignment(BOTTOM);
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(BOTTOM);        
    }
}
