/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.util;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author danhylo
 */
public class DATE {
    
    public static Date xmlGregorianCalendarToDate(XMLGregorianCalendar date){        
        return date.toGregorianCalendar().getTime();
    }
    
    public static String xmlGregorianCalendarToXml(XMLGregorianCalendar date){
        return date.toString().replace("Z", "");
    }
    
    public static Date getDate(){
        return new GregorianCalendar().getTime();
    }
    
    public static Date newDate(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second){
        return new GregorianCalendar(year, month-1, dayOfMonth, hourOfDay, minute, second).getTime();
    }
    
}
