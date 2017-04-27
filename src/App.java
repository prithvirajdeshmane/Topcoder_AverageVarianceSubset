
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] s = new int[] { 1, 2, 3};
		
		AverageVarianceSubset avgVarianceSubset = new AverageVarianceSubset();
		
		double avg = avgVarianceSubset.average(s, 1);
		
		System.out.println("Average of variance is: " + avg);
		
	}

}
