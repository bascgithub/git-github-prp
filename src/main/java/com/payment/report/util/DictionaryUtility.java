package com.payment.report.util;

public interface DictionaryUtility {

	public boolean isEmpty();
	
	public int size();
	
	public boolean addWord(Word word);	
	
	public Word retrieveWord(String wordKey);
	
	public WordIterator retrieveAllWords();
	
	public boolean editWord(Word word);	
	
	public boolean removeWord(String wordKey);
	
    public boolean containsWordKey(String wordKey);
    
    public boolean containsWordValue(String wordValue);
	
	//public String findSynonym(String word);

}
