/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.envers;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import org.hibernate.envers.Audited;

@Entity
public class Book implements Serializable {

    private long id;
    private String title;
    private int isin;
    private Date lastModifiedDate;

       
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book_id_seq")
    @SequenceGenerator(name="book_id_seq", sequenceName="book_id_seq")
    public long getId() {
        return id;
    }

    public Book(){
    }

    public Book(String title, int isin){
        this.title = title;
        this.isin = isin;
        this.lastModifiedDate = new Date();
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
   @Audited
    public int getIsin() {
        return isin;
    }

    public String getTitle() {
        return title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIsin(int isin) {
        this.isin = isin;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
    
}
