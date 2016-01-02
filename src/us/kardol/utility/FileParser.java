package us.kardol.utility;

import us.kardol.soap.service.HoverboardException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import us.kardol.data.Invention;
import us.kardol.data.Inventions;

/**
 * @author Guillermo Kardolus
 */
public class FileParser {
    public void parse(String fileName){
        File f = new File(fileName);
        String line;
        
        if(!f.exists()){
            System.out.println("No such file");
            return;
        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            Inventions invs = new Inventions();
            
            while((line = br.readLine()) != null){
                String[] fields = line.split(",");
                Invention i = new Invention(fields[0], fields[1], 
                        Integer.valueOf(fields[2]));
                try {
                    invs.addInvention(i);
                } catch (HoverboardException ex) {
                    Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
