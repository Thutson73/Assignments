import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Unscrambling {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String inputWord;
		char outputWord[];
		String response;
		int win = 0;
		int attempts = 0;
		
		System.out.println("Player 1| Enter a word:");
		inputWord = in.nextLine();
		for (int i = 0; i < 100; i++) {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		}
		outputWord = scramble(inputWord);
		System.out.println(Arrays.toString(outputWord));
		System.out.println("Player 2| What was the original word?");
		while (win != inputWord.length()) {
			attempts++;
			win = 0;
			response = in.nextLine();
			for (int i = 0; i < inputWord.length(); i++) {
				if (inputWord.charAt(i) == response.charAt(i)) {
					win++;
				}
				else {
					break;
				}
			}
			if (win != inputWord.length()) {
				System.out.println("That was incorrect. Try again: ");
			}
		}
		if (attempts == 1) {
			System.out.println("Congratulations it took you " + attempts + " attempt to guess the word!");
		}
		else {
			System.out.println("Congratulations it took you " + attempts + " attempts to guess the word!");
		}
	}
	
	public static char[] scramble (String s) {
		Random rng = new Random();
		int r1;
		int r2;
		char word[] = new char[s.length()];
		char newWord[] = new char[s.length()];
		boolean check1[] = new boolean[s.length()];
		boolean check2[] = new boolean[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			check1[i] = false;
			check2[i] = false;
		}
		
		//Stores s into an array
		for (int i = 0; i < s.length(); i++) {
			word[i] = s.charAt(i);
		}
		
		//Scrambles the array
		for (int i = 0; i < s.length(); i++) {
			while (true){
				r1 = rng.nextInt(s.length());
				r2 = rng.nextInt(s.length());
				if (!check1[r1] && !check2[r2]) {
					newWord[r2] = word[r1];
					check1[r1] = true;
					check2[r2] = true;
					break;
				}
			}
		}
		return newWord;
	}
}
