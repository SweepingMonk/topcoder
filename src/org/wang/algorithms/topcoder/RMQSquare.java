/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wang.algorithms.topcoder;

/**
 *
 * @author wang
 */
public class RMQSquare extends RangeMinimumQuery{

	private int[][] aux;

	public RMQSquare(int length) {
		super(length);
		aux = new int[length][length];
	}
	
	@Override
	public void preprocess() {
		for (int i = 0; i < aux.length; i++) {
			aux[i][i] = data[i];
			for (int j = i + 1; j < aux[0].length; j++) {
				if(aux[i][j - 1] < data[j]){
					aux[i][j] = aux[i][j - 1];
				} 
				else{
					aux[i][j] = data[j];
				}
			}
			
		}
	}

	@Override
	public int queryMinValueRange(int start, int end) {
		if( start > end)
			throw new IllegalArgumentException("start should greater than end!");
		return aux[start][end];
	}
	
}
