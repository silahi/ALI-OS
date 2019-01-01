 
package explorer;

 
 
import java.awt.Color; 
import javax.swing.BorderFactory;
import javax.swing.JSplitPane;

/**
 *ce panneau va cpntenir les panneaux gauches et le root panel
 * @author alhoussene
 */
public class DividerPanel extends JSplitPane {
    public DividerPanel(){ 
        setContinuousLayout(true); 
        setBackground(new Color(237,237,237));
        setOpaque(false); 
        setDividerSize(1);
        setDividerLocation(280); 
        this.setAutoscrolls(true); 
        
        this.setBorder(BorderFactory.createLineBorder(new Color(237,237,237))); 
    }
}
