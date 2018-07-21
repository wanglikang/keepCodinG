
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Scanner;
public class juzifanzhuan {
	    public static void main(String[] sd){
	        Scanner scanner = new Scanner(System.in);
	        String line = scanner.nextLine();
	        String[] words = line.split(" ");
	        for(int i = words.length-1;i>0;i--){
	            System.out.print(words[i]+" ");
	        }
	            System.out.print(words[0]+" ");
	      
	    }
	}