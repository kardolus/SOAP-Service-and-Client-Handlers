package us.kardol.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import us.kardol.soap.service.HoverboardException;

/**
 * @author Guillermo Kardolus
 * 
 * Class that manages a thread safe collection of Invention objects
 */
public class Inventions {
    public static final Map<Integer, Invention> DATA = new ConcurrentHashMap<>();
    private AtomicInteger id = new AtomicInteger();
    
    // testing the difference between application and soap thrown exceptions
    public Integer addInvention(Invention inv) throws HoverboardException{
        Integer key = id.incrementAndGet();
        inv.setId(key);
        if(inv.getInvention().equals("Hoverboard")){
            throw new HoverboardException("Not a valid invention", 
                    "Invention equals Hoverboard");
        }
        DATA.put(key, inv);
        return key;
    }
    public Invention getInvention(Integer key){
        return DATA.get(key);
    }
    public List<Invention> getInventions(){
        List<Invention> result = new ArrayList<>();
        
        Object [] invs = DATA.values().toArray();
        Arrays.sort(invs);
        for(Object o : invs){
            if(o instanceof Invention){
                result.add((Invention) o);
            }
        }
        return result;
    }
}
