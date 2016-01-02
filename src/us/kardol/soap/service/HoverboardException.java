package us.kardol.soap.service;

/**
 * @author Guillermo Kardolus
 */
public class HoverboardException extends Exception {
    private String details = null;
    public HoverboardException(String reason, String details){
        super(reason);
        this.details = details;
    }
    public String getFaultInfo(){
        return this.details;
    }
}
