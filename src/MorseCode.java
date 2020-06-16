import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MorseCode {
	
	private HashMap<String, String> dictionary = new HashMap<String, String>();
	private HashMap<String, String> dictionaryMorse = new HashMap<String, String>();

	//Single execution, takes input from user and prints out the translation 

	public static void main(String[] args) {
		System.out.println("Hello World !"); // Hi :)
		
		MorseCode mc = new MorseCode();
		
		mc.dictionary.put("A", ".-"); // For Alphanumerical character to Morse (A2M)
		mc.dictionary.put("B", "-...");
		mc.dictionary.put("C", "-.-.");
		mc.dictionary.put("D", "-..");
		mc.dictionary.put("E", ".");
		mc.dictionary.put("F", "..-.");
		mc.dictionary.put("G", "--.");
		mc.dictionary.put("H", "....");
		mc.dictionary.put("I", "..");
		mc.dictionary.put("J", ".---");
		mc.dictionary.put("K", "-.-");
		mc.dictionary.put("L", ".-..");
		mc.dictionary.put("M", "--");
		mc.dictionary.put("N", "-.");
		mc.dictionary.put("O", "---");
		mc.dictionary.put("P", ".--.");
		mc.dictionary.put("Q", "--.-");
		mc.dictionary.put("R", ".-.");
		mc.dictionary.put("S", "...");
		mc.dictionary.put("T", "-");
		mc.dictionary.put("U", "..-");
		mc.dictionary.put("V", "...-");
		mc.dictionary.put("W", ".--");
		mc.dictionary.put("X", "-..-");
		mc.dictionary.put("Y", "-.--");
		mc.dictionary.put("Z", "--..");
		mc.dictionary.put("1", ".----");
		mc.dictionary.put("2", "..---");
		mc.dictionary.put("3", "...--");
		mc.dictionary.put("4", "....-");
		mc.dictionary.put("5", ".....");
		mc.dictionary.put("6", "-....");
		mc.dictionary.put("7", "--...");
		mc.dictionary.put("8", "---..");
		mc.dictionary.put("9", "----.");
		mc.dictionary.put("0", "-----");
		
		mc.dictionaryMorse.put(".-", "A"); // For Morse to Alphanumerical character (M2A)
		mc.dictionaryMorse.put("-...", "B");
		mc.dictionaryMorse.put("-.-.", "C");
		mc.dictionaryMorse.put("-..", "D");
		mc.dictionaryMorse.put(".", "E");
		mc.dictionaryMorse.put("..-.", "F");
		mc.dictionaryMorse.put("--.", "G");
		mc.dictionaryMorse.put("....", "H");
		mc.dictionaryMorse.put("..", "I");
		mc.dictionaryMorse.put(".---", "J");
		mc.dictionaryMorse.put("-.-", "K");
		mc.dictionaryMorse.put(".-..", "L");
		mc.dictionaryMorse.put("--", "M");
		mc.dictionaryMorse.put("-.", "N");
		mc.dictionaryMorse.put("---", "O");
		mc.dictionaryMorse.put(".--.", "P");
		mc.dictionaryMorse.put("--.-", "Q");
		mc.dictionaryMorse.put(".-.", "R");
		mc.dictionaryMorse.put("...", "S");
		mc.dictionaryMorse.put("-", "T");
		mc.dictionaryMorse.put("..-", "U");
		mc.dictionaryMorse.put("...-", "V");
		mc.dictionaryMorse.put(".--", "W");
		mc.dictionaryMorse.put("-..-", "X");
		mc.dictionaryMorse.put("-.--", "Y");
		mc.dictionaryMorse.put("--..", "Z");
		mc.dictionaryMorse.put(".----", "1");
		mc.dictionaryMorse.put("..---", "2");
		mc.dictionaryMorse.put("...--", "3");
		mc.dictionaryMorse.put("....-", "4");
		mc.dictionaryMorse.put(".....", "5");
		mc.dictionaryMorse.put("-....", "6");
		mc.dictionaryMorse.put("--...", "7");
		mc.dictionaryMorse.put("---..", "8");
		mc.dictionaryMorse.put("----.", "9");
		mc.dictionaryMorse.put("-----", "0");
		
		Scanner scanner = new Scanner(System.in); //EXPECT USER TO GIVE CORRECT INPUTS, NO LOWERCASE AND NO EXTRA SPACES.
		System.out.println("Enter a value: ");

		String translation = ""; //To accumulate character elements
		
		//Alternatively, I can define separate A2M and M2A encode/decode functions. But this is neater for correct inputs.
		if (scanner.hasNext("-") || scanner.hasNext(".")) { //check if scanner has Morse Code
		//This is a Morse Code to Alphanumeric translation
		System.out.println("M2A Translation");
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
				translation = translation + mc.dictionaryMorse.get(tmp); //translate Morse to Alphanumerical character then add to translation
			}
			
			}

		System.out.println(translation + " M2A"); //print translation
		}
		else { //otherwise scanner has no Morse Code
			//This is an Alphanumerical to Morse Code translation
			System.out.println("A2M Translation");
			while (scanner.hasNext()) { //Run until the scanner has iterated over everything.
				if (scanner.hasNext(Pattern.compile(" "))) { //if we are coming across a whitespace
					scanner.next(); //skip it
					translation = translation + "   "; //add 3 spaces to the translation
				}
				else { //we got a legit character
				translation = translation + mc.dictionary.get(scanner.next()) + " "; //translate to Morse code then add to translation, add the space in the Morse translation.
				System.out.println(translation);
				}
			}

		System.out.println(translation + " A2M"); //print translation

		}
	}
}

//if (scanner.hasNext("[A-Z0-9]*") to check if A2M first?