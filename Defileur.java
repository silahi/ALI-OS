 
package explorer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *ce composant va contenenir les arbres du panneau gauche de l'explorateur
 * @author alhoussene
 */
public class Defileur extends JScrollPane {
    public Defileur(JPanel panel) {
        super(panel ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }
    
}
