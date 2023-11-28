package com.fmm.jk_lib.thread.forkjoin.sum;


import com.fmm.jk_lib.thread.tools.SleepTools;

/**
 * 单线程执行累加
 */
public class SumNormal {
	
	public static void main(String[] args) {
	    int count = 0;
	    int[] src = MakeArray.makeArray();

	    long start = System.currentTimeMillis();
	    for(int i= 0;i<src.length;i++){
			SleepTools.ms(1);
	    	count = count + src[i];
	    }
	    System.out.println("The count is "+count
	            +" spend time:"+(System.currentTimeMillis()-start)+"ms");		
	}

}
