import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Fortune {

	private ArrayList<String>	fortune;
	final public String[]		STRINGS = {
			"You will get 4.0 GPA this semester.",
			"Happiness is programming.",
			"Satisfaction follows hard work",
			"Patience is vertue.",
			"You will success this year.",
			"You will find great job this year.",
			"Happiness is helping others.",
			"Practice sport is important in the life.",
			"You should openness to other cultures.",
			"You will get a high rate this year." };
	
	public void setStrings(){
		for (String str : STRINGS){
			this.fortune.add(str);
		}
		
	}
	
	public Fortune(){
		this.fortune = new ArrayList<String>();
		this.setStrings();
	}
	
	public static void main(String[] args) {
		Scanner		s;
		Random		r;
		String		input;
		int			index;
		Fortune		f;

		f = new Fortune();
		s = new Scanner(System.in);
		r = new Random();
		while (true){
			System.out.println("Fortune (Y/N) ?");
			input = s.nextLine();
			if (input.equals("N"))
				break;
			else if (input.equals("Y")){
				index = r.nextInt(10);
				System.out.println(f.fortune.get(index));
			}
		}
	}

}
