	/**
	* File: Problem Set 5 - Text Analyzer
	* Author: Leo
	* Date Created: May 17, 2026
	* Date Last Modified: May 28, 2026
	*/
	
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class ProblemSet {
	public static void main(String args[]) {
	    Scanner input = new Scanner(System.in);
	    int characters = 0;
	    int vowels = 0;
	    int words = 0;
	    int spaces = 0;
	    int sentenceNum = 0;
	    String cleanedWords = "";
	    
	    System.out.println("Welcome to the Text Analyzer.");
	    System.out.println("Please enter a sentence or paragraph:\n");
	    
	    String sentence = input.nextLine();
	    
	    characters = sentence.length();
	    sentence = sentence.toLowerCase();
	    
	    //loop through input
	    for (int i = 0; i < sentence.length(); i++) {
	        char currentChar = sentence.charAt(i);
	        
	        //checks how many spaces there are and adds the spaces to variable with all words
	        if (currentChar == ' ') {
	            spaces++;
	            cleanedWords += currentChar;
	        }
	        
	        //checks if character is valid and adds it to the variable
	        else if ((currentChar >= 'A' && currentChar <= 'Z') || (currentChar >= 'a' && currentChar <= 'z')) {
	            cleanedWords += currentChar;
	        }
	        
	        //checks amount of vowels
	        if (sentence.charAt(i) == 'a' || sentence.charAt(i) == 'e' || sentence.charAt(i) == 'i' || sentence.charAt(i) == 'o' || sentence.charAt(i) == 'u') {
	        vowels++;
	        }
	        
	        //checks amount of sentence ending symbols there are
	        if (sentence.charAt(i) == '!' || sentence.charAt(i) == '?' || sentence.charAt(i) == '.') {
	            sentenceNum++;
	        }
	    }
	    
	    //splits the variable containing all the words and stores in an array
	    String[] strArr = cleanedWords.split(" ");
	    
	    //adds ignored words to an array list
	    ArrayList<String> xWords = new ArrayList<String>();
	    xWords.add("is");
	    xWords.add("and");
	    xWords.add("an");
	    xWords.add("a");
	    xWords.add("the");
	    
	    //hashmap to store all word frequencies
	    HashMap<String, Integer> wordsHash = new HashMap<String, Integer>();    
	    int wordsUnique = 0;
	    
	    for (int i = 0; i < strArr.length; i++) {
	        //checks if word is valid
	        if (!strArr[i].isBlank()) {
	        words++;
	            
	            //checks if word is ignored
	            if(!(xWords.contains(strArr[i]))) {
	                if (wordsHash.containsKey(strArr[i])) { //checks if word is already in hashmap
	                    wordsHash.put(strArr[i],wordsHash.get(strArr[i]) + 1); //if it is, add 1 to the value
	                }
	                else { //if the word is not in the hashmap, add it
	                    wordsHash.put(strArr[i],1);
	                    wordsUnique++;
	                }
	            }
	        }
	    }
	    
	    System.out.println("\nTotal Characters: " + characters);
	    System.out.println("Words: " + words);
	    System.out.println("Vowels: " + vowels);
	    System.out.println("Spaces: " + spaces);
	    System.out.println("\nWord Frequency: \n");
	    
	    //prints word frequencies
	    for (String i: wordsHash.keySet()) {
	        System.out.println(i + " - " + wordsHash.get(i));
	    }
	    
	    ArrayList<String> wordLongest = new ArrayList<String>();
	    String longest = "";
	    
	    //checks for the longest word
	    for (String i: wordsHash.keySet()) {
	        if (wordLongest.contains(i)) {
	        }
	        else if (i.length() > longest.length()) { //checks for new longest words
	            wordLongest.clear();
	            longest = i;
	            wordLongest.add(i);
	        }
	        else if (i.length() == longest.length()) { //checks for words of the same length as the current longest word
	            wordLongest.add(i);
	        }
	    }
	    System.out.print("\nLongest Word(s): ");
	    for (int i = 0; i < wordLongest.size(); i++) {
	        System.out.print(wordLongest.get(i));
	        
	        //if the word is not the last word in the array list, add a comma
	        if (i < wordLongest.size() - 1) {
	            System.out.print(", ");
	        }
	    }
	    
	    ArrayList<String> wordShortest = new ArrayList<String>();
	    //set the shortest word to a long word to prevent printing empty string as the shortest word
	    String shortest = "Pneumonoultramicroscopicsilicovolcanoconiosis";
	    
	    for (String i: wordsHash.keySet()) {
	        //checks for shortest word
	        if (wordShortest.contains(i)) {
	        }
	        else if (i.length() < shortest.length()) { //checks for new shortest words
	            wordShortest.clear();
	            shortest = i;
	            wordShortest.add(i);
	        }
	        else if (i.length() == shortest.length()) {
	            wordShortest.add(i);
	        }
	    }
	    System.out.print("\nShortest Word(s): ");
	    for (int i = 0; i < wordShortest.size(); i++) {
	        System.out.print(wordShortest.get(i));
	        
	        if (i < wordShortest.size() - 1) {
	            System.out.print(", ");
	        }
	    }
	    
	    //gets the total amount of letters by multiplying amount of letters in a word by the amount of words
	    int letters = 0;
	    for (String i: wordsHash.keySet()) {
	        letters += (i.length() * wordsHash.get(i));
	    }
	    System.out.println("\nAverage Word Length: " + (0.0 + letters) / words);
	    System.out.println("Number of Sentences: " + sentenceNum);
	    System.out.println("Unique Words: " + wordsUnique);
	}
}
