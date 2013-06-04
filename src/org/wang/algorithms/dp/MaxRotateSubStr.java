/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wang.algorithms.dp;

import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wang
 */
public class MaxRotateSubStr {
	
	private String str;

	public MaxRotateSubStr(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	public String getMaxSubRtStr(){
		int[] start = new int[str.length()];
		for(int i = 0; i < start.length; i++)
			start[i] = 0;
		int all = 0;
		int maxIndex = 0;
		
		for (int i = 1; i < str.length(); i++) {
			int j = 0;
			while(true){
				int st = start[j] ;
				int begin = i - st - 1;
				if(begin < 0 || str.charAt(begin) != str.charAt(i)){
					start[j] = 0;
					++j;
				}
				else {
					start[j] += 2;
					j++;
				}
				
				if(j >= start.length || st == 0)
					break;
			}
			descSort(start);
			if(start[0] > all){
				all = start[0];
				maxIndex = i;
			}
		}
		return str.substring(maxIndex - all + 1, maxIndex + 1);
	}
	
	private void descSort(int[] arr){
		Arrays.sort(arr);
		int left = 0, right = arr.length - 1;
		while( left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	public static void main(String[] args){
		try {
			String line = (new BufferedReader(new FileReader(FileDescriptor.in))).readLine();
			System.out.println((new MaxRotateSubStr(line)).getMaxSubRtStr());
		} catch (IOException ex) {
			Logger.getLogger(MaxRotateSubStr.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
