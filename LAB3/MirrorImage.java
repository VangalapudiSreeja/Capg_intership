package LAB3;
import java.util.Scanner;

public class MirrorImage {
	public String getImage(String str)
    {
           StringBuffer sbr = new StringBuffer(str);
           sbr.append('|');
           StringBuffer sb = new StringBuffer(str);
           sb.reverse();
           sbr.append(sb);
           return sbr.toString();
    }
    public static void main(String[] ar)
    {
    	MirrorImage m = new MirrorImage();
           Scanner s = new Scanner(System.in);
           System.out.println("Enter a String");
           String str = s.next();
           System.out.println(m.getImage(str));
    }

}
