/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.List;

/**
 *
 * @author bruno
 */
public class tabelaDeTempo {

    public static String formatAsTable(List<List<String>> linhas) {
        int[] linhasMaximas = new int[linhas.get(0).size()];
        for (List<String> row : linhas) {
            for (int i = 0; i < row.size(); i++) {
                linhasMaximas[i] = Math.max(linhasMaximas[i], row.get(i).length());
            }
        }

        StringBuilder formatBuilder = new StringBuilder();
        for (int maxLength : linhasMaximas) {
            formatBuilder.append("%-").append(maxLength + 2).append("s");
        }
        String format = formatBuilder.toString();

        StringBuilder result = new StringBuilder();
        for (List<String> row : linhas) {
            result.append(String.format(format, row.toArray(new String[0]))).append("\n");
        }
        return result.toString();
    }
}
