/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.Tareas.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Manuel
 */
public class RegistroCsv{
    private File archivo;
        
    public RegistroCsv(String name){
        File url = new File("src/main/java/com/db/Tareas/Archivador");
        this.archivo = new File(url,name + ".csv");
    }
    
    public void existeFile(){
        //CONDICIONES DEL DIR 
        if(! this.archivo.exists() ){
            System.out.println("no existe. Ya se ha creado");
            try {
                this.archivo.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        else{
            System.out.printf("El directorio %s, ya existe", this.archivo.getName());
        }
    }
    
    //fw.write("Cuenta - Tipo de Cuenta - Persona \n");
    
//    public void writeFile(int idTarea, String descripcion, String estado, int condicion){
//        FileWriter fw = null;
//        PrintWriter pw = null;
//        try {
//            fw = new FileWriter(this.archivo.getAbsoluteFile(), true);  
//            pw = new PrintWriter(fw);
//            //fw.append("/n");
//            //fw.write("/n");
//            pw.append(""+idTarea+"-"+descripcion+"-"+estado+"-"+condicion+"\n");
//            pw.close();
//            fw.close();
//        } catch (IOException ex) {
//            System.out.println("NO SE PUEDE ESCRIBIR");
//        }
//    }

    public void writeFile(List<Tarea> lista){
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(this.archivo.getAbsoluteFile(), true);  
            pw = new PrintWriter(fw);
            //fw.append("/n");
            //fw.write("/n");
            for(Tarea hoja: lista){
                pw.append(""+hoja.getIdTarea()+"-"+hoja.getDescripcion()+"-"+hoja.getEstado()+"-"+hoja.getArchivado()+"\n");
            }
            
            pw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("NO SE PUEDE ESCRIBIR");
        }
    }
    
    public static void main(String[] args) {
        RegistroCsv fichero = new RegistroCsv("lucky");
        fichero.existeFile();
//        Set<String> arrays = new HashSet<String>(4);
//        arrays.add("piso1");
//        arrays.add("piso2");
//        arrays.add("piso3");
//        arrays.add("piso4");
//        
//        for(String lista: arrays){
//            fichero.writeFile(0, lista, lista, 0);
//        }
        
        
        //fichero.writeFile(2, "prueba2", "to do", 0);
        
    }
}
