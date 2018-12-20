 
package explorer;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author alhoussene
 */
public class ArbreModel implements TreeModel {

    @Override
    public Object getRoot() {
        return null;
    }

    @Override
    public Object getChild(Object o, int i) {
        return null;
     }

    @Override
    public int getChildCount(Object o) {
        return 0;
    }

    @Override
    public boolean isLeaf(Object o) {
        return false;
    }

    @Override
    public void valueForPathChanged(TreePath tp, Object o) {
     }

    @Override
    public int getIndexOfChild(Object o, Object o1) {
        return 0;
    }

    @Override
    public void addTreeModelListener(TreeModelListener tl) {
     }

    @Override
    public void removeTreeModelListener(TreeModelListener tl) {
    }
    
}
