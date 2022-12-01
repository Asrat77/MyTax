/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mytax.services;


import com.mycompany.mytax.Tax;
import com.mycompany.mytax.CalcTax;
import com.mycompany.mytax.base.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author asrat
 */
public class CalcTaxService {
    private final String fileName = "calcTax.obj";
    
    public void save(CalcTax calcTax) throws IOException {
        File f = new File(fileName);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if (f.exists()) {
                fos = new FileOutputStream(fileName, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(fileName);
                oos = new ObjectOutputStream(fos);
            }
            
            oos.writeObject(calcTax);

            oos.close();
            fos.close();
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
    
    
    public ArrayList<CalcTax> getAll() {
        boolean eof = false;
        ArrayList<CalcTax> data = new ArrayList<>(); 

        try (
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            CalcTax calcTax;

            while (!eof) {
                calcTax = (CalcTax)ois.readObject();
                if (calcTax != null) {
                    data.add(calcTax);
                } else {
                    eof = true;
                }
            }
        } catch (IOException ex) {
//            ex.printStackTrace();
        } finally {
            return data;
        }
    }
    
    public void writeAll(List<CalcTax> calcTaxs) {
        try {
            try (FileOutputStream fos = new FileOutputStream(fileName);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (CalcTax calcTax: calcTaxs) {
                    oos.writeObject(calcTax);
                }
            }
        } catch (IOException ex) {
            
        }
    }
    
}


