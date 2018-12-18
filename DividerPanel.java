 
package explorer;

import java.awt.FlowLayout;
import javax.swing.JComponent; 
import javax.swing.JSplitPane;

/**
 *ce panneau va cpntenir les panneaux gauches et le root panel
 * @author alhoussene
 */
public class DividerPanel extends JSplitPane {
    public DividerPanel(JComponent leftPanel , JComponent component){
        super(JSplitPane.HORIZONTAL_SPLIT ,leftPanel,component);
        setContinuousLayout(true);
        setDividerSize(2); 
        setOpaque(false); 
    }
}
