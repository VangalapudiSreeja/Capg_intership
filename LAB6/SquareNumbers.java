package LAB6;
import java.util.*;

public class SquareNumbers {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n;
        System.out.println("Enter number of elements in array:");
        n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter all the elements:");
        for(int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
        }
	    HashMap<Integer, Integer> map = getSquares(a);
	 
	    Iterator<Integer> it = map.keySet().iterator();
	    while(it.hasNext()){
	    Integer key = it.next();
	      System.out.println(key + " : " + map.get(key));
	    }
	}
	public static HashMap getSquares(int[] array) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	 
	    for (int n: array) {
	      map.put( n, n*n);
	    }
	    return map;
	}

}
