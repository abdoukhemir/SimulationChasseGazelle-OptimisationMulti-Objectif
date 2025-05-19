/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.moga;

/**
 *
 * @author ABDOU
 */
public class Strategy {
    public double distance; // Distance parcourue
    public double size;     // Taille de la gazelle
    public double fitness;  // Fitness basé sur le classement Pareto
    public int paretoRank;  // Rang de Pareto

    public Strategy(double distance, double size) {
        this.distance = distance;
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Distance: %.2f, Taille: %.2f, Fitness: %.4f", distance, size, fitness);
    }
}

