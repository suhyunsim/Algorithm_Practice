package main.java.com.poogle.cracking.Ch1ArrayString.Q3;

public class SolutionB {
    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        replaceSpaces(arr, trueLength);
        System.out.println("\"" + charArrayToString(arr) + "\"");
    }

    private static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') return i;
        }
        return -1;
    }

    private static void replaceSpaces(char[] arr, int trueLength) {
        int spaceCnt = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (arr[i] == ' ') {
                spaceCnt++;
            }
        }
        index = trueLength + spaceCnt * 2;
        if (trueLength < arr.length)
            arr[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                arr[index - 1] = '0';
                arr[index - 2] = '2';
                arr[index - 3] = '%';
                index = index - 3;
            } else {
                arr[index - 1] = arr[i];
                index--;
            }
        }
    }

    private static String charArrayToString(char[] array) {
        StringBuilder buffer = new StringBuilder(array.length);
        for (char c : array) {
            if (c == 0) break;
            buffer.append(c);
        }
        return String.valueOf(buffer);
    }
}
