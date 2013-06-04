/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wang.algorithms.prog;

/**
 *
 * @author wang
 */
public class ClockwiseFill implements MatrixFiller{

	private int nextRow = 0;
	
	private int nextCol = 0;
	
	private int rows;
	
	private int cols;
	
	@Override
	public void fill(Matrix m) {
		int order = m.getRows();	
		int k = 1;
		for(int i = 0; i < order/2; i++){
			for( int j = i; j < order - i - 1; j++){
				m.setCell(i, j, k);
				++k;
			}
			for( int j = i; j < order - i - 1; j++){
				m.setCell(j, order - i - 1, k);
				++k;
			}
			for( int j = order - i - 1; j > i; j--){
				m.setCell(order - i - 1, j, k);
				++k;
			}
			for( int j = order - i - 1; j > i; j--){
				m.setCell(j, i, k);
				++k;
			}
		}
		
		if((order&0x1) == 1){
			m.setCell(order/2, order/2, k);
		}
	}
	
}
