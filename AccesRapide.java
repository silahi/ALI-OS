 
package explorer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *Date de création : 16/11/18
 * @author alhoussene
 */
public class AccesRapide extends JTree {  
    private Color color = null;
    public AccesRapide(DefaultMutableTreeNode racine) { 
          super(racine);
          color = new Color(237,237,237);
          setBackground(new Color(237,237,237));
          setCellRenderer(new Rendu());
          setFont(new Font("Arial",Font.PLAIN,13));
    }
     private class Rendu extends DefaultTreeCellRenderer{
        public Rendu(){
            this.setBackground(color);
            this.setBackgroundSelectionColor(color);
            this.setBackgroundNonSelectionColor(color);
            this.setOpenIcon(new ImageIcon("Pictures/rapide.PNG"));
            this.setClosedIcon(new ImageIcon("Pictures/rapide.PNG"));
            this.setLeafIcon(new ImageIcon("Pictures/doc.PNG"));
        }
    }
}
