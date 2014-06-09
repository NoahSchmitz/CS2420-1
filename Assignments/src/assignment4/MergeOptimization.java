package assignment4;

import java.util.ArrayList;
import java.util.HashSet;

import assignment4.AlgorithmTimer.TimeComplexity;

/**
 * Optimizes the insertion threshold of merge sort.
 * The class employs the AlgorithmTimer.Process (in its not static form).
 * Essentially optimization occurs by changing the thresholding point according to a binary search method
 * minimizing time. TODO: Employ eulers first derivative method. 
 * @author wguss & cegielski
 *
 */
public class MergeOptimization implements AlgorithmTimer.Process {
	public static void main(String[] args){
		TimeComplexity complexity = TimeComplexity.BEST;
		
		AlgorithmTimer timer = 
				new AlgorithmTimer(new MergeOptimization(), 500, complexity);
		
		//Sample timing test.
		timer.time(1000, 10000, 500);
		
		//run optimization
		int lowest =0;
		int second=0;
		
		HashSet<Integer, Long> times = new HashSet<Integer,Long>();
		//Add initial data.
		
		
		//Binary search optimziation for even functions 
		do{
			
		}
		while(second != lowest);
		
		
		
	}
	
	
	
	
	//----------------------------------------------------------------------
	
	/**
	 * The list which is to be filled with case testing data.
	 */
	private ArrayList<Integer> data = new ArrayList<Integer>();
	
	
	/**
	 * Generates the data for a given n
	 */
	@Override
	public void generateData(int n, TimeComplexity complexity){
		data = RecursiveSortingUtility.generateCase(n, complexity);
	}
	
	/**
	 * Runs merge sort.
	 */
	@Override
	public void run(int n) {
		RecursiveSortingUtility.mergeSortDriver(data);
	}

	@Override
	public void overhead(int n) {
		
		
	}
}


