/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author a1608355
 */
public class ComparadorMapa implements Comparator<Map.Entry<String, Integer>>{

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if(o1.getValue() < o2.getValue())
            return -1;
        else if(o1.getValue() > o2.getValue())
            return 1;
        else return 0;
    }
    
}
