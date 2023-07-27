/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.util.ArrayList;

/**
 *
 * @author PhamNgocMinh
 */
public interface Dao<E> {
    public ArrayList<E> GetArrayListAll();
    public E getObjectByID(String idObject);

    
}
