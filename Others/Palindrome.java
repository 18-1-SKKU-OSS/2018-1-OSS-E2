class Palindrome {
	
	private String reverseString(String x){ //*helper method 도와주는 메서드입니다. 
		String output = "";
		for(int i=x.length()-1; i>=0; i--){
			output += x.charAt(i); //addition of chars create String  문자를 더하여 문자열이 됩니다. 
		}
		return output;
	}
	
	/** 
	 * palindrome이란 어떤 문자열을 거꾸로 뒤집었을때도 그 문자와 같은 문자열인 문자열을 말합니다. 
	 * 에를 들어 level 이라는 단어는 거꾸로 써도 level 이므로 palindrome입니다. 
	 * 하지만 moon 이라는 단어는 거꾸로 쓰면 noom 이므로 palindrome이 아닙니다. 
	 * 
	 * 
	 * */
	
	public Boolean FirstWay(String x){ //*palindrome method, returns true if palindrome  palindrome 메서드 입니다. palindrome이면 true를 리턴합니다.  
		return (x.equalsIgnoreCase(reverseString(x)));
	}
  	
  	public boolean SecondWay(String x)
  	{
  		if (x.length() == 0 || x.length() == 1)
  			return true;

  		if (x.charAt(0) != x.charAt(x.length() - 1))
  			return false;

  		return SecondWay(x.substring(1 , x.length() - 1));
  	}
  }
