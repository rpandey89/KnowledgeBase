package com.knowledgebase.Strings;

/**
 * Created by rahul.pandey on 4/7/17.
 */
public class URLify {

    private static void doURLify(char[] str, int length) {
        int numSpaces = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') numSpaces++;
        }
        int totalLength = numSpaces * 2 + length; //double because the spaces in the string are already covered in the length
        for (int i = length - 1; i > 0; i--) {
            if (str[i] == ' ') {
                str[totalLength - 1] = '0';
                str[totalLength - 2] = '2';
                str[totalLength - 3] = '%';
                totalLength -= 3;
            } else {
                str[totalLength - 1] = str[i];
                totalLength--;
            }
        }
    }

    public static void main(String[] args) {
        char[] str = {'M', 'r', ' ', 'J', 'O', 'H', 'N', ' ', 'S', 'M', 'I', 'T', 'H', ' ', ' ', ' ', ' '};
        doURLify(str, 13);
        for (char el : str) {
            System.out.print(el);
        }
    }

}
