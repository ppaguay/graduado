/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.rnegocio.clases;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XL
 */
public class AppJson<T> {
    String message="";
    int success=0;
    ArrayList<T> data= new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }

 
    
    
}
