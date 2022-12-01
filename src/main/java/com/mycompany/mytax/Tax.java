/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mytax;

import java.io.Serializable;

/**
 *
 * @author asrat
 */
public class Tax implements Serializable{
    private String name;
    private float rate;
    private float basePrincipal;
    
    public Tax(){}
    
    public Tax(String name, float rate, float basePrincipal){
        if (Checker.validatePositive(rate)){
            this.rate = rate;
        }else {
            String error = String.format("The rate is invalid.");
            throw new IllegalArgumentException(error);
        }
        if (Checker.validatePositive(basePrincipal)){
            this.rate = rate;
        }else {
            String error = String.format("The base principal is invalid.");
            throw new IllegalArgumentException(error);
        }
        this.name = name;
    }

    public Tax(String name, float rate) {
        if (Checker.validatePositive(rate)){
            this.rate = rate;
        } else {
            String error = String.format("The rate is invalid.");
            throw new IllegalArgumentException(error);
        }
        this.name = name;
    }
    
    
    
    public String getName(){
        return name;
    }
    public float getRate(){
        return rate;
    }
    public float setBase(){
        return basePrincipal;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setRate(float rate){
        if (Checker.validatePositive(rate)){
            this.rate = rate;
        }else {
            String error = String.format("The rate is invalid.");
            throw new IllegalArgumentException(error);
        }
    }


    public void setBase(float basePrincipal){
        if (Checker.validatePositive(basePrincipal)){
            this.basePrincipal = basePrincipal;
        }else {
            String error = String.format("The rate is invalid.");
            throw new IllegalArgumentException(error);
        }
    }
//public setName
    @Override
    public String toString(){
        return name;
    }

}