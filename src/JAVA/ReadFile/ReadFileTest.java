package JAVA.ReadFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileTest {
    public static void main(String[] args) throws IOException {
        String fileName ="D:\\file.txt";
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line =bufferedReader.readLine();
        String[] lines = new String[100];
        int chars = 0, words = 0, whileSpaces = 0, alphabets = 0, digits = 0;
        int cnt = 0;
        while (line!=null){
            System.out.println(line);
            String[] ss = line.split("\\s+");
            words += ss.length;;
            lines[cnt++] = line;
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                char a = lines[i].charAt(j);
                chars ++;
                if (a == ' '){
                    whileSpaces ++;
                }else if (a >= 'a' && a <= 'z'){
                    alphabets ++;
                }else if(a >= 'A' && a <= 'Z'){
                    alphabets ++;
                }else if (a >= '0' && a <= '9'){
                    digits ++;
                }else {
                }
            }
        }
        System.out.println("chars: " + chars +
                " words: " + words +
                " lines: "+ cnt +
                " alphabets: " + alphabets +
                " digits: "+ digits +
                " white spaces: "+ whileSpaces);
    }
}
