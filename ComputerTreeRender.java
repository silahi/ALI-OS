 
package explorer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author alhoussene
 */
public class ComputerTreeRender extends DefaultTreeCellRenderer {

    public ComputerTreeRender() {
        setClosedIcon(new ImageIcon("folderClosed.png"));
        setOpenIcon(new ImageIcon("folderOpened.png"));
        setBorder(BorderFactory.createEmptyBorder(1,0,1, 0));
        setBackgroundNonSelectionColor(new Color(237,237,237));        
        setFont(new Font("Verdana",Font.BOLD,11));
    }

    @Override
    public Component getTreeCellRendererComponent(JTree arbre, Object o, boolean selection, boolean ouvert, boolean feuille, int ligne, boolean focus) {
        super.getTreeCellRendererComponent(arbre, o, selection, ouvert, feuille, ligne, focus);
        DefaultMutableTreeNode noeud = (DefaultMutableTreeNode)o;
        arbre.setBackground(new Color(237,237,237));
        if(!feuille){
           // Dossier folder = (Dossier)noeud.getUserObject();
           // setIcon(folder.getIcon());
        }
        return this;
    }
    
    
    
}
