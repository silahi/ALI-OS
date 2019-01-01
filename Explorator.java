 
package explorer;


import alios.Application; 
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color; 
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 
 
import javax.swing.GroupLayout;
import javax.swing.ImageIcon; 
import javax.swing.JFrame;
import javax.swing.JPanel;  
import javax.swing.JTree;
import javax.swing.UIManager; 
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
 

/**Fichier : Explorator.java
 *Date de création : 16/11/18
 * Modifications : 
 * Mescriptions : classe principale contenant l'ensemble des fichiers du systeme
 * @author alhoussene
 */
public class Explorator extends JFrame  implements TreeSelectionListener  {
    
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
    protected JTree ordinateur_ = null;
    
     /*
      Création d'un instance de l'arbre de L'acces rapide qui sera
      ajouté dans le panneau gauche
    */
    protected JTree accesRapide_ = null;  
    
    // création d'un panneau de division
    protected DividerPanel dividerPanel_ = null;
    
    //Panneau intermediaire 
    private JPanel interPanel_ = null;    
    protected ViewPanel viewPanel_ = null; 
    
    //panel du nord
    protected ExplorerConfigPanel expConfPan_ = null;
    
    // création d'un gestionnaire de pile
    private CardLayout pile_ = null; 
    
   // com.sun.java.swing.
    private final String WINDOW = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    
   //page d'accueil de l'explorateur de fichier
    protected ExplorerHome expHom ;
    
    
    // Noeuds principaux de l'arbre ordinateur    
    protected DefaultMutableTreeNode racineOrdi_  , aliosC_ , aliosD_;
    protected DefaultMutableTreeNode desktop  , download , music , image , movie , document;
    protected final String REP_ORDI  = "alios/";
    
    //Noeud racine de l'arbre acces rapide
    protected DefaultMutableTreeNode racineAcces_;
           
    public Explorator(){
        setSize(1200 , 700);
        setLocation(20,15);
        setIconImage(new ImageIcon("Pictures/Computer.PNG").getImage());
        setExtendedState(MAXIMIZED_BOTH); 
        expHom = new ExplorerHome();
        expConfPan_ = new ExplorerConfigPanel();
        viewPanel_ = new ViewPanel();
        dividerPanel_ = new DividerPanel();
        
        try{
            UIManager.setLookAndFeel(WINDOW);
       }catch(Exception ex){ System.out.println(ex.getMessage());} 
        
        computerTreeBuilding();
        speedAccesTreeBuilding(); 
        
        //creation et ajout du pannrau intermediaire
         interPanel_ = new JPanel();
         interPanel_.setLayout(new BorderLayout());
         add(interPanel_ , "Center");  
         
         add(expConfPan_,"North"); 
         
         add(new JPanel(),"East");
         treeContainerPanel_ = new JPanel();
         treeContainerPanel_.setBackground(new Color(237,237,237));
         group_ = new GroupLayout(treeContainerPanel_);
         group_.setAutoCreateContainerGaps(true);
         group_.setAutoCreateGaps(true);
         treeContainerPanel_.setLayout(group_);
         // création des propriétés du groupe
         
         GroupLayout.SequentialGroup verGroup  = group_.createSequentialGroup();
         GroupLayout.ParallelGroup horGroup    = group_.createParallelGroup();
         
         group_.setVerticalGroup(verGroup);
         group_.setHorizontalGroup(horGroup); 
         
         //instantiation des arbres
         
         verGroup.addComponent(accesRapide_).addComponent(ordinateur_);
         horGroup.addComponent(accesRapide_).addComponent(ordinateur_);
                 
         rootPanel_ = new JPanel();
         rootPanel_.setBackground(new Color(237,237,237));
         
         pile_ = new CardLayout();
         rootPanel_.setLayout(pile_);
         
         rootPanel_.add(expHom , "homme");  
         addFiles();
         
         expHom.disqueC.addActionListener((ActionEvent)-> {
             pile_.show(rootPanel_ , "disqueC");
         });
         
         expHom.disqueD.addActionListener((ActionEvent)-> {
             pile_.show(rootPanel_ , "disqueD");
         });
         
         viewPanel_.left_.addActionListener((ActionEvent)->{
             pile_.previous(rootPanel_);
         });
         viewPanel_.right_.addActionListener((ActionEvent)->{
             pile_.next(rootPanel_);             
         });
         
         Defileur defileur = new Defileur(treeContainerPanel_);
         dividerPanel_.setLeftComponent(defileur);
         dividerPanel_.setRightComponent(new Defileur(rootPanel_));
         
         
         rootPanel_.addMouseListener(new MouseAdapter(){            
           @Override
           public void mouseEntered(MouseEvent me){
               Application.barTache.setLocation(0,762); 
           } 
            
        });
         interPanel_.add(dividerPanel_,"Center");         
         interPanel_.add(viewPanel_,"North"); 
   }  
    
    private void  computerTreeBuilding(){
        racineOrdi_ = new DefaultMutableTreeNode("Ordinateur" , true);
        desktop     = new DefaultMutableTreeNode("Bureau" , true);
        download    = new DefaultMutableTreeNode("Téléchargements" , true);
        document    = new DefaultMutableTreeNode("Documents" , true);
        music       = new DefaultMutableTreeNode("Musiques" , true);
        image       = new DefaultMutableTreeNode("Images" , true);
        movie       = new DefaultMutableTreeNode("Videos" , true);
        aliosC_     = new DefaultMutableTreeNode("ALIOS(C:)" , true);
        aliosD_     = new DefaultMutableTreeNode("ALIOS(D:)" , true);
        
        addChildren(aliosC_ , new java.io.File("alios/ALIOS(C)"));
        addChildren(aliosD_ , new java.io.File("alios/ALIOS(D)"));
        
        racineOrdi_.add(desktop);
        racineOrdi_.add(download);
        racineOrdi_.add(document);
        racineOrdi_.add(image);
        racineOrdi_.add(movie);
        racineOrdi_.add(music);
        racineOrdi_.add(aliosC_);
        racineOrdi_.add(aliosD_);        
        ordinateur_ = new JTree(racineOrdi_ , true);
        ordinateur_.addTreeSelectionListener(this);        
        ordinateur_.setPreferredSize(new Dimension(300, 1500));
        ordinateur_.setShowsRootHandles(true);
        ordinateur_.setCellRenderer(new ComputerTreeRender()); 
    }
    
    private void speedAccesTreeBuilding(){
        racineAcces_ = new DefaultMutableTreeNode("Accès Rapide" , true);
        DefaultMutableTreeNode desk = new DefaultMutableTreeNode("Bureau" , true); 
        DefaultMutableTreeNode down = new DefaultMutableTreeNode("Téléchargements" , true); 
        DefaultMutableTreeNode img = new DefaultMutableTreeNode("Images" , true); 
        DefaultMutableTreeNode doc = new DefaultMutableTreeNode("Documents" , true); 
        DefaultMutableTreeNode mov = new DefaultMutableTreeNode("Videos" , true); 
        DefaultMutableTreeNode aud = new DefaultMutableTreeNode("Audios" , true); 
        
        
        racineAcces_.add(doc);
        racineAcces_.add(desk);
        racineAcces_.add(down);
        racineAcces_.add(mov);
        racineAcces_.add(img);
        racineAcces_.add(aud); 
        
        
        accesRapide_ = new JTree(racineAcces_ , true);
        accesRapide_.setShowsRootHandles(true);
        accesRapide_.setCellRenderer(new ComputerTreeRender());
    }
     private void  addChildren(DefaultMutableTreeNode node , java.io.File file){ 
          
         java.io.File[] tab = file.listFiles();
         for(java.io.File f1 : tab) {
             if(f1.isDirectory()){
                DefaultMutableTreeNode dmt = new DefaultMutableTreeNode(f1.getName() , true);
                node.add(dmt);
                java.io.File[] tab2 = f1.listFiles();
                for(java.io.File f2 : tab2){
                    if(f2.isDirectory()){
                        DefaultMutableTreeNode dm1 = new DefaultMutableTreeNode(f2.getName() , true);
                        dmt.add(dm1);
                    }
                }
             }
         }  
     } 
     
     private void addFiles(){
                     java.io.File disqueC = new java.io.File("alios/ALIOS(C)");
            java.io.File disqueD = new java.io.File("alios/ALIOS(D)");
            JPanel panel = new JPanel();
            for(java.io.File f : disqueC.listFiles()){
                if(f.isDirectory()){
                    os.Folder folder = new os.Folder(f.getName());
                    folder.setIcon(new ImageIcon("folder.png"));
                    panel.add(folder);
                    rootPanel_.add(panel , "disqueC");
                }
            }
            
            JPanel p = new JPanel();
            
               for(java.io.File f : disqueD.listFiles()){
                if(f.isDirectory()){
                    os.Folder folder = new os.Folder(f.getName());                   
                    folder.setIcon(new ImageIcon("folder.png"));
                    
                    p.add(folder);
                    rootPanel_.add(p , "disqueD");
                }
            }
     }

    @Override
    public void valueChanged(TreeSelectionEvent tse) {
        if(tse.getSource() == ordinateur_){

        }
     }
 }
