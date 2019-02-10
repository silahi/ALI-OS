 
package explorer;

 
import java.awt.Color; 
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel; 
import javax.swing.border.TitledBorder;

/**
 *page d'accueil de l'explorateur de fichier
 * @author alhoussene
 */
public class ExplorerHome extends JPanel { 
    protected Disque disqueC = null , disqueD = null , dvd;
    private JPanel per = null;
    public ExplorerHome() { 
        
        per = new JPanel(); 
        Font font = new Font("Arial",Font.PLAIN , 16);
        Color color = new Color(0 , 0 ,255);
         
         FlowLayout f1 = new FlowLayout();
         f1.setAlignment(FlowLayout.LEFT);
         per.setLayout(f1);
        per.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY) ,
                " Périphériques et lecteurs(2)",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                 font));
                       
        setLayout(new GridLayout(3 , 1));
        
        JPanel dos = new JPanel();
        dos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY) ,
                " Dossiers(0)",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                 font ));
        add(dos);
          disqueC = new Disque("ALIOS (C:)" , 100,80);          
          disqueD = new Disque("ALIOS (D:)" , 30,20);
          dvd     = new Disque("Lecteur DVD RW (E:)" ,0,0);
          dvd.image = new ImageIcon("Pictures/cd.png").getImage();
          
          per.add(disqueC);  per.add(disqueD); per.add(dvd);
          add(per);
      }
 }   