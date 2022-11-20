/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mytax;

import java.lang.reflect.Method;

/**
 *
 * @author asrat
 */
public class Checker {
    
    public static void validateStrType(String s){
        //
    }
    
    
    public static boolean validatePositive(float value) {
        return value > 0;
    }
    
    public static Method getByMethodName(Object obj, String method, Class<?>... args) {
        String error;
        try {
            return obj.getClass().getMethod(method, args);
        } catch(NoSuchMethodException | SecurityException ex) {
            error = ex.getMessage();
        }
        return null;
    }
    
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

