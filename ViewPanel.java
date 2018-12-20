 
package explorer;

import java.awt.Color; 
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel; 
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author alhoussene
 */
public class ViewPanel extends JPanel {
   protected JButton left_         = new JButton(new ImageIcon("Pictures/left.PNG"));
   protected JButton right_        = new JButton(new ImageIcon("Pictures/right.PNG"));
   protected JButton seachButton_  = new JButton(new ImageIcon("Pictures/seachIcon.PNG"));
   
   protected JTextField pathField_   = null;
   protected JTextField seachField_  = null;
   
   protected JLabel icon_ = null;
   
   protected PathPanel pathPanel_ = null;
   
    public ViewPanel() {
        pathField_  = new JTextField(60);
        seachField_ = new JTextField(20);
        JTextField[] fields = {pathField_,seachField_};
        for(JTextField tf : fields){
            tf.setFont(new Font("Arial",Font.BOLD,11));
            
        }
       
        icon_       = new JLabel(new ImageIcon("Pictures/icoFol.PNG"));
        
        //ajout des composants de p1
        JPanel p1 = new JPanel();
        p1.add(left_); p1.add(right_);
        
       //ajout des composants de pathPanel 
        pathPanel_ = new PathPanel();
        pathPanel_.add(icon_);
        pathPanel_.add(pathField_);
        
        //ajout des composants de p3
        JPanel p3 = new JPanel();
        p3.add(seachField_);
        p3.add(seachButton_); 
        
        //ajout des panneaux p1 , pathPanel et p3
        add(p1);
        add(pathPanel_);
        add(p3); 
        
        JButton[] buttons = {left_ , right_ , seachButton_};
        for(JButton b : buttons){
            b.setBackground(new Color(237 , 237 , 237));
            b.setBorderPainted(false);
            b.setOpaque(false);
        }
        
    }
    
}
