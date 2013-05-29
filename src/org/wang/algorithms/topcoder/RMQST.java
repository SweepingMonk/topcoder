/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wang.algorithms.topcoder;
import java.lang.Math;

/**
 *
 * @author wang
 */
public class RMQST extends RangeMinimumQuery{

	private int[][] aux;

	public RMQST(int length) {
		super(length);
		aux = new int[length][(int)Math.log(length) + 1];
	}
	
	@Override
	public void preprocess() {
		for (int i = 0; i < aux.length; i++) {
			aux[i][0] = data[i];
		}
		
		for (int i = 1; i < aux[0].length; i++) {
			for (int j = 0; j < aux.length; j++) {
				if(aux[i][j - 1] < aux[i + 1 << (j-1) + 1][j - 1]){
					aux[i][j] = aux[i][j - 1];
				}
				else{
					aux[i][j] = aux[i + 1 << (j-1) + 1][j - 1];
				}
			}
		}
	}

	@Override
	public int queryMinValueRange(int start, int end) {
		return 0;
	}
	
}
