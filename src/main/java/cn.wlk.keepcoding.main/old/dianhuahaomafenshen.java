import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class dianhuahaomafenshen{
    static String[] nums = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
    
    public static void main(String[] asd){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String str ;
        ArrayList<Integer> arrs=new ArrayList<>();
        for(int i = 0;i<n;i++){
            str = scanner.nextLine();
            arrs = deal(str);
            Collections.sort(arrs);
            for(int k:arrs)
                System.out.print(k);
            System.out.println();
            
        }
        
    }
    
    
    public static ArrayList<Integer> deal(String str) {
    	str = str.toUpperCase();
    	char[] chars = str.toCharArray();
    	int[] chararr;	
    	chararr = new int[128];
    	for(int i = 0;i<chars.length;i++) {
    		chararr[chars[i]]++;
    	}
    	ArrayList<Integer> result  = new ArrayList<>();
    	int nums[] = new int[10];
    	nums[0] = chararr['Z'];
    	nums[4] = chararr['U'];
    	nums[2] = chararr['W'];
    	nums[6] = chararr['X'];
    	nums[7] = chararr['S']-nums[6];
    	nums[5] = chararr['V']-nums[7];
    	nums[8] = chararr['G'];
    	nums[3] = chararr['H']-nums[8];
    	nums[1] = chararr['O']-nums[0]-nums[4]-nums[2];
    	nums[9] = chararr['I']-nums[5]-nums[6]-nums[8];
    	
    	
    	for(int i = 0;i<10;i++){
//    		System.out.println(i+" DEBUG:"+nums[i]);
    		if(nums[i]!=0) {
    			for(int j = 0;j<nums[i];j++)
    				result.add((i+2)%10);
    			
    		}
    	}
    	return result;
    }
    
    
    public static ArrayList find(String str){
        int minlen = 3;
        ArrayList<Integer> result=new ArrayList();
        int xx = 0;
        
        for(int i = 0;i<str.length();){
            for(int j = minlen;j<=5;j++) {
               xx = match(str.substring(i,i+j)); 
                if(xx!=-1) {
                    result.add((xx+2)%10);
                    i+=j;
                    break;
                }
                
            }
        }
        return result;
        
    }
    public static int match(String numstr){
        for(int i = 0;i<=9;i++){
            if(nums[i].equals(numstr))
                return i;
        }
        return -1;
    }


}