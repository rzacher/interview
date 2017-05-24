package amazon;

import java.util.*;

// Cracking the coding interview. GetValidT9Words ie. use a phone keyboard to spell words. 
// Look up the words in a dictionary. Problem 16.20 brute force solution

public class T9Words {

	HashSet<String> dict = new HashSet<String>();
	
	public T9Words(String[] dictionary) {
		for (String word: dictionary) {
			dict.add(word);
		}
	}
	
	public ArrayList<String> getValidWords(String number) {
		if ((number == null) || (number.length() == 0)) {
			throw new IllegalArgumentException();
		}
		
		ArrayList<String> validWords = new ArrayList<String>();
		String prefix = ""; 
		int index = 0; 
		getValidWords(number, index, prefix, validWords); 
		
		
		return  validWords; 
	}
	
	private void getValidWords(String number, int index, String prefix,  ArrayList<String> words) {
		if (index == number.length())  {  // end of the line, prefix is the potential word. 
			// Look it up in the dictionary
			System.out.println(index + " " + prefix); 
			if (dict.contains(prefix)) {
				// Add to the list
				words.add(prefix);  
			}
			return; 
		}
		
		char digit = number.charAt(index); 
		// get the letters corresponding to this digit
		char[] letters = getT9Letters(digit);
		for (Character letter: letters) {
			String newprefix = prefix + letter; 
			getValidWords(number, index+1, newprefix,  words);
		}
		return; 
		
	}

	
	public static String[] getDictionaryWords() {
		String[] dictWords = {"cat", "dog", "pig", "cow", "mud", "log", "sat"};
		return dictWords; 
	}
	
	char[] getT9Letters(char digit) {
		if (!Character.isDigit(digit)){
			return null;
		}
		
		int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
		char[] letters = t9Letters[dig];
		return letters;  
	}
	
	
	char[][] t9Letters = {null, null, {'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'}, {'m','n','o'},
			{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
	
	
	public static void main(String[] args) {
		String number = "228"; 
		String[] dictWords = T9Words.getDictionaryWords(); 
		T9Words tw = new T9Words(dictWords);
		ArrayList<String> result =  tw.getValidWords(number); 
		for (String value: result) {
			System.out.println(value); 
		}
		
	}

}

