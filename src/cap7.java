import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;


public class cap7 {

	/*ex1
	public static void main(String[] args){
		LinkedList<String> x = new LinkedList<String>();
		Queue<String> y = new PriorityQueue<String>();
		x.add("one");
		x.add("two");
		x.add("TWO");
		System.out.println(x.poll());
		System.out.println(y.poll());
	}*/
	
	/*ex2
	public static void main(String[] args){
		List<List<Integer>> table = new ArrayList<List<Integer>>();
		
		for(int i=0; i<=10; i++){
			List<Integer> row = new ArrayList<Integer>();
			for(int j=0; j<=10; j++){
				row.add(i*j);
			}
			table.add(row);
		}
		
		for(List<Integer> row : table){
			System.out.println(row);
		}
	}*/
	
	public static void main(String[] args){
		List<String> x = new ArrayList<String>();
		x.add(" x");
		x.add("xx");
		x.add("Xx");
		
		//Collections.sort(x);//mostra (< x>;<Xx>;<xx>)
		//Comparable c = Collections.reverse();
		Comparator<String> c = Collections.reverseOrder();
		Collections.sort(x,c);
		for(String s : x){
			System.out.println(s);			
		}
	}
}
