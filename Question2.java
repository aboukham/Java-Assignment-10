import java.util.Random;
import java.util.Scanner;


public class StandardDeviation {
	private static final double MAX = 1000.0;
	private static final double MIN = 500.0;
	private double [] 			arr;

	public StandardDeviation(double [] array){
		this.arr = array;
	}
	
	public double arrayAverage(){
		double sum;
		
		sum = .0;
		for (int i = 0; i < this.arr.length; i++){
			sum += this.arr[i];
		}
		return sum / this.arr.length;
	}
	
	public double standardDeviationCalcul(){
		double avg;
		double sum;

		sum = .0;
		avg = this.arrayAverage();
		for (int i = 0; i < this.arr.length; i++){
			sum += Math.pow(this.arr[i] - avg, 2);
		}
		return Math.sqrt(sum / this.arr.length);
	}
	
	public static void main(String[] args) {
		Scanner		s;
		Random		r;
		int			size;
		double[]	array;
		StandardDeviation sd;
		
		s = new Scanner(System.in);
		r = new Random();
		System.out.println("enter a number");
		size = s.nextInt();
		array = new double[size];
		for (int i = 0; i < size; i++){
			array[i] = r.nextDouble() * (MAX - MIN) + MIN;
			System.out.println(array[i]);
		}
		System.out.println("-------------------------");
		sd = new StandardDeviation(array);
		System.out.println(sd.standardDeviationCalcul());
	}

}
