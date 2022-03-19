class Solution {
	public String removeDuplicateLetters(String s) {
		// hold a counter of the number of occurrences of each character in the given string 
		Map<Character,Integer> charCountMap = new HashMap<>();
		for (char c: s.toCharArray()) {
			int currentCharCounter = charCountMap.getOrDefault(c, 0);
			charCountMap.put(c, currentCharCounter + 1);
		}

		// this set is only to keep track of the already visited characters in the final string in lexographical order
		Set<Character> resultCharSet = new HashSet<>();

		// this is the stack where we do the whole process with as follows:
		Stack<Character> charStack = new Stack<>();
		for(char ch: s.toCharArray()) {
			/*first we check if the current character should replace the top elements in the stack 
			in case they are bigger and occur more than once in the future. 
			Then we remove them from the stack as long as the condition still true: 
			1) stack is not empty &
		    2) the top char of the stack is bigger than the one to be added &
		    3) the current char is not already visited in the past and exists in earlier phases in the stack before. (e.g. "abca" in this case, we shouldnt remove 'b' and 'c' but simply skip to the next char)   
			*/
			while(!charStack.isEmpty() && charStack.peek() >= ch && !resultCharSet.contains(ch)) {
				char topStackChar = charStack.peek();
				int topStackCharCounter = charCountMap.get(topStackChar);
				if(topStackCharCounter > 0) {
					charStack.pop();
					resultCharSet.remove(topStackChar);
				} else {
					break;
				}
			}
			/*after we setup the stack to the right order, we do the following:
			if the character was not visited before, we add it to the stack and the set of visited chars
			Otherwise, we only reduce its corresponding occurrences counter and continue with the next character of the string
			*/
			int currentCharCounter = charCountMap.get(ch);
			if(!resultCharSet.contains(ch)) {
				charStack.push(ch);
				resultCharSet.add(ch);
			}
			charCountMap.put(ch, currentCharCounter - 1);
		}
		// we iterate through the character stack and build a string out of it. Done!
		return charStack.stream().map(String::valueOf).collect(Collectors.joining());
	}
}