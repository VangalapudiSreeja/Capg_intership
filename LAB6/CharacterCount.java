package LAB6;
import java.util.*;

public class CharacterCount {
	public static void main(String[] args)
	{
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the character : ");
	    String str = sc.nextLine();
	    countChars(str);
	}
	static void countChars(String inputString)
    {
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
  
        char[] strArray = inputString.toCharArray();
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else {
                charCountMap.put(c, 1);
            }
        }
        for (Map.Entry entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
