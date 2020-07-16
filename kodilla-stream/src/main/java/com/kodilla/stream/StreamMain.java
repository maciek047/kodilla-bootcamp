package com.kodilla.stream;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;


public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("My dazzling poem to be remembered.", text -> "~~~~~~\n" + text + "\n~~~~~~");
        poemBeautifier.beautify("My dazzling poem to be remembered.", text -> text.toUpperCase());
        poemBeautifier.beautify("My dazzling poem to be remembered.", text -> text.toLowerCase());
        PoemDecorator codeToExecute = (text) -> {
            String tempStr = "";
            for(int i = 0; i < text.length(); i++){
                char c = text.charAt(i);

                if (i%2!=0){
                    tempStr += Character.toUpperCase(c);
                }else{
                    tempStr += Character.toLowerCase(c);
                }
            }
            return tempStr;
        };
        poemBeautifier.beautify("My dazzling poem to be remembered.",codeToExecute);
    }
}