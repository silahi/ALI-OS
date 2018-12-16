 
package explorer;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
    protected JPanel accesRapidePanel_ = null;
    
    /** Ce panneau (panel haut de l'explorteur de fichier) va contienir :
     *  
     */
    
    public Explorator(){
        setSize(1200 , 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
