import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	      Scanner in=new Scanner(System.in);
	     
	     int t=in.nextInt();
	   
	     while(t-->0){
	        
	         int size=in.nextInt();
	         int[]arr=new int[size];
	         
	         for(int i=0;i<size;i++){
	             arr[i]=in.nextInt();
	             
	         }
	         
	         call(0,arr.length,arr);
	         
	           for(int i=0;i<size;i++){
	           System.out.print(arr[i]+" ");
	       }
	       System.out.println("");
	       
	 
	 }
	 }
	 public static void call(int i,int n,int []arr){
	     if(i>=n/2)
	     return ;
	     int temp=arr[i];
	     arr[i]=arr[n-i-1];
	     arr[n-i-1]=temp;
	     
	     call(i+1,n,arr);
	 }
	 
}