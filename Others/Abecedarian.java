//Oskar Enmalm 29/9/17
//An Abecadrian is a word where each letter is in alphabetical order
//Abecadrian�� �ܾ�� ��� �ܾ���� ���ĺ������� �ִ� �ܾ��Դϴ�. 
class Abecedarian{

    public static boolean isAbecedarian(String s){
        int index = s.length() - 1;

        for(int i =0; i <index; i++){

            if(s.charAt(i)<=s.charAt(i + 1)){} //Need to check if each letter for the whole word is less than the one before it
            								   //�ܾ��� �� ���ڰ� �� ���� �տ� �ִ� �ܾ�� ū ��(�ƽ�Ű �ڵ� ��) Ȯ���մϴ�. 

            else{return false;}
            }
        return true;
        }
}
