/*
 * Copyright (C) 2016 askam
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package app;

import java.util.ArrayList;

/**
 * Représente un abre n-aire
 * @author askam
 */
public class Arbre
{
    
    ///////////////////////////////////////////////////////////////////////////
    /// Attributs & constructeurs
    ///////////////////////////////////////////////////////////////////////////

    private Integer valeur;
    private ArrayList<Arbre> fils;
    
    /**
     * Constructeur
     */
    public Arbre() {
        this.valeur = null;
        this.fils = null;
    }
    
    /**
     * Constructeur (équivalent de la primitive "COMPOSER()"
     * 
     * @param valeur Valeur de l'arbre
     * @param fils Liste des sous-arbres
     */
    public Arbre(Integer valeur, ArrayList<Arbre> fils)
    {
        this.valeur = valeur;
        this.fils = fils;
    }
    
    /**
     * Constructeur amélioré : gère l'ajout dynamique de sous-arbres grâce au
     * tableau passé en paramètre, ce qui simplifie son utilisation par rapport
     * à celui prenant une liste de sous-arbres en paramètre
     * 
     * @param valeur Valeur de l'arbre
     * @param fils Tableau de sous-arbres
     */
    public Arbre(Integer valeur, Arbre[] fils)
    {
        this.valeur = valeur;
        this.fils = new ArrayList<>();
        
        for (Arbre ssarbre: fils) {
            this.fils.add(ssarbre);
        }
    }

    /**
     * Constructeur
     * 
     * @param valeur Valeur de l'arbre
     */
    public Arbre(int valeur)
    {
        this.valeur = valeur;
        this.fils = null;
    }

    ///////////////////////////////////////////////////////////////////////////
    /// Getters & Setters
    ///////////////////////////////////////////////////////////////////////////
    
    /**
     * Equivalent de la primitive "RACINE()"
     * 
     * @return Integer
     */
    public Integer getValeur()
    {
        return valeur;
    }

    /**
     * Affecte à l'attribut "valeur" de l'arbre la valeur du paramètre
     * 
     * @param valeur
     */
    public void setValeur(Integer valeur)
    {
        this.valeur = valeur;
    }

    /**
     * Equivalent de la primitive "FILS()"
     * 
     * @return ArrayList<Arbre>
     */
    public ArrayList getFils()
    {
        return fils;
    }

    /**
     * Affecte à l'attribut "valeur" de l'arbre la valeur du paramètre
     * 
     * @param fils
     */
    public void setFils(ArrayList<Arbre> fils)
    {
        this.fils = fils;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    /// Méthodes privées
    ///////////////////////////////////////////////////////////////////////////
    

    
    ///////////////////////////////////////////////////////////////////////////
    /// Méthodes publiques
    ///////////////////////////////////////////////////////////////////////////
    
    /**
     * Renvoie vrai si la liste de fils de l'arbre courant est vide
     * 
     * @return boolean
     */
    public boolean feuille()
    {
        return this.fils == null;
    }
    
    /**
     * Renvoie vrai si l'arbre passé en paramètre est vide
     * 
     * @param arbre Arbre ciblé
     * @return boolean
     */
    public static boolean vide(Arbre arbre)
    {
        return arbre == null;
    }

    
    /**
     * Parcours en profondeut d'abord => affichage de toutes les valeurs
     * 
     * @param arbre Arbre ciblé
     * @param tab Chaîne permettant l'indentation à l'affichage des valeurs
     * @throws Exception 
     */
    public static int parcoursProfondeur(Arbre arbre, String tab) throws Exception
    {
        if (Arbre.vide(arbre)) {
            throw new Exception("L'arbre passé en paramètre ne peut être vide.");
        } else if (arbre.feuille()) {
            System.out.println(tab + arbre.valeur);
        } else {
            System.out.println(tab + arbre.valeur);
            for (Arbre fils: arbre.fils) {
                Arbre.parcoursProfondeur(fils, tab + "  ");
            }
        }
        
        return 0;
    }
    
    /**
     * Surcharge du parcours en profondeur - utilisation simplifiée
     * 
     * @param arbre Arbre ciblé
     * @throws Exception 
     */
    public static void parcoursProfondeur(Arbre arbre) throws Exception
    {
        Arbre.parcoursProfondeur(arbre, "");
    }
    
    /**
     * Parcours en largeur => affichage de toutes les valeurs
     * 
     * @param arbre Arbre ciblé
     * @throws java.lang.Exception 
     */
    public static void parcoursLargeur(Arbre arbre) throws Exception
    {
        if (Arbre.vide(arbre)) {
            throw new Exception("L'arbre passé en paramètre ne peut être vide");
        }
        
        ArrayList<Arbre> file = new ArrayList<>();
        file.add(arbre);
        
        while (!file.isEmpty()) {
            Arbre tmp = file.get(0);
            System.out.println(tmp.valeur);
            file.remove(tmp);
            
            if (!tmp.feuille()) {
                for (Arbre fils: tmp.fils) {
                    file.add(fils);
                }
            }
        }
    }
}
