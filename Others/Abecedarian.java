//Oskar Enmalm 29/9/17
//An Abecadrian is a word where each letter is in alphabetical order
//Abecadrian은 단어내의 모든 단어들이 알파벳순으로 있는 단어입니다. 
class Abecedarian{

    public static boolean isAbecedarian(String s){
        int index = s.length() - 1;

        for(int i =0; i <index; i++){

            if(s.charAt(i)<=s.charAt(i + 1)){} //Need to check if each letter for the whole word is less than the one before it
            								   //단어의 한 글자가 그 글자 앞에 있는 단어보다 큰 지(아스키 코드 값) 확인합니다. 

            else{return false;}
            }
        return true;
        }
}
