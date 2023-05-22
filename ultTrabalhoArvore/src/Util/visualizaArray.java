/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author bruno
 */
public class visualizaArray {

    public static void visu(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(" | "+a[i] + " /");
        }
    }
}
