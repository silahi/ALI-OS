 
package explorer;

import java.awt.BorderLayout; 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane; 

/**
 *@see Explorer
 * panel de configuration de l'explorateur de fichier
 * @author alhoussene
 */
public class ExplorerConfigPanel extends JPanel {
    /*
     le panneau suivant va etre le conteneur principal de ce panneau
    */
   protected JPanel rootPanel = null;
   
   protected JButton createFolder = null;
   protected JButton createFile   = null;
   protected JButton copy         = null;
   protected JButton paste        = null;
   protected JButton delete       = null;
   protected JButton cut          = null; 
    public ExplorerConfigPanel() {
        setLayout(new BorderLayout());
        rootPanel = new JPanel();
        add(new JScrollPane(rootPanel));  
        
        createFolder = new Bouton("<html>Nouveau<br>dossier</html>" ,new ImageIcon("Pictures/doc.PNG"));
        createFile   = new Bouton("<html>Nouveau<br>fichier</html>" ,new ImageIcon("Pictures/iconFile.PNG"));
        copy         = new Bouton("Copier" ,new ImageIcon("Pictures/iconCopy.PNG"));
        paste        = new Bouton("Coller" , new ImageIcon("Pictures/iconPaste.PNG"));
        delete       = new Bouton("Supprimer",new ImageIcon("Pictures/iconDelete.PNG"));
        cut          = new Bouton("Couper" , new ImageIcon("Pictures/iconCut.PNG"));
        
        
        // Action de supprimer 
        
        JPanel p1 = new JPanel();
        p1.add(copy); p1.add(paste); p1.add(cut);p1.add(delete);
        rootPanel.add(p1);
        
        JPanel p2 = new JPanel();
        p2.add(createFolder); p2.add(createFile);
        rootPanel.add(p2);
    }
    
     
}
