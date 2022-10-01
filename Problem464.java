/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
//import java.Collectio.*;

class GFG {
    static int lt,rt;
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int maxl=0;
		int a[][]=new int[m][n];
		for(int i=0;i<m;i++)
		{
		    for(int j=0;j<n;j++)
		    {
		        int g=sc.nextInt();
		        if(g==0)
		        a[i][j]=-1;
		        else
		        a[i][j]=1;
		    }
		}
		for(int i=0;i<m;i++)
		{
		    int p[]=new int[n];
		    for(int j=i;j<m;j++)
		    {
		        for(int k=0;k<n;k++)
		        {
		            p[k]+=a[j][k];
		        }
		        boolean flag=sumzero(p,n);
		        int ele=(j-i+1)*(rt-lt+1);
		        if(flag && ele>maxl)
		        {
		            maxl=ele;
		        }
		    }
		}
		System.out.println(maxl);
	}
	public static boolean sumzero(int arr[],int n)
	{
	    int sum=0,max=0;
	    HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	    for(int i=0;i<n;i++)
	    {
	        sum+=arr[i];
	        if(arr[i]==0 && max==0)
	        {max=1;
	            lt=i;rt=i;
	        }
	        if(sum==0)
	        {
	            if(max<i+1)
	            {
	                max=i+1;
	                lt=0;
	                rt=i;
	            }
	           // max=Math.max(max,i+1);
	        }
	        if(!hm.containsKey(sum))
	        {
	            hm.put(sum,i);
	            
	        }
	        else{
	            int old=max;
	        int h=hm.get(sum);
	        max=Math.max(max,i-h);
	        if(old<max)
	        {
	            lt=h+1;
	            rt=i;
	        }
	        }
	    }
	    return max!=0;
	}
}