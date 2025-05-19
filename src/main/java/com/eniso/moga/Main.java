/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.moga;

import java.util.List;

/**
 *
 * @author ABDOU
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Exécution de l'algorithme MOGA...");
        
        MOGA moga = new MOGA();
        List<Strategy> finalPopulation = moga.runMOGA();

        System.out.println("Population finale :");
        finalPopulation.forEach(System.out::println);
    }
}
