class Palindrome {
	
	private String reverseString(String x){ //*helper method �����ִ� �޼����Դϴ�. 
		String output = "";
		for(int i=x.length()-1; i>=0; i--){
			output += x.charAt(i); //addition of chars create String  ���ڸ� ���Ͽ� ���ڿ��� �˴ϴ�. 
		}
		return output;
	}
	
	/** 
	 * palindrome�̶� � ���ڿ��� �Ųٷ� ������������ �� ���ڿ� ���� ���ڿ��� ���ڿ��� ���մϴ�. 
	 * ���� ��� level �̶�� �ܾ�� �Ųٷ� �ᵵ level �̹Ƿ� palindrome�Դϴ�. 
	 * ������ moon �̶�� �ܾ�� �Ųٷ� ���� noom �̹Ƿ� palindrome�� �ƴմϴ�. 
	 * 
	 * 
	 * */
	
	public Boolean FirstWay(String x){ //*palindrome method, returns true if palindrome  palindrome �޼��� �Դϴ�. palindrome�̸� true�� �����մϴ�.  
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
