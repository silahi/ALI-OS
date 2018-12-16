 
package explorer;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;

/**Fichier : Explorator.java
 *Date de création : 16/11/18
 * Modifications : 
 * Mescriptions : classe principale contenant l'ensemble des fichiers du systeme
 * @author alhoussene
 */
public class Explorator extends JFrame {
    
    /** Ce panneau (panel gauche de l'explorateur de fichier) va contienir :
        * L'arbre d'acces rapide
        * @see AccesRapide
        * L'arbre de l'ordinateur
        * @see Ordinateur
    */
    protected JPanel leftPanel_ = null;
    private GridLayout  leftPanLay_     =null;
    /** Ce panneau (panel haut de l'explorteur de fichier) va contienir :
     *  les boutons( Supprimer , copier , coller , deplacer ... )
     */
    protected JPanel upPanel_ = null;
    
    /**
     * ceci est le panneau principale de l'explorateur de fichier
     * permettant d'ouvrir un dissier et ansi de suite
     */    
    protected RootExplorator rootExplorator_ = null;   
    /*
      Création d'un instance de l'arbre de L'ordinateur qui sera
      ajouté dans le panneau gauche
    */
    protected Ordinateur ordinateur_ = null;
    
     /*
      Création d'un instance de l'arbre de L'acces rapide qui sera
      ajouté dans le panneau gauche
    */
    protected AccesRapide accesRapide_ = null;
    
    //Racine de l'arbre de l'acces rapide
    protected Racine nodeAccRap_ = null;
    
    //racine de l'arbre de l'ordinateur
    protected Racine nodeOrdi_ = null;
    
    public Explorator(){
        setSize(1200 , 600);
        setLocationRelativeTo(null);
        
        
        leftPanel_ = new JPanel();
        leftPanLay_ = new GridLayout(2,1);
        leftPanel_.setLayout(leftPanLay_);
        upPanel_   = new JPanel();
        rootExplorator_ = new RootExplorator();
        
        //ajout des panneaux dans la fenetre principale de l'explorateur de fichier
        add(new JScrollPane(leftPanel_) ,"West");
        add(new JScrollPane(upPanel_),"North");
        add(new JScrollPane(rootExplorator_) , "Center");
        
        //création des noeuds 
        nodeAccRap_ = new Racine("Acces Rapide");
        nodeOrdi_  = new Racine("Ordinateur");
        
        //création des arbres
        accesRapide_ = new AccesRapide(nodeAccRap_);        
        ordinateur_  = new Ordinateur(nodeOrdi_);
        
        //ajout des arbres dans le panneau gauche
        leftPanel_.add(accesRapide_);
        leftPanel_.add(ordinateur_); 
        
        //exemples
        nodeOrdi_.add(new DefaultMutableTreeNode("Downloads"));
        nodeOrdi_.add(new DefaultMutableTreeNode("Movies"));
        nodeOrdi_.add(new DefaultMutableTreeNode("Pictures"));
        nodeOrdi_.add(new DefaultMutableTreeNode("Documents"));
        
        nodeAccRap_.add(new DefaultMutableTreeNode("Documents"));
        nodeAccRap_.add(new DefaultMutableTreeNode("Films"));
        nodeAccRap_.add(new DefaultMutableTreeNode("Downloads"));
        nodeAccRap_.add(new DefaultMutableTreeNode("Images"));
                
        
        setVisible(true);
    }
}
