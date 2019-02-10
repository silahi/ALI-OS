 
package explorer;

import java.awt.CardLayout;
import java.awt.Color;  
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.LEFT;
import java.awt.Font; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton; 
import javax.swing.JComboBox;
import javax.swing.JLabel; 
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author alhoussene
 */
public class ViewPanel extends JPanel implements FocusListener,ActionListener {
   protected JButton left_         = new JButton(new ImageIcon("Pictures/left.PNG"));
   protected JButton right_        = new JButton(new ImageIcon("Pictures/right.PNG"));
   protected JButton seachButton_  = new JButton(new ImageIcon("Pictures/seachIcon.PNG"));
   
   protected JTextField pathField_   = null;
   protected JTextField seachField_  = null;
   protected JLabel imageLab;
   
   protected JLabel icon_ = null;
   private String image = null;
   protected PathPanel pathPanel_ = null;
   protected JComboBox combo = null;
    public ViewPanel() {
        FlowLayout flow = new FlowLayout();
        flow.setAlignment(LEFT);
        setBackground(new Color(237,237,237)); 
        setLayout(flow);        
        pathField_  = new JTextField(75);         
        seachField_ = new JTextField(); 
        JTextField[] fields = {pathField_,seachField_};
        for(JTextField tf : fields){
           tf.setFont(new Font("Arial",Font.BOLD,11));
            tf.setBackground(new Color(237,237,237)); 
            tf.addFocusListener(this);
        }
       
        image = "Pictures/cePC.PNG";
        imageLab = new JLabel(new ImageIcon(image));
        icon_   = new JLabel(new ImageIcon("folderClosed.png"));
        
        //ajout des composants de p1
        JPanel p1 = new JPanel();
        p1.setOpaque(false);
        p1.add(left_); p1.add(right_);
       
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
       }catch(Exception ex){ System.out.println(ex.getMessage());} 
        
      
       //ajout des composants de pathPanel 
        pathPanel_ = new PathPanel(); 
        
        FlowLayout f1 = new FlowLayout();
        f1.setVgap(0);
        f1.setHgap(0);
        f1.setAlignment(FlowLayout.LEFT);
        pathPanel_.setLayout(f1);
        
        pathPanel_.setPreferredSize(new Dimension(1000 , 20));
        pathPanel_.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); 
        Object[] objets = {"Bureau" , "Ordinateur" , "Panneau de configuration" , "Utilisateur"};
        combo = new JComboBox(objets);
        combo.setSelectedIndex(1);
        combo.setBorder(BorderFactory.createEmptyBorder());
        
        combo.setEditable(false);
        combo.setPreferredSize(new Dimension(combo.getPreferredSize().width -10 , 18)); 
        combo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        combo.setDoubleBuffered(true);
        
        
         pathPanel_.add(imageLab);
         pathPanel_.add(combo);
         
        //ajout des composants de p3
        
        JPanel p3 = new JPanel();
        p3.setLayout(f1);
        p3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        p3.setPreferredSize(new Dimension(200 , 20));
        seachField_.setPreferredSize(new Dimension(180 , 18));
        seachField_.setBorder(BorderFactory.createLineBorder(new Color(237 , 237 , 237)));
        seachField_.setText("Recherche dans ...");
        seachField_.addFocusListener(this);
        
        p3.add(seachField_); p3.add(new JLabel(new ImageIcon("seach.PNG")));
        
        //ajout des panneaux p1 , pathPanel et p3
        add(p1);
        add(pathPanel_);
        add(p3); 
        
        
        JButton[] buttons = {left_ , right_ , seachButton_};
        for(JButton b : buttons){
            b.setBackground(new Color(237 , 237 , 237));
            b.setBorderPainted(false);
            b.setFont(new Font("Arial",Font.BOLD,11));            
            b.setOpaque(false); 
            b.setUI(new javax.swing.plaf.metal.MetalButtonUI());
        }
         
           
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
    
    
    
    public void evenement(CardLayout carte ,JPanel panel ){
        left_.addActionListener((ActionEvent)->{
            carte.previous(panel);
        });
         right_.addActionListener((ActionEvent)->{
            carte.next(panel);
        });
    }

    @Override
    public void focusGained(FocusEvent fe) {
        
        if(fe.getSource() == seachField_){
            seachField_.setText("");
        }
            
     }

    @Override
    public void focusLost(FocusEvent fe) {
         if(fe.getSource() == seachField_){
            seachField_.setText("Recherche dans ...");
        }
          
     }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
     }
    
}
