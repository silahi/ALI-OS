 
package explorer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout; 
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *page d'accueil de l'explorateur de fichier
 * @author alhoussene
 */
public class ExplorerHome extends JPanel {
      protected JProgressBar diskC = null;
      protected JProgressBar diskD  = null;
    public ExplorerHome() {
        JPanel p1 = new JPanel();
            diskC = new JProgressBar(0 , 20);
            diskC.setValue(8);
            p1.add(diskC);
       JPanel p2 = new JPanel();
            diskD = new JProgressBar(0,10);
            diskD.setValue(3);   
            p2.add(diskD); 
       JPanel panel   = new JPanel();             
            panel.add(p1); panel.add(p2);              
            add(panel);
            
            JProgressBar[] barre = {diskC , diskD};
            for(JProgressBar jpb : barre){
                jpb.setPreferredSize(new Dimension(300,18));  
                jpb.setBackground(Color.blue);                
            }
    }  
    
}
