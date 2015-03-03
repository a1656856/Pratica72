
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import utfpr.ct.dainf.if62c.pratica.ComparadorMapa;
import utfpr.ct.dainf.if62c.pratica.ContadorPalavras;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica72 {
    public static void main(String[] args) throws IOException {
        String file;
        Scanner in = new Scanner(System.in);
        
        System.out.println("Digite o nome completo do arquivo");
        file = in.next();
        ContadorPalavras cont = new ContadorPalavras(file);
        
        HashMap<String, Integer> palavras = cont.getPalavras();
        
        Set<Map.Entry<String, Integer>> entries = palavras.entrySet();
        ArrayList<Map.Entry<String, Integer>> lista = new ArrayList(entries);
        ComparadorMapa comparador = new ComparadorMapa();
        Collections.sort(lista, comparador);
        
        File file_in = cont.getFile();
        String str_in = file_in.getPath();
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(str_in+".out"));
        for(Map.Entry<String, Integer> en: lista){
            bw.write(en.getKey()+","+en.getValue());
            bw.newLine();   
        }
        
        bw.close();
    }
}
