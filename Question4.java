import java.util.ArrayList;
import java.util.Scanner;


public class DnaSequence {

	private ArrayList<String> codons;
	
	public DnaSequence(){
		this.codons = new ArrayList<String>();
	}

	public void extractCodons(String str){
		for (int i = 0; i < str.length() - 2; i += 3){
			this.codons.add(str.substring(i, i + 3));
		}
	}
	
	public static void main(String[] args) {
		Scanner		s;
		String		input;
		DnaSequence	ds;

		s = new Scanner(System.in);
		ds = new DnaSequence();
		System.out.println("enter a DNA sequence:");
		input = s.nextLine();
		ds.extractCodons(input);
		System.out.println(ds.codons);
	}

}
