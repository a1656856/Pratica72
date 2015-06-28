
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome completo do arquivo");
        file = scanner.next();
        ContadorPalavras cont = new ContadorPalavras(file);
        
        HashMap<String, Integer> palavras = cont.getPalavras();
        
      
     
        List lista = new LinkedList();

        lista.addAll(palavras.values());
        Collections.sort(lista);
       
        Set<Map.Entry<String, Integer>> entries;
        File file_in = cont.getFile();
        String str_in = file_in.getPath();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(str_in+".out"))) {
            for (Object j: lista) {
                
                entries = palavras.entrySet();
                for (Map.Entry<String, Integer> entry: entries) {
                    if(Objects.equals(entry.getValue(), j)) {
                        bw.write(entry.getKey() + "," + entry.getValue());
                        bw.newLine();
                        palavras.remove(entry.getKey());
                        break;
                    }
                }

            }
        }
    }
}
