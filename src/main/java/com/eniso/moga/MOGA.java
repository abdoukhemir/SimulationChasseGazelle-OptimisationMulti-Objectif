/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.eniso.moga;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author ABDOU
 */
public class MOGA {

    static final int POPULATION_SIZE = 5;
    static final int MAX_GENERATIONS = 5;
    static final double CROSSOVER_RATE = 0.8;
    static final double MUTATION_RATE = 0.2;

    static final double MAX_DISTANCE = 1000.0; // Distance maximale
    static final double MAX_SIZE = 150.0;     // Taille maximale de la gazelle
    static final double MIN_DISTANCE = 100.0; // Distance minimale
    static final double MIN_SIZE = 20.0;      // Taille minimale de la gazelle

    Random random = new Random();

    public List<Strategy> runMOGA() {
        List<Strategy> population = initializePopulation();

        for (int generation = 1; generation <= MAX_GENERATIONS; generation++) {
            evaluatePopulation(population);
            List<Strategy> nextGeneration = selectNonDominated(population);
            nextGeneration = applyCrossover(nextGeneration);
            nextGeneration = applyMutation(nextGeneration);

            population = nextGeneration;

            System.out.println("Génération " + generation + ":");
            printParetoFront(population);  // Print the Pareto front (Rank 0 individuals)
            printAverageFitness(population); // Print the average fitness of the population
            printPopulation(population);   // Print the whole population for debugging
        }

        return population;
    }

    private List<Strategy> initializePopulation() {
        List<Strategy> population = new ArrayList<>();
        for (int i = 0; i < POPULATION_SIZE; i++) {
            double distance = MIN_DISTANCE + (random.nextDouble() * (MAX_DISTANCE - MIN_DISTANCE));
            double size = MIN_SIZE + (random.nextDouble() * (MAX_SIZE - MIN_SIZE));
            population.add(new Strategy(distance, size));
        }
        return population;
    }

    private void evaluatePopulation(List<Strategy> population) {
        for (Strategy strategy : population) {
            strategy.paretoRank = computeParetoRank(strategy, population);
            strategy.fitness = 1.0 / (1 + strategy.paretoRank);
        }
    }

    private int computeParetoRank(Strategy strategy, List<Strategy> population) {
        int rank = 0;
        for (Strategy other : population) {
            if (dominates(other, strategy)) {
                rank++;
            }
        }
        return rank;
    }

    private boolean dominates(Strategy s1, Strategy s2) {
        return (s1.size >= s2.size && s1.distance <= s2.distance) && 
               (s1.size > s2.size || s1.distance < s2.distance);
    }

    private List<Strategy> selectNonDominated(List<Strategy> population) {
        return population.stream()
                .sorted(Comparator.comparingDouble(s -> s.fitness))
                .limit(POPULATION_SIZE)
                .collect(Collectors.toList());
    }

    private List<Strategy> applyCrossover(List<Strategy> population) {
        List<Strategy> offspring = new ArrayList<>();
        for (int i = 0; i < population.size(); i += 2) {
            if (i + 1 < population.size() && random.nextDouble() < CROSSOVER_RATE) {
                Strategy parent1 = population.get(i);
                Strategy parent2 = population.get(i + 1);

                double childDistance = (parent1.distance + parent2.distance) / 2;
                double childSize = (parent1.size + parent2.size) / 2;

                offspring.add(new Strategy(childDistance, childSize));
            }
        }
        population.addAll(offspring);
        return population;
    }

    private List<Strategy> applyMutation(List<Strategy> population) {
        for (Strategy strategy : population) {
            if (random.nextDouble() < MUTATION_RATE) {
                strategy.distance += random.nextGaussian() * 10; // Petite variation
                strategy.size += random.nextGaussian() * 5;      // Petite variation

                // Garder les valeurs dans les limites
                strategy.distance = Math.max(MIN_DISTANCE, Math.min(MAX_DISTANCE, strategy.distance));
                strategy.size = Math.max(MIN_SIZE, Math.min(MAX_SIZE, strategy.size));
            }
        }
        return population;
    }

    private void printPopulation(List<Strategy> population) {
        population.forEach(System.out::println);
        System.out.println();
    }

    private void printParetoFront(List<Strategy> population) {
        System.out.println("Pareto Front (Rank 0):");
        population.stream()
                  .filter(s -> s.paretoRank == 0)
                  .forEach(System.out::println);
        System.out.println();
    }

    private void printAverageFitness(List<Strategy> population) {
        double averageFitness = population.stream()
                                          .mapToDouble(s -> s.fitness)
                                          .average()
                                          .orElse(0.0);
        System.out.println("Average Fitness: " + String.format("%.4f", averageFitness));
    }

}
