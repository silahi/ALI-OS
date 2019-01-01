 
package explorer;
 
 
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
 

/**
 *ce composant va contenenir les arbres du panneau de division
 * @author alhoussene
 */
public class Defileur extends JScrollPane {
    public Defileur(JPanel panel) {        
        super(panel ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
        JViewport vp = getViewport();
        vp.setBackground(new Color(237,237,237)); 
        setBorder(BorderFactory.createLineBorder(new Color(237,237,237)));
    }
    
}
