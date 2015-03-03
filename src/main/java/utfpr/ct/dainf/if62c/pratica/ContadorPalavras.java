/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author a1608355
 */
public class ContadorPalavras {
    BufferedReader reader;
    String file;
    
    
    public ContadorPalavras(String file) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(file));
        this.file = file;
    }
    
    public HashMap<String, Integer> getPalavras() throws IOException{
        StringTokenizer st;
        String line;
        String word;
        HashMap<String, Integer> palavras = new HashMap<>();
                
        while((line = reader.readLine()) != null){
            st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                word = st.nextToken();
                if(!palavras.containsKey(word)){
                    palavras.put(word,1);
                }else{
                    palavras.replace(word, palavras.get(word)+1);
                }
            }
        }
        reader.close();
        
        return palavras;
    }
    
    public File getFile(){
        return new File(file);
    }
}
