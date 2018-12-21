 
package explorer;


import alios.Application;
import alios.MBTEvent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
 
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;  
import javax.swing.UIManager;
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
    
    //Repertoire de travail
    private final String REP_1 = "alios/Disque local C";
    private final String REP_2 = "alios/Disque local D";
    
   // com.sun.java.swing.
    private final String WINDOW = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
    public Explorator(){
        setSize(1200 , 700);
        setLocation(20,15);
        setIconImage(new ImageIcon("Pictures/Computer.PNG").getImage());
        setExtendedState(MAXIMIZED_BOTH); 
        try{
            UIManager.setLookAndFeel(WINDOW);
        }catch(Exception ex){} 
        
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
         rootPanel_.setBackground(new Color(237,237,237));
         
         pile_ = new CardLayout();
         rootPanel_.setLayout(pile_);
         dividerPanel_ = new DividerPanel(new Defileur(treeContainerPanel_), new Defileur(rootPanel_)); 
         rootPanel_.addMouseListener(new MouseAdapter(){            
           @Override
           public void mouseEntered(MouseEvent me){
               Application.barTache.setLocation(0,762);
           }
        });
         interPanel_.add(dividerPanel_,"Center");
         viewPanel_ = new ViewPanel();
         interPanel_.add(viewPanel_,"North");
         
         //Ajout de quelques enfants par défaut
         nodeOrdi_.add(new DefaultMutableTreeNode("Bureau",true));
         nodeOrdi_.add(new DefaultMutableTreeNode("Documents",true));
         nodeOrdi_.add(new DefaultMutableTreeNode("Images",true));
         nodeOrdi_.add(new DefaultMutableTreeNode("Musiques",true));
         nodeOrdi_.add(new DefaultMutableTreeNode("Téléchargements",true));
         nodeOrdi_.add(new DefaultMutableTreeNode("Videos",true));
         
         //Contenu du disque C 
         java.io.File C = new java.io.File(REP_1);
         DefaultMutableTreeNode diskC = new DefaultMutableTreeNode("Disque local C");
           nodeOrdi_.add(diskC);
            for(java.io.File f : C.listFiles()){
                diskC.add(new DefaultMutableTreeNode(f.getName()));
            }
           
         //Contenu du disque D 
         java.io.File D = new java.io.File(REP_2);
         DefaultMutableTreeNode diskD = new DefaultMutableTreeNode("Disque local D",true);
          nodeOrdi_.add(diskD);
          for(java.io.File f : D.listFiles()){   
              DefaultMutableTreeNode n1 = new DefaultMutableTreeNode(f.getName(),true); 
                diskD.add(n1); 
                if(f.isDirectory()){
                    java.io.File[] tab = f.listFiles();
                    if(tab.length> 0){
                        for(java.io.File fic : tab){
                            if(fic.isDirectory())
                        n1.add(new DefaultMutableTreeNode(fic.getName()));
                       }
                    }
                }
            }
         
         // Acces rapide
         nodeAccRap_.add(new DefaultMutableTreeNode("Bureau",true));
         nodeAccRap_.add(new DefaultMutableTreeNode("Documents",true));
         nodeAccRap_.add(new DefaultMutableTreeNode("Téléchargements",true));
         nodeAccRap_.add(new DefaultMutableTreeNode("Videos",true));
         nodeAccRap_.add(new DefaultMutableTreeNode("Musiques",true));
         nodeAccRap_.add(new DefaultMutableTreeNode("Images",true)); 
         
         //Contenu du repertoire du system
         
         
         
    }   
      
}
