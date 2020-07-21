package com.payment.report.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DictionaryImpl implements DictionaryUtility,Serializable{
    int capacity = 20;
    int incremental = 10;
    float threshold = 0.7f;
    int currentIndex = 0;
    int count = 0;
    Word[] words= new Word[capacity];
	DictionaryImpl(){
		
	}
	
    DictionaryImpl(int initialCapacity){
		this.capacity = initialCapacity;
	}
    public boolean isEmpty() {    	
    	if(count == 0)
    	    return true;
    	else
    	    return false;
    }
	
	public int size() {
		return count;
	}
	
    public boolean addWord(Word word) {
    	boolean addWordFlag = false;
    	if(count < capacity && currentIndex < capacity) {
    		words[currentIndex++] = word;
    		count = count+1;
    		addWordFlag = true;
    	}
    	else {
    		// once size reached the threshold create increased array 
    		// and copy the existing array to new array
    		// and nullify the existing array
    	}
    	return addWordFlag;
    }
	
	public Word retrieveWord(String wordKey) {
		Word word = null;
		for(int i=0; i<this.size();i++) {
			//System.out.println("this.size()"+this.size());
			//System.out.println("words[i].getKey()"+words[i].getKey());
			if(words[i].getKey().equals(wordKey)) {
				return words[i];
			}
			
		}
		return word;
	}
	
	public WordIterator retrieveAllWords() {
		WordIterator obj =  new WordIteratorImpl(this.words, this.count);
		return obj;
	}
	
	
	public boolean editWord(Word word) {
		boolean modifiedFlag = false;
		for(int i=0; i<this.size();i++) {
			//System.out.println("this.size()"+this.size());
			//System.out.println("words[i].getKey()"+words[i].getKey());
			if(words[i].getKey().equals(word.getKey())) {
				Word wordToModify = words[i];
				wordToModify.setValue(word.getValue());
				words[i] = wordToModify;
				modifiedFlag = true;
				String[] modValue = word.getValue();
				System.out.println("modified value  for key  " +word.getKey() + "  is  " + modValue[0]);
			}
			
		}
		return modifiedFlag;
	}
	
	public boolean removeWord(String wordKey) {
		return true;
	}
	
  
    public boolean containsWordKey(String wordKey) {
    	return true;
    }
    
    public boolean containsWordValue(String wordValue) {
    	return true;
    }
	
}
