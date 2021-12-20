package recursividad;

import java.util.ArrayList;
import java.util.Collections;

public class Recursion {
	

	    /**
	     * Generic Merge Sort using id number
	     *
	     * @param list list to be sorted
	     * @param <T>  type of the objects to sort
	     * @return sorted list
	     */
	    public static <C extends Comparation<C>> ArrayList<C> mergeSortNum(ArrayList<C> list) {
	        if (list.size() == 1) return list;
	        else {
	            ArrayList<C> listLeft = new ArrayList<C>(list.subList(0, list.size() / 2));
	            ArrayList<C> listRight = new ArrayList<C>(list.subList(list.size() / 2, list.size()));

	            listLeft = mergeSortNum(listLeft);
	            listRight = mergeSortNum(listRight);

	            return mergeNum(listLeft, listRight);
	        }


	    }

	    /**
	     * Generic Merge function to merge and sort the divided lists (using id)
	     *
	     * @param a   left list
	     * @param b   right list
	     * @param <T> type of the objects in the list
	     * @return merged (and sorted) list
	     */
	    public static <C extends Comparation<C>> ArrayList<C> mergeNum(ArrayList<C> a, ArrayList<C> b) {
	        ArrayList<C> c = new ArrayList<>();
	        while (!a.isEmpty() && !b.isEmpty()) {
	            if (a.get(0).compareNum(b.get(0))) {
	                c.add(b.get(0));
	                b.remove(0);
	            } else {
	                c.add(a.get(0));
	                a.remove(0);
	            }
	        }
	        //At this point either a or b is empty
	        while (!a.isEmpty()) {
	            c.add(a.get(0));
	            a.remove(0);
	        }
	        while ((!b.isEmpty())) {
	            c.add(b.get(0));
	            b.remove(0);
	        }
	        return c;
	    }

	 
	    

	}
	
	


