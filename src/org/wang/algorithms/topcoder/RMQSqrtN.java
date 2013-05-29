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
public class RMQSqrtN extends RangeMinimumQuery{
	private int[] aux;

	private int segLength;
	
	public RMQSqrtN(int length) {
		super(length);
		segLength = (int)Math.sqrt(length);
		aux = new int[ segLength + 1];
		for(int i = 0; i < aux.length; i++){
			aux[i] = Integer.MAX_VALUE;
		}
	}
	
	
	@Override
	public void preprocess() {
		//预处理时间复杂度为O(n)
		for (int i = 0; i < data.length; i++) {
			int index = i/segLength;
			if(aux[index] > data[i]){
				aux[index] = data[i];
			}
		}
	}

	@Override
	public int queryMinValueRange(int start, int end) {
		int min = data[start];
		int startIndex = start/segLength;
		int endIndex = end/segLength;
		
		//查询时间复杂度为O(sqrtN)
		if(startIndex == endIndex || startIndex == endIndex -1){
			for(int i = start; i <= end; i++){
				if(data[i] < min)
					min = data[i];
			}
		}
		else {
			for( int i = startIndex + 1; i < endIndex; i++){
				if(aux[i] < min)
					min = aux[i];
			}
			
			for(int i = start; i <= ( startIndex + 1 ) * segLength; i++){
				if( data[i] < min )
					min = data[i];
			}
			
			for(int i = endIndex * segLength + 1; i <= end; i++){
				if( data[i] < min )
					min = data[i];
			}
		}
		return min;
	}
}
