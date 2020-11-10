package it.unibo.oop.lab.collections1;

import java.util.*;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	private static final int TO_MS = 1_000_000;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
    	final List<Integer> arr = new ArrayList<Integer>();
    	
    	for(int i = 1000; i < 2000;i++) {
    		arr.add(i);
    	}
    	
    	final List<Integer> list = new LinkedList<Integer>();
    	
    	list.addAll(arr);
    	
    	Integer tmp = arr.get(arr.size() - 1);
    	arr.set(arr.size() - 1, arr.get(0));
    	arr.set(0, tmp);
    	
    	for (Integer integer : list) {
			System.out.println(integer);
		}
    	
    	long time = System.nanoTime();
    	
    	for (int i = 0; i <= 100000;i++) {
    		arr.set(0, 5);
    	}
    	
    	time = System.nanoTime() - time;
    	
        System.out.println("Time required array: " + time / TO_MS);
        
        /**********************************************************/
        
        time = System.nanoTime();
        
        for(int i = 0; i <= 100000; i++) {
        	list.add(0, 5);
        }
        
        time = System.nanoTime() - time;
    	
        System.out.println("Time required list: " + time / TO_MS);
        
        /***********************************************************/
        
        time = System.nanoTime();
        
        for(int i = 0; i <= 1000; i++) {
        	arr.get(arr.size() / 2);
        }
        
        time = System.nanoTime() - time;
        
        System.out.println("Time required access mid el. array: " + time / TO_MS);
        
        /************************************************************/
        
        time = System.nanoTime();
        
        for(int i = 0; i <= 1000; i++) {
        	list.get(list.size() / 2);
        }
        
        time = System.nanoTime() - time;
        
        System.out.println("Time required access mid el. list: " + time / TO_MS);
        
        /**************************************************************/
        
        Map<String, Double> continents = new HashMap<String, Double>();
        
        continents.put("Africa", 1_110_635_000d);
        continents.put("Americas", 972_005_000d);
        continents.put("Antartica", 0d);
        continents.put("Asia", 4298723000d);
        continents.put("Europe", 742_452_000d);
        continents.put("Oceania", 38_304_000d);
        
        double worldPopulation = 0;
        for (Double population : continents.values()) {
        	worldPopulation += population;
		}
        
        System.out.println("World population:" + worldPopulation);
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    }
}
