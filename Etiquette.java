 
package explorer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author alhoussene
 */
public class Etiquette extends JLabel {

    public Etiquette( String titre , String icone ) {
        super(titre , new ImageIcon(icone) , CENTER);
    }
    
}
