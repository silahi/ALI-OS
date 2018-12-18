 
package explorer;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 *ce panneau va cpntenir les panneaux gauches et le root panel
 * @author alhoussene
 */
public class DividerPanel extends JSplitPane {
    public DividerPanel(JPanel leftPanel , JComponent component){
        super(JSplitPane.HORIZONTAL_SPLIT , new JScrollPane(leftPanel) , new JScrollPane(component));
        setContinuousLayout(true);
    }
}
