import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AlphaToMorse {
	
	private HashMap<String, String> dictionary = new HashMap<String, String>();
	
	public static void main(String[] args) {
		
		AlphaToMorse a2m = new AlphaToMorse();
		
		a2m.dictionary.put("A", ".-"); // For Alphanumerical character to Morse (A2M)
		a2m.dictionary.put("B", "-...");
		a2m.dictionary.put("C", "-.-.");
		a2m.dictionary.put("D", "-..");
		a2m.dictionary.put("E", ".");
		a2m.dictionary.put("F", "..-.");
		a2m.dictionary.put("G", "--.");
		a2m.dictionary.put("H", "....");
		a2m.dictionary.put("I", "..");
		a2m.dictionary.put("J", ".---");
		a2m.dictionary.put("K", "-.-");
		a2m.dictionary.put("L", ".-..");
		a2m.dictionary.put("M", "--");
		a2m.dictionary.put("N", "-.");
		a2m.dictionary.put("O", "---");
		a2m.dictionary.put("P", ".--.");
		a2m.dictionary.put("Q", "--.-");
		a2m.dictionary.put("R", ".-.");
		a2m.dictionary.put("S", "...");
		a2m.dictionary.put("T", "-");
		a2m.dictionary.put("U", "..-");
		a2m.dictionary.put("V", "...-");
		a2m.dictionary.put("W", ".--");
		a2m.dictionary.put("X", "-..-");
		a2m.dictionary.put("Y", "-.--");
		a2m.dictionary.put("Z", "--..");
		a2m.dictionary.put("1", ".----");
		a2m.dictionary.put("2", "..---");
		a2m.dictionary.put("3", "...--");
		a2m.dictionary.put("4", "....-");
		a2m.dictionary.put("5", ".....");
		a2m.dictionary.put("6", "-....");
		a2m.dictionary.put("7", "--...");
		a2m.dictionary.put("8", "---..");
		a2m.dictionary.put("9", "----.");
		a2m.dictionary.put("0", "-----");
		
		Scanner scanner = new Scanner(System.in); //EXPECT USER TO GIVE CORRECT INPUTS, NO LOWERCASE AND NO EXTRA SPACES.
		System.out.println("Enter a value: ");
		String translation = ""; //To accumulate character elements
		
		while (scanner.hasNext()) { //Run until the scanner has iterated over everything.
			if (scanner.hasNext(Pattern.compile(" "))) { //if we are coming across a whitespace
				scanner.next(); //skip it
				translation = translation + "   "; //add 3 spaces to the translation
			}
			else { //we got a legit character
			translation = translation + a2m.dictionary.get(scanner.next()) + " "; //translate to Morse code then add to translation, add the space in the Morse translation.
			}
		}
		System.out.println(translation);
	}

}
