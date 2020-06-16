import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MorseToAlpha {
	
	private HashMap<String, String> dictionary = new HashMap<String, String>();

	public static void main(String[] args) {
		
		MorseToAlpha m2a = new MorseToAlpha();
		
		m2a.dictionary.put(".-", "A"); // For Morse to Alphanumerical character (M2A)
		m2a.dictionary.put("-...", "B");
		m2a.dictionary.put("-.-.", "C");
		m2a.dictionary.put("-..", "D");
		m2a.dictionary.put(".", "E");
		m2a.dictionary.put("..-.", "F");
		m2a.dictionary.put("--.", "G");
		m2a.dictionary.put("....", "H");
		m2a.dictionary.put("..", "I");
		m2a.dictionary.put(".---", "J");
		m2a.dictionary.put("-.-", "K");
		m2a.dictionary.put(".-..", "L");
		m2a.dictionary.put("--", "M");
		m2a.dictionary.put("-.", "N");
		m2a.dictionary.put("---", "O");
		m2a.dictionary.put(".--.", "P");
		m2a.dictionary.put("--.-", "Q");
		m2a.dictionary.put(".-.", "R");
		m2a.dictionary.put("...", "S");
		m2a.dictionary.put("-", "T");
		m2a.dictionary.put("..-", "U");
		m2a.dictionary.put("...-", "V");
		m2a.dictionary.put(".--", "W");
		m2a.dictionary.put("-..-", "X");
		m2a.dictionary.put("-.--", "Y");
		m2a.dictionary.put("--..", "Z");
		m2a.dictionary.put(".----", "1");
		m2a.dictionary.put("..---", "2");
		m2a.dictionary.put("...--", "3");
		m2a.dictionary.put("....-", "4");
		m2a.dictionary.put(".....", "5");
		m2a.dictionary.put("-....", "6");
		m2a.dictionary.put("--...", "7");
		m2a.dictionary.put("---..", "8");
		m2a.dictionary.put("----.", "9");
		m2a.dictionary.put("-----", "0");

		Scanner scanner = new Scanner(System.in); //EXPECT USER TO GIVE CORRECT INPUTS, NO LOWERCASE AND NO EXTRA SPACES.
		System.out.println("Enter a value: ");
		String translation = ""; //To accumulate character elements
		
		while (scanner.hasNext()) { //Run until the scanner has iterated over everything.
			if (scanner.hasNext(Pattern.compile("   "))) { //if 3 consecutive spaces were detected
				scanner.next(); //skip all of them using 3 nexts
				scanner.next();
				scanner.next();
				translation = translation + " ";
				
			}
			else if (scanner.hasNext(Pattern.compile(" "))) scanner.next(); //single space ahead, should be safe since the first if failed in that case
			else { //otherwise, we got legit characters
				String tmp = ""; //since this is M2A translation, we need to accumulate a bunch of -'s and .'s for each letter
				while(scanner.hasNext("-") || scanner.hasNext(".")) { //until the next space, accumulate the character elements
					tmp = tmp + scanner.next();
				}
				assert(tmp.length() < 6); //Morse characters cannot exceed 5 per Alphanumerical character
				translation = translation + m2a.dictionary.get(tmp); //translate Morse to Alphanumerical character then add to translation
			}
			
			}

		System.out.println(translation); //print translation
	}

}
