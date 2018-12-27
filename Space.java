 
package explorer;

import javax.swing.GroupLayout; 
import javax.swing.JComponent;
import javax.swing.JPanel;
import os.RootPopup;

/**
 *
 * @author alhoussene
 */
public class Space extends JPanel {
    protected GroupLayout group_ ;
    protected GroupLayout.SequentialGroup seqGp = null;
    protected GroupLayout.ParallelGroup  parGp = null;  
    public Space() {
        group_ = new GroupLayout(this);
        seqGp  = group_.createSequentialGroup();
        parGp  = group_.createParallelGroup();
        setLayout(group_);
        group_.setAutoCreateContainerGaps(true);
        group_.setAutoCreateGaps(true);
        group_.setHorizontalGroup(seqGp);
        group_.setVerticalGroup(parGp);
        setComponentPopupMenu(new RootPopup(this));
    }
    public void ajout(JComponent cmp){
        seqGp.addComponent(cmp);
        parGp.addComponent(cmp);        
    }    
}
