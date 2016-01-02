package us.kardol.data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Guillermo Kardolus
 */
public class Invention implements Serializable, Comparable<Invention> {
    private Integer id = null, year = null;
    private String inventor = null, invention = null;
    
    public Invention(){ }
    public Invention(String inventor, String invention, Integer year){
        this.inventor = inventor;
        this.invention = invention;
        this.year = year;
    }
    
    @Override
    public int compareTo(Invention o) {
        return this.getYear().compareTo(o.getYear());
    }
    
    @Override
    public String toString(){
        return this.getYear().toString() + " " + this.getInventor() + " " 
                + this.getInvention();
    }
    
    @Override
    public boolean equals(Object o){
        return o instanceof Invention 
                && ((Invention)o).getYear().equals(this.getYear())
                && ((Invention)o).getInventor().equals(this.getInventor())
                && ((Invention)o).getInvention().equals(this.getInvention());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.year);
        return hash;
    }
    
    public void setId(Integer id){
        this.id = id;
    } 
    public void setYear(Integer year){
        this.year = year;
    }
    public void setInventor(String inventor){
        this.inventor = inventor;
    }
    public void setInvention(String invention){
        this.invention = invention;
    }
    public Integer getId(){
        return this.id;
    }
    public Integer getYear(){
        return this.year;
    }
    public String getInvention(){
        return this.invention;
    }
    public String getInventor(){
        return this.inventor;
    }
}
