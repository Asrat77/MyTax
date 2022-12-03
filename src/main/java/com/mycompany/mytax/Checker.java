/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mytax;

import java.lang.reflect.Method;

/**
 *
 * @author Betemariam
 */
public class Checker {
    
    

    // checking if the value we get is number or not using this boolean value to
    //inform us using
    //the default boolean since if its > 0 by default it is true
    
    public static boolean validatePositive(float value){
        return value >0;
    }
    
    
    
    //method to identify if the method exists and if it is editable
    
    public static Method getByMethodName(Object obj, String method, Class<?>... args) {
        String error;
        try {
            return obj.getClass().getMethod(method, args);
        } catch(NoSuchMethodException | SecurityException ex) {
            error = ex.getMessage();
        }
        return null;
    }
    
    
    
    //method to start or instanciate or invoke the methods accordingly to 
    //the parameters given inside them
    public static Object callMethod(Method method, Object obj, Object... args) {
        String error;
        try {
            return method.invoke(obj, args);
        } catch(Exception ex) {
            error = ex.getMessage();
        }
        return null;
    }    
    
}

