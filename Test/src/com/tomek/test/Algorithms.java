package com.tomek.test;

import java.util.Arrays;

public class Algorithms {
	public static void main(String[] args) {
		int [] tab = new int []{1,4,7,10,13,34,67,98};
		System.out.println("This is input array: "+ Arrays.toString(tab));
		
		//FindDuplcation.findDuplicates(tab);
		
		//System.out.println();
		Algorithms.binarySearch(tab, 2);
		
	}
	
	public static boolean binarySearch(int[] array,int value){
		int lowIdx = 0;
		int highIdx = array.length -1;
		
		while(lowIdx<=highIdx){
			int midIdx = (lowIdx + highIdx)/2;
			int midVal = array[midIdx];
			if(value > midVal){
				lowIdx = midIdx + 1;
			}else if(value<midVal){
				highIdx = midIdx - 1;
			}else{
				System.out.println("Found value");
				return true;
			}
		}
		System.out.println("Did not found value");
		return false;
		
	}
	
	
	public static void findDuplicates(int [] inTab) {	
		int [] duplicateIdx = new int [10];
		int k = 0;
		boolean skipIdx = false;
		
		for (int i=0;i<inTab.length;i++){
			int x = inTab[i];
			for(int l=0;l<k;l++){
				if(i==duplicateIdx[l]){
					skipIdx = true;
				}
			}
			if(skipIdx) continue;
			for (int j=0;j<inTab.length;j++){
				if(j!=i){
					if(x == inTab[j])
					{
						System.out.println("Found duplicate of "+x+" from index "+i+" on index "+j);
						duplicateIdx[k] = j;
						k++;
					}
				}
			}
		}
	}

}
