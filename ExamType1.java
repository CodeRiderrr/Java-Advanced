import java.util.*;

public class ExamType1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque <Character> vowelQueue = new ArrayDeque<>();
        ArrayDeque<Character> consonantStack = new ArrayDeque<>();

        String[] vovelsArr = scanner.nextLine().split(" ");
        for (String chars : vovelsArr){
            vowelQueue.offer(chars.charAt(0));
        }
                                                                       //превръща стринг в char и пълни stack and queue
        String[] consArr = scanner.nextLine().split(" ");
        for (String chars : consArr){
            consonantStack.push(chars.charAt(0));
        }

        List<Character> pearList = new ArrayList<>();
        List<Character> flourList = new ArrayList<>();
        List<Character> porkList = new ArrayList<>();
        List<Character> oliveList = new ArrayList<>();
        String pear = "pear";
        String flour = "flour";
        String pork = "pork";
        String olive = "olive";
        List<Character> finalPearList = new ArrayList<>();
        List<Character> finalFlourList = new ArrayList<>();
        List<Character> finalPorkList = new ArrayList<>();
        List<Character> finalOliveList = new ArrayList<>();

        for (Character chars : pear.toCharArray()){
            pearList.add(chars);
        }
        for (Character chars : flour.toCharArray()){              //пълня началните листовете от char за всяка дума
            flourList.add(chars);
        }
        for (Character chars : pork.toCharArray()){
            porkList.add(chars);
        }
        for (Character chars : olive.toCharArray()){
            oliveList.add(chars);
        }

        while (!vowelQueue.isEmpty() && !consonantStack.isEmpty()){
            char currentVowel = vowelQueue.peek();
            char currentCons = consonantStack.peek();

            //за всяка буква от думата проверка дали съвпада с гласната and add to finalList
            checkCharsIsHAveInFinal(pearList, finalPearList, currentVowel, currentCons);
            checkCharsIsHAveInFinal(flourList, finalFlourList, currentVowel, currentCons);
            checkCharsIsHAveInFinal(porkList, finalPorkList, currentVowel, currentCons);
            checkCharsIsHAveInFinal(oliveList, finalOliveList, currentVowel, currentCons);

            consonantStack.pop();
            if (!vowelQueue.isEmpty()){
                char currentChar = vowelQueue.poll();                //махам и размествам chars in stack and queue
                vowelQueue.offer(currentChar);
            }

        }//end while

        String finalPear = finalWord(pearList , finalPearList);
        String finalFlour = finalWord(flourList , finalFlourList);
        String finalPork = finalWord(porkList , finalPorkList);
        String finalOlive = finalWord(oliveList , finalOliveList);

        List<String >finalWordsList = new ArrayList<>();

        int wordsCount = 0;
        if (pear.equals(finalPear)){
            wordsCount++;
            finalWordsList.add(pear);
        }
        if (flour.equals(finalFlour)){
            wordsCount++;
            finalWordsList.add(flour);
        }
        if (pork.equals(finalPork)){
            wordsCount++;
            finalWordsList.add(pork);
        }
        if (olive.equals(finalOlive)){
            wordsCount++;
            finalWordsList.add(olive);
        }

        System.out.printf("Words found: %d\n",wordsCount);
        for (String word : finalWordsList){
            System.out.println(word);
        }



    }
    private static String finalWord(List<Character>pearList, List<Character>finalPearList){
        StringBuilder builder = new StringBuilder();
        for (Character currentChatPear : pearList){
            for (Character currentCharFinalPear : finalPearList){
                if (currentChatPear == currentCharFinalPear){
                    builder.append(currentChatPear);
                }
            }
        }
        return builder.toString();
    }

    private static void checkCharsIsHAveInFinal(List<Character> pearList, List<Character> finalPearList, char currentVowel, char currentCons) {
        for (Character symbolOfPear : pearList){       //за всяка буква от думата проверка дали съвпада с гласната
            if (symbolOfPear == currentVowel){
                boolean isHave = false;
                if (finalPearList.isEmpty()){
                    finalPearList.add(symbolOfPear);
                }
                for (Character currentChar : finalPearList){
                    if (currentChar == symbolOfPear){
                        isHave = true;
                        break;
                    }
                }
                if (!isHave){
                    finalPearList.add(symbolOfPear);
                }
            }
            if (symbolOfPear == currentCons){
                boolean isHave = false;
                if (finalPearList.isEmpty()){
                    finalPearList.add(symbolOfPear);
                }
                for (Character currentCharFinalPear : finalPearList){
                    if (symbolOfPear == currentCharFinalPear){
                        isHave = true;
                        break;
                    }
                }
                if (!isHave){
                    finalPearList.add(symbolOfPear);
                }
            }
        }
    }
}























//        String firstInput = scanner.nextLine().replaceAll("\\s+", "");
//        char[] firstInputVowel = firstInput.toCharArray();                    //и така става
//
//        String secondInput = scanner.nextLine().replaceAll("\\s+", "");
//        char[] secondInputConsonant = secondInput.toCharArray();
//
//        List<StringBuilder> wordsList = new ArrayList<>();
//        List<String> wordsListString = new ArrayList<>();
//        int found = 0;
//
//        wordsList.add(new StringBuilder("pear"));
//        wordsList.add(new StringBuilder("flour"));
//        wordsList.add(new StringBuilder("pork"));
//        wordsList.add(new StringBuilder("olive"));
//
//        wordsListString.add("pear");
//        wordsListString.add("flour");
//        wordsListString.add("pork");
//        wordsListString.add("olive");
////        String[] pear = new String[4];
////        String[] flour = new String[5];
////        String[] pork = new String[4];
////        String[] olive = new String[5];
////        List<Character>charsList = new ArrayList<>();
//
//        ArrayDeque<Character> vowelQueue = new ArrayDeque();
//        ArrayDeque<Character> consonantStack = new ArrayDeque();
//        List<String> finalList = new ArrayList<>();
//
//        for (int i = 0; i < firstInputVowel.length; i++) {
//            vowelQueue.offer(firstInputVowel[i]);                                 //fill stack and queue
//        }
//        for (int i = 0; i < secondInputConsonant.length; i++) {
//            consonantStack.push(secondInputConsonant[i]);
//        }
//
//        while (!vowelQueue.isEmpty() && !consonantStack.isEmpty()) {
//            char currentVowel = vowelQueue.peek();                                 //till isempty stack or queue
//            char currentConsonant = consonantStack.peek();
//
//            for (int word = 0; word < wordsList.size(); word++) {                     //check every word
//                StringBuilder currentWord = wordsList.get(word);
//
//                for (int i = 0; i < currentWord.length(); i++) {
//                    char currentChar;                                      //iteriram prez dumite i maham bukwata
//                    boolean isHave = false;
//                    if (currentWord.charAt(i) == currentVowel || currentWord.charAt(i) == currentConsonant) {
//                        currentWord.deleteCharAt(i);                      //delete char in word if have
//                        isHave = true;
//                        for (int j = 0; j < currentWord.length(); j++) {
//                            if (currentWord.charAt(j) == currentVowel || currentWord.charAt(j) == currentConsonant) {
//
//                                currentWord.deleteCharAt(j);
//                                isHave = true;                              //check fot second char
//                            }
//                        }
//                    }
//
//                    if (isHave) {
//                        wordsList.remove(word);
//                        wordsList.add(word, currentWord);
//                    }
//                    if (wordsList.get(word).length() == 0) {
//                        found++;
//                        finalList.add(wordsListString.get(word));
//                    }
//                }
//            }
//            if (!vowelQueue.isEmpty()) {
//                vowelQueue.poll();
//                vowelQueue.offer(currentVowel);  //obrashta queue
//            }
//            consonantStack.pop();  //maha stek
//
//        }//end while
//
//        System.out.printf("Words found: %d\n", found);
//
//        for (int i = finalList.size() - 1; i >= 0; i--) {
//
//            System.out.println(finalList.get(i));
//        }
