import java.util.Random;


public class DailyTemperature {
	private int			hottestDayIndex;
	private int			coldestDayIndex;
	private double		hottestDay;
	private double		coldestDay;
	private double[]	temperatures;
	final public int [] MONTHS_LENGTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public DailyTemperature(){
		double	randTemp;
		this.temperatures = new double[365];
		Random r = new Random();
		for (int i = 0; i < 365; i++){
			 randTemp = r.nextDouble() * 70.0 - 20.0;
			 this.temperatures[i] = Double.parseDouble(String.format("%.2f", randTemp));
		}
	}
	
	public void getHottestAndColdestDay(double [] arr){
		this.hottestDayIndex = 0;
		this.coldestDayIndex = 0;
		this.hottestDay = arr[0];
		this.coldestDay = arr[0];
		for (int i = 1; i < arr.length; i++){
			if (this.hottestDay < arr[i]){
				this.hottestDay = arr[i];
				this.hottestDayIndex = i + 1;
			}
			else if (this.coldestDay > arr[i]){
				this.coldestDay = arr[i];
				this.coldestDayIndex = i + 1;
			}
		}
	}
	
	public double getAverage(double [] arr, int len){
		double sum;
		
		sum = .0;
		for (int i = 0; i < len; i++){
			sum += arr[i];
		}
		return Double.parseDouble(String.format("%.2f", sum / len));
	}
	
	public double [] getSubArray(double [] arr, int start, int end){
		double[]	subArray;
		int			j;
		
		subArray = new double[end - start];
		j = 0;
		for (int i = start; i < end; i++){
			subArray[j] = arr[i];
			j++;
		}
		return subArray;
	}
	
	public double [] getAverageTempOfEachMonth(){
		double [] avgs;
		double [] monthTemp;
		int start;
		
		start = 0;
		avgs = new double[12];
		for (int i = 0; i < 12; i++){
			monthTemp = getSubArray(this.temperatures, start, start + this.MONTHS_LENGTHS[i]);
			avgs[i] = getAverage(monthTemp,  this.MONTHS_LENGTHS[i]);
			start +=  this.MONTHS_LENGTHS[i];
		}
		return avgs;
	}
	
	public double [] getTempDifferenceOfEachMonth(){
		double [] diff;
		double [] monthTemp;
		int start;
		
		start = 0;
		diff = new double[12];
		for (int i = 0; i < 12; i++){
			monthTemp = getSubArray(this.temperatures, start, start + this.MONTHS_LENGTHS[i]);
			getHottestAndColdestDay(monthTemp);
			diff[i] = Double.parseDouble(String.format("%.2f", this.hottestDay - this.coldestDay));
			start +=  this.MONTHS_LENGTHS[i];
		}
		return diff;
	}
	
	public double getTempOfDay(int day, int month){
		int index;

		if (day < 1 || day > 31 || month < 1 || month > 12){
			System.out.println("invalid input values.");
			index = -day;
		}else{
			index = 0;
			for (int i = 0; i < month - 1; i++){
				index += MONTHS_LENGTHS[i];
			}
		}
		return temperatures[index + day - 1];
	}
	
	public static void main(String[] args) {
 		DailyTemperature dt = new DailyTemperature();
		dt.getHottestAndColdestDay(dt.temperatures);
		System.out.println("-----------------------------------------------");
		System.out.println("the hottest day is the day " + dt.hottestDayIndex + " of year \n the coldest day is the day " + dt.coldestDayIndex + " of year");
		for (int i = 0; i < 12; i++){
			System.out.println("the average temperature of month " + (i + 1) + "--------------------");
			System.out.println(dt.getAverageTempOfEachMonth()[i]);
			System.out.println("the difference between the hottest and coldest days of month " + (i + 1) + "---------");
			System.out.println(dt.getTempDifferenceOfEachMonth()[i]);
		}
		System.out.println("the temperature of any given day-----------------------------------------------");
		System.out.println(dt.getTempOfDay(9, 7));
	}

}
