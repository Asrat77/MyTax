/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mytax.services;

/**
 *
 * @author asrat
 */

import com.mycompany.mytax.Tax;
import com.mycompany.mytax.base.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



public class TaxService {
    
        private final String filename = "tax.obj";
        
        public void save(Tax tax) throws IOException {
        File f = new File(filename);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if (f.exists()) {
                fos = new FileOutputStream(filename, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(filename);
                oos = new ObjectOutputStream(fos);
            }
            
            oos.writeObject(tax);

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

    public ArrayList<Tax> getAll() {
        boolean eof = false;
        ArrayList<Tax> data = new ArrayList<>(); 

        try (
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            Tax unit;

            while (!eof) {
                unit = (Tax)ois.readObject();
                if (unit != null) {
                    data.add(unit);
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
    
    public void writeAll(List<Tax> taxs) {
        try {
            try (FileOutputStream fos = new FileOutputStream(filename);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (Tax unit: taxs) {
                    oos.writeObject(unit);
                }
            }
        } catch (IOException ex) {
            
        }
    }
}

    

