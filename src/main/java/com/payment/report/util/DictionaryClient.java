package com.payment.report.util;
import com.payment.report.util.Word;
public class DictionaryClient {
	
	public static void main(String[] args) {
		
		DictionaryImpl dicImpl = new DictionaryImpl();
		
		// ### 1
		dicImpl.addWord(new Word());
		
		Word secondWord = new Word();
		secondWord.setKey("hi");
		String[] value = new String[1];
		value[0] = "welcome";
		secondWord.setValue(value);
		dicImpl.addWord(secondWord);
		
		// ### 2
		System.out.println("dicImpl count  " + dicImpl.count);
		
		// ### 3
		System.out.println("dicImpl isEmplty()  " + dicImpl.isEmpty());
		
		System.out.println("dicImpl size()  " + dicImpl.count);
		
		// ### 4
		System.out.println("dicImpl retrieveWord()  " + dicImpl.retrieveWord("wk"));
		
		// ### 5
		WordIterator wi = dicImpl.retrieveAllWords();
		while(wi.hasNextWord()) {
		 Word word1 = (Word)wi.nextWord();
		 String [] val = word1.getValue();
		 System.out.println("dicImpl retrieveAllWords()  " + word1.getKey() + " "+val[0]);
		}
		
		// ### 6
		value[0] = "welcome to the world";		
		secondWord.setValue(value);
		dicImpl.editWord(secondWord);
		//System.out.println("dicImpl retrieveAllWords()" + dicImpl.retrieveAllWords());
	}

}
