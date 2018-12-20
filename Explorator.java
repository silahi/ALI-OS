 
package explorer;

import fileExplorer.ExplorerConfigPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout; 
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;  
import os.Folder;
import os.RootPopup;

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
    protected JPanel treeContainerPanel_ = null;
    protected GroupLayout group_ = null;
    /** Ce panneau (panel haut de l'explorteur de fichier) va contienir :
     *  les boutons( Supprimer , copier , coller , deplacer ... )
     */
    protected JPanel upPanel_ = null;
    
    /**
     * ceci est le panneau principale de l'explorateur de fichier
     * permettant d'ouvrir un dissier et ansi de suite
     */    
    
    protected JPanel rootPanel_ = null;
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
    
    // création d'un panneau de division
    protected DividerPanel dividerPanel_ = null;
    
    //Panneau intermediaire 
    private JPanel interPanel_ = null;    
    protected ViewPanel viewPanel_ = null; 
    
    //panel du nord
    protected ExplorerConfigPanel expConfPan_ = null;
    public Explorator(){
        setSize(1200 , 700);
        setLocation(20,15);
        setIconImage(new ImageIcon("Pictures/Computer.PNG").getImage());
        setExtendedState(MAXIMIZED_BOTH); 
        
        //creation et ajout du pannrau intermediaire
         interPanel_ = new JPanel();
         interPanel_.setLayout(new BorderLayout());
         add(interPanel_ , "Center");  
         
         expConfPan_ = new ExplorerConfigPanel();
         add(expConfPan_,"North");
         
         treeContainerPanel_ = new JPanel();
         group_ = new GroupLayout(treeContainerPanel_);
         group_.setAutoCreateContainerGaps(true);
         group_.setAutoCreateGaps(true);
         treeContainerPanel_.setLayout(group_);
         // création des propriétés du groupe
         
         GroupLayout.SequentialGroup verGroup  = group_.createSequentialGroup();
         GroupLayout.ParallelGroup horGroup    = group_.createParallelGroup();
         
         group_.setVerticalGroup(verGroup);
         group_.setHorizontalGroup(horGroup);
         
         //Instantiation des arbres
         nodeAccRap_ = new Racine("Acces Rapide");
         accesRapide_ = new AccesRapide(nodeAccRap_);
         
         nodeOrdi_ = new Racine("Ordinateur");
         ordinateur_ = new Ordinateur(nodeOrdi_); 
         
         verGroup.addComponent(accesRapide_).addComponent(ordinateur_);
         horGroup.addComponent(accesRapide_).addComponent(ordinateur_);
                 
         rootPanel_ = new JPanel();
         dividerPanel_ = new DividerPanel(treeContainerPanel_, rootPanel_);
         RootPopup popup = new RootPopup();
         rootPanel_.setComponentPopupMenu(popup); 
         popup.folder.addActionListener(ActionEvent -> rootPanel_.add(new Folder("Nouveau dossier")));          
         
         
         interPanel_.add(dividerPanel_,"Center");
         viewPanel_ = new ViewPanel();
         interPanel_.add(viewPanel_,"North");
    }       
}
