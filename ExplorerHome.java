 
package explorer;

 
import java.awt.FlowLayout;
import javax.swing.JPanel; 

/**
 *page d'accueil de l'explorateur de fichier
 * @author alhoussene
 */
public class ExplorerHome extends JPanel { 
    protected Disque disqueC = null , disqueD = null;
    
    public ExplorerHome() { 
        FlowLayout flow = new FlowLayout();
        flow.setHgap(50);
        flow.setVgap(100);
        setLayout(flow);
          disqueC = new Disque("ALIOS (C:)" , 100,80);
          
          disqueD = new Disque("ALIOS (D:)" , 30,20);
          
          add(disqueC);  add(disqueD);
      }
 }   