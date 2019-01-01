 
package explorer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

/**
 *
 * @author alhoussene
 */
    public  class Disque extends JToggleButton{
          protected Image image = new ImageIcon("Pictures/disk.PNG").getImage();
          protected String name ;
          protected double gmax , glib; 
          
          public Disque(String name , double gmax , double glib){   
               this.name = name;
               this.gmax = gmax;
               this.glib = glib;
              setPreferredSize(new Dimension(320,65));
              setBorderPainted(true);
          }

        @Override
        protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs);  
            Graphics2D g2d = (Graphics2D)grphcs;
            g2d.draw(new Rectangle2D.Double(100,25, 200 , 12));
            g2d.setColor(Color.BLUE);
            g2d.fill(new Rectangle2D.Double(100,25,(gmax/glib)*50 , 12));
            g2d.setFont(new Font("Verdana",Font.BOLD,12));
            g2d.setColor(Color.BLACK);
            g2d.drawString(name, 100, 17);
            g2d.drawString(glib+"G Libres sur "+gmax+"G", 100, 55);
            g2d.drawImage(image,5,20, this);
        }         
          
          
      }
