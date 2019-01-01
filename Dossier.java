 
package explorer;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

/**
 *
 * @author alhoussene
 */
public class Dossier  extends JToggleButton{
    private File file = null;
    private String texte = null;
    public Dossier(File file) {
        this.file = file;
        setIcon(new ImageIcon("folderOpened.png"));
        texte = file.getName();        
        setVerticalAlignment(BOTTOM);
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(BOTTOM); 
    }
    
    public File getFile(){ return file;}
    @Override
    public String toString(){ return texte;}
    
}
