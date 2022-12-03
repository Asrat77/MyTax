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
public class CalcTax extends Tax implements Serializable {
            
        private float amount;
        private float result;
        private Tax tax;
        
        public CalcTax(){}
        
        
        public CalcTax(float amount, float result, float rate, String name, Tax tax){
            super(name,rate);
            if (Checker.validatePositive(amount)){
                this.amount = amount;
            }else {
                String error = String.format("The amount is invalid.");
                throw new IllegalArgumentException(error);
            }
            this.tax = tax;
        
        }
        public float getAmount(){
            return amount;
        }
        public float getResult(){
            return result;
        }
        public void setAmount(float amount){
            this.amount = amount;
        }
        public void setResult(float result){
            this.result = result;
        }
        /**
     * @return the tax
     */
    public Tax getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(Tax tax) {
        this.tax = tax;
    }
        
    public float calculateTax(float rate, float amount){
        this.result = amount*rate;
        return this.result/100;
    }
     

}
