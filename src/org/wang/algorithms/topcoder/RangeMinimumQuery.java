/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wang.algorithms.topcoder;
import java.util.Random;

/**
 *
 * @author wang
 */
public abstract class RangeMinimumQuery {
	
	protected int[] data;
	
	private Random rand;
	
	RangeMinimumQuery(int length){
		data = new int[length];
		rand = new Random(System.currentTimeMillis());
		//使用随机函数填充data数组
		initDataArray();
	}
	
	private void initDataArray(){
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100);
		}
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			sb.append(data[i]);
			sb.append(" ");
		}
		sb.append("\n");
		return sb.toString();
	}
	
	public abstract void preprocess();
	
	public abstract int queryMinValueRange(int start, int end);
}
