package com.tomek.test;

import java.util.Arrays;

public class FindDuplcation {
	
	public static void main(String[] args) {
		int [] tab = new int []{3,5,3,2,5,3,5};
		System.out.println("This is input array: "+ Arrays.toString(tab));
		
		FindDuplcation.findDuplicates(tab);
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
