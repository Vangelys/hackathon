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

package main;

import app.Arbre;

/**
 * Classe d'exécution
 * @author askam
 */
public class Main
{

    public static void main(String[] args) throws Exception
    {
        Arbre a1;        
        a1 = new Arbre(5, new Arbre[] {
            new Arbre(6, new Arbre[] {
                new Arbre(0),
                new Arbre(78),
                new Arbre(89, new Arbre[] {
                    new Arbre(1)
                }),
                new Arbre(12)
            }),
            new Arbre(99, new Arbre[] {
                new Arbre(98, new Arbre[] {
                    new Arbre(97, new Arbre[] {
                        new Arbre(95)
                    }),
                    new Arbre(96)
                })
            })
        });

        Arbre.parcoursProfondeur(a1);
    }

}
