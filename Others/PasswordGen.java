import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/*
    Creates a random password from ASCII letters
    Given password length bounds
    
       아스키 코드에 있는 문자들을 이용해 주어진 길이 내에서 랜덤한 비밀번호를 만들어 냅니다. 
    
    
    author: AKS1996
    date: 2017-10-25
*/

class PasswordGen {
    public static void main(String args[]){
	String password = generatePassword(8,16);
	System.out.print("Password: " + password);
    }
	
    static String generatePassword(int min_length, int max_length){
        Random random = new Random();

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*(){}?";

        String allChars = upper+lower+numbers+specialChars;

        List<Character> letters = new ArrayList<Character>();
        for(char c:allChars.toCharArray())
            letters.add(c);

        // Inbuilt method to randomly shuffle a elements of a list
        // 원소들의 리스트를 무작위로 섞어줄 메서드입니다. 
        Collections.shuffle(letters);
        String password = "";

        // Note that size of the password is also random
        //비밀번호의 길이 도한 랜덤입니다. 
        for(int i = random.nextInt(max_length-min_length) + min_length; i>0; --i) {
            password += letters.get(random.nextInt(letters.size()));
        }

        return password;
    }
}
