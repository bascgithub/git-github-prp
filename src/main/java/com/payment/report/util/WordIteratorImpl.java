package com.payment.report.util;

public class WordIteratorImpl implements WordIterator{
	Word[] dictionaryContent = null;
	int nextIndex = 0;
	int currentIndex = 0;
	int wordCount = 0; 
	public WordIteratorImpl() {
		
	}
	
    public WordIteratorImpl(Word[] dictionaryContent, int count) {
		this.dictionaryContent = dictionaryContent;
		this.wordCount = count;
	}
	public boolean hasNextWord() {
		boolean hasNextFlag = false;
		if(dictionaryContent == null || wordCount == 0) {
			hasNextFlag = false;
		}else if(wordCount > 0 && nextIndex < wordCount) {
			
			currentIndex = nextIndex;
			nextIndex++; 
			hasNextFlag = true;
		}
		//System.out.println("nextIndex"+nextIndex);
		//System.out.println("currentIndex"+currentIndex);
		
		return hasNextFlag;
	}
	
	public Word nextWord() {
		return dictionaryContent[currentIndex];
    }
}
