/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wang.algorithms.topcoder;

import java.util.Scanner;

/**
 *
 * @author wang
 */
public class TopCoder {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		RangeMinimumQuery rmq = new RMQSquare(20);
		rmq.preprocess();
		System.out.println(rmq.toString());
		System.out.println("Please input the start index and the end index!");
		int start = 0, end = 0;
		Scanner scanner = new Scanner(System.in);
		start = scanner.nextInt();
		end = scanner.nextInt();
		System.out.println("start:" + start + ", end:" + end);
		System.out.println("The min value between start and end is " + rmq.queryMinValueRange(start, end));
	}
}
