package us.kardol.soap.service;

import java.util.List;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import us.kardol.utility.Settings;
import us.kardol.data.Invention;
import us.kardol.data.Inventions;
import us.kardol.utility.FileParser;

/**
 * @author Guillermo Kardolus
 */
@WebService
@HandlerChain(file = Settings.HANDLER_XML)
public class SOAPResource {
    private Inventions inv = new Inventions();
    
    public SOAPResource(){
        if(Inventions.DATA.isEmpty()){
            new FileParser().parse(Settings.DATABASE_PATH);
        }
    }
    
    @WebMethod
    public List<Invention> getAll(){
        return inv.getInventions();
    }
    
    @WebMethod
    public Invention getOne(Integer id){
        return inv.getInvention(id);
    }
    
    @WebMethod
    public Integer create(Invention i) throws HoverboardException{
        return inv.addInvention(i);
    }
}
