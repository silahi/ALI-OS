 
package explorer;


import java.awt.BorderLayout;
import java.awt.CardLayout;
 
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;  
import javax.swing.tree.DefaultMutableTreeNode;
 

/**Fichier : Explorator.java
 *Date de création : 16/11/18
 * Modifications : 
 * Mescriptions : classe principale contenant l'ensemble des fichiers du systeme
 * @author alhoussene
 */
public class Explorator extends JFrame  {
    
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
    
    // création d'un gestionnaire de pile
    private CardLayout pile_ = null;
    
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
         
         accesRapide_.addTreeSelectionListener((TreeSelectionEvent)->{
            if(accesRapide_.getSelectionPath() != null){
            String chemin = accesRapide_.getSelectionPath().toString();
            viewPanel_.pathField_.setText(chemin);            
            }
         });
         
         nodeOrdi_ = new Racine("Ordinateur");
         ordinateur_ = new Ordinateur(nodeOrdi_); 
         
         ordinateur_.addTreeSelectionListener((TreeSelectionEvent)->{
           if(ordinateur_.getSelectionPath() != null){
            String chemin = ordinateur_.getSelectionPath().toString();
            viewPanel_.pathField_.setText(chemin);            
            }
         });
         
         verGroup.addComponent(accesRapide_).addComponent(ordinateur_);
         horGroup.addComponent(accesRapide_).addComponent(ordinateur_);
                 
         rootPanel_ = new JPanel();
         pile_ = new CardLayout();
         rootPanel_.setLayout(pile_);
         dividerPanel_ = new DividerPanel(new Defileur(treeContainerPanel_), rootPanel_);
          
         
         interPanel_.add(dividerPanel_,"Center");
         viewPanel_ = new ViewPanel();
         interPanel_.add(viewPanel_,"North");
         
         //Ajout de quelques enfants par défaut
         nodeOrdi_.add(new DefaultMutableTreeNode("Bureau"));
         nodeOrdi_.add(new DefaultMutableTreeNode("Documents"));
         nodeOrdi_.add(new DefaultMutableTreeNode("Images"));
         nodeOrdi_.add(new DefaultMutableTreeNode("Musiques"));
         nodeOrdi_.add(new DefaultMutableTreeNode("Telechargements"));
         nodeOrdi_.add(new DefaultMutableTreeNode("Videos"));
         nodeOrdi_.add(new DefaultMutableTreeNode("ALIOS(C:)"));
         nodeOrdi_.add(new DefaultMutableTreeNode("ALIOS(D:)"));
         
         // Acces rapide
         nodeAccRap_.add(new DefaultMutableTreeNode("Bureau"));
         nodeAccRap_.add(new DefaultMutableTreeNode("Documents"));
         nodeAccRap_.add(new DefaultMutableTreeNode("Telechargements"));
         nodeAccRap_.add(new DefaultMutableTreeNode("Videos"));
         nodeAccRap_.add(new DefaultMutableTreeNode("Musiques"));
         nodeAccRap_.add(new DefaultMutableTreeNode("Images")); 
         
    }   
 
   
}
