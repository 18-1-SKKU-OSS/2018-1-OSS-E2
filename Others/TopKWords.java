import java.io.*;
import java.util.*;

/** display the most frequent K words in the file and the times it appear
  *  in the file �� shown in order (ignore case and periods) 
  *  
  *  파일에서 가장 자주 등장한 K개의 문자가 몇번 등장했는지 순서대로 출력합니다. 
  *	  대소문자와 마침표 등은 무시합니다. 
  */

public class TopKWords {
    static class CountWords {
        private String fileName;

        public CountWords(String fileName) {
            this.fileName = fileName;
        }

        public Map<String, Integer> getDictionary() {
            Map<String, Integer> dictionary = new HashMap<>();
            FileInputStream fis = null;

            try {

                fis = new FileInputStream(fileName);  // open the file  파일을 엽니다
                int in = 0;
                String s = "";  // init a empty word  빈 문자 초기화
                in = fis.read();  // read one character  하나의 문자를 읽습니다. 

                while (-1 != in) {
                    if (Character.isLetter((char)in)) {
                        s += (char)in;  //if get a letter, append to s   문자를 받으면, s에 추가합니다. 
                    } else {
                        // this branch means an entire word has just been read  여기로 왔다는 것은 전체 단어가 읽어졌다는 뜻입니다.
                        if (s.length() > 0) {
                            // see whether word exists or not  문자가 존재하는지 안하는지를 확인합니다. 
                            if (dictionary.containsKey(s)) {
                                // if exist, count++   존재한다면 count++ 해줍니다.
                                dictionary.put(s, dictionary.get(s) + 1);
                            } else {
                                // if not exist, initiate count of this word with 1  존재하지 않는다면 이 단어의 count를 1로 초기화합니다.
                                dictionary.put(s, 1);
                            }
                        }
                        s = ""; // reInit a empty word
                    }
                    in = fis.read();
                }
                return dictionary;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // you always have to close the I/O streams
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
    public static void main(String[] args) {
        // you can replace the filePath with yours  당신은 당신의 저장소로 파일의 위치를 바꿀 수 있습니다. 
        CountWords cw = new CountWords("/Users/lisanaaa/Desktop/words.txt");
        Map<String, Integer> dictionary = cw.getDictionary();  // get the words dictionary: {word: frequency}  문자 사전을 가져옵니다. : {단어 : 빈도수}

        // we change the map to list for convenient sort  Map자료형을 ArrayList 자료형으로 옮겨서 저장합니다. 정렬이 용이하기 때문입니다. 
        List<Map.Entry<String, Integer>> list = new ArrayList<>(dictionary.entrySet());

        // sort by lambda valueComparator  lambda valueComparator 로 정렬합니다.
        list.sort(Comparator.comparing(
                m -> m.getValue())
        );

        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        while (k > list.size()) {
            System.out.println("Retype a number, your number is too large");
            input = new Scanner(System.in);
            k = input.nextInt();
        }
        for (int i = 0; i < k; i++) {
            System.out.println(list.get(list.size() - i - 1));
        }
    }
}

