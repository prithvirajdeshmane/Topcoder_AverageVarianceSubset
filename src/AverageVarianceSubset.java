import java.util.ArrayList;
import java.util.Collections;

public class AverageVarianceSubset {

	public AverageVarianceSubset() {

	}

	public double average(int[] s, int R) {
		
		//ArrayList<ArrayList<Integer>> collectionOfSubsets = createSubsets(s);
		ArrayList<ArrayList<Integer>> collectionOfSubsets = createSubsets(s, R);

		//System.out.println("Subsets within Range " + collectionOfSubsets);
		
		ArrayList<Double> variance = calculateVariance(collectionOfSubsets);
		
		return (calculateAverageOfVariance(variance));
	}
	
	private double calculateAverageOfVariance(ArrayList<Double> variance) {
		
		double average = 0;
		
		for (Double var : variance) {
			average += var;
		}
		
		average /= variance.size();
		
		return average;
	}
	
	private ArrayList<Double> calculateVariance(ArrayList<ArrayList<Integer>> collectionOfSubsets) {
		
		ArrayList<Double> variance = new ArrayList<Double>();
		
		for (ArrayList<Integer> subset : collectionOfSubsets) {
			
			double mean = calculateMean(subset);
			
			//System.out.println("Mean " + mean);
			
			ArrayList<Double> squaresOfDifferences = new ArrayList<Double>();
			squaresOfDifferences = calculateSquaresOfDifferences(squaresOfDifferences, subset, mean);
			
			//System.out.println("SquaresDiff " + squaresOfDifferences);
			
			double varianceOfSubset = calculateSubsetVariance(squaresOfDifferences);
			
			variance.add(varianceOfSubset);
		}
		
		return variance;
	}
	
	private double calculateSubsetVariance(ArrayList<Double> squaresOfDifferences) {
		
		double variance = 0;
		
		for (Double squareOfDifference : squaresOfDifferences) {
			variance += squareOfDifference;
		}
		
		variance = variance / squaresOfDifferences.size();
		
		return variance;
	}
	
	private ArrayList<Double> calculateSquaresOfDifferences(
			ArrayList<Double> squaresOfDifferences, ArrayList<Integer> subset, double mean) {
		
		//ArrayList<Double> squaresOfDifferences = new ArrayList<Double>();
		
		for (Integer x : subset) {
			
			double y = Math.pow((x - mean), 2);
			
			squaresOfDifferences.add(y);
		}
				
		return squaresOfDifferences;
	}
	
	private double calculateMean(ArrayList<Integer> subset) { 
		double mean = 0;
		
		int size = subset.size();
		
		for (Integer n : subset) {
			mean += n;
		}
		
		mean = mean / size;
		return mean;
	}

	private ArrayList<ArrayList<Integer>> createSubsets(int[] s) {

		ArrayList<ArrayList<Integer>> collectionOfSubsets = new ArrayList<ArrayList<Integer>>();

		for (int x : s) {

			if (!collectionOfSubsets.isEmpty()) {

				int currentSize = collectionOfSubsets.size();

				for (int i = 0; i < currentSize; i++) {
					ArrayList<Integer> newSubset = new ArrayList<Integer>();
					newSubset.addAll(collectionOfSubsets.get(i));
					newSubset.add(x);
					collectionOfSubsets.add(newSubset);
				}
			}

			ArrayList<Integer> newSubset = new ArrayList<Integer>();
			newSubset.add(x);
			collectionOfSubsets.add(newSubset);
		}

		return collectionOfSubsets;
	}

	private ArrayList<ArrayList<Integer>> createSubsets(int[] s, int R) {

		ArrayList<ArrayList<Integer>> collectionOfSubsets = new ArrayList<ArrayList<Integer>>();

		for (int x : s) {

			if (!collectionOfSubsets.isEmpty()) {

				int currentSize = collectionOfSubsets.size();

				for (int i = 0; i < currentSize; i++) {
					ArrayList<Integer> newSubset = new ArrayList<Integer>();
					newSubset.addAll(collectionOfSubsets.get(i));
					newSubset.add(x);
					
					if(newSubset.get(newSubset.size()-1) - newSubset.get(0) <= R) {
						collectionOfSubsets.add(newSubset);
					}
				}
			}

			ArrayList<Integer> newSubset = new ArrayList<Integer>();
			newSubset.add(x);
			collectionOfSubsets.add(newSubset);
		}

		return collectionOfSubsets;
	}

}
