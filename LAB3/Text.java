package LAB3;

import java.util.*;
import java.io.*;

public class Text {
	public static void main(String args[])
    {
                int nl=1,nw=0, n=0;           
                char ch;
                Scanner scr=new Scanner(System.in);
                System.out.print("\nEnter text : ");
                String str=scr.nextLine();
                for(int i=0;i<str.length();i++)
                {
                            ch=str.charAt(i);
                            if(ch=='\n'||ch=='.')
                            nl++;
                            else if(ch==' ')
                            nw++;
                            else n++;
                                                               
                }
                System.out.println("\nNumber of lines : "+nl);
                System.out.println("\nNumber of words : "+(nl+nw));
                System.out.println("\nNumber of characters : "+n);
               

    }
}
