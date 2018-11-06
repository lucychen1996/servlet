/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletpackage;
import java.io.Serializable;

/**
 * @author Lucyc
 */
public class bean extends Object implements Serializable {

    public static final String ISTATUS = "Message";

    private String status;
    private String name;
    private String email;
    private String message;

    public bean() {
        status = ISTATUS;
        name = new String();
        email = new String();
        message = new String();
    }

    public String getStatus() {return status;}
    public void setStatus(String value) {status = value;}
    
    public String getName() {return name;}
    public void setName(String value) {name = value;}
    
    public String getEmail() {return email;}
    public void setEmail(String value) {email = value;}

    public String getMessage() {return message;}
    public void setMessage(String value) {message = value;}


}

