/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wang.algorithms.prog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wang
 */
public class ArrayOp {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			char[] arr = line.toCharArray();
			int leftIndex = 0, rightIndex = 0;
			while( leftIndex < arr.length){
				if( arr[leftIndex] == 'b')
					break;
				if(leftIndex < (arr.length - 1) && arr[leftIndex] == 'a' 
						&& arr[leftIndex + 1] == 'c')
					break;
				++leftIndex;
			}
			if( leftIndex == arr.length){
				System.out.println(arr);
				return;
			}
			
			if( arr[leftIndex] == 'a'){
				rightIndex = leftIndex + 2;
			}else{
				rightIndex = leftIndex + 1;
			}
			
			while(rightIndex < arr.length){
				if( arr[rightIndex] == 'b'){
					++rightIndex;
					continue;
				}
				if(rightIndex < (arr.length - 1) && arr[rightIndex] == 'a' 
						&& arr[rightIndex + 1] == 'c'){
					rightIndex += 2;
					continue;
				}
				
				char temp = arr[leftIndex];
				arr[leftIndex] = arr[rightIndex];
				arr[rightIndex] = temp;
				
				++rightIndex;
				++leftIndex;
			}
			
			arr = Arrays.copyOfRange(arr, 0, leftIndex);
			
			System.out.println(arr);
		} catch (IOException ex) {
			Logger.getLogger(ArrayOp.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
