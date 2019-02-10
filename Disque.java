 
package explorer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;


/**
 *
 * @author alhoussene
 */
    public  class Disque extends JToggleButton{
          protected Image image = new ImageIcon("Pictures/partition.png").getImage();
          protected String name ;
          protected double gmax , glib; 
         
          
          public Disque(String name , double gmax , double glib){   
               this.name = name;
               this.gmax = gmax;
               this.glib = glib;
              setPreferredSize(new Dimension(300,65));
              setBorderPainted(true);
              setUI(new javax.swing.plaf.metal.MetalButtonUI());
              changeLook(this);
          }
          
           private void changeLook(JToggleButton jtb){
        jtb.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){jtb.setUI(new com.sun.java.swing.plaf.windows.WindowsButtonUI());}
            @Override
            public void mouseExited(MouseEvent me){
               jtb.setUI(new javax.swing.plaf.metal.MetalButtonUI());
            }
        });
    }

        @Override
        protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs);  
            Graphics2D g2d = (Graphics2D)grphcs;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.draw(new Rectangle2D.Double(80,25, 200 , 12));
            g2d.setColor(Color.BLUE);
            g2d.fill(new Rectangle2D.Double(80,25,(gmax/glib)*50 , 12));
            g2d.setFont(new Font("Arial",Font.BOLD , 12));
            g2d.setColor(Color.BLACK);
            g2d.drawString(name, 80, 17);
            
            grphcs.drawString(glib+"G Libres sur "+gmax+"G", 80, 55);
            g2d.drawImage(image,10,10, this);
        }         
          
          
      }
