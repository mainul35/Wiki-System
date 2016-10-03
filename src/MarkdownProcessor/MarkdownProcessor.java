/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarkdownProcessor;

/**
 *
 * @author Mainul35
 */
public class MarkdownProcessor {
    public static String getMarkupText(String pageContent){
        int boldCounter = 0;
        int italicCounter = 0;
        int underlineCounver = 0;
        int blockQuoteCounter = 0;
        int centerCounter = 0;

        StringBuilder markdownContent = new StringBuilder(pageContent);
        for (int counter = 0; counter < markdownContent.length() - 1; counter++) {
            String chars = markdownContent.substring(counter, counter + 2);
//            System.err.println(chars);
            if (chars.equals("^^")) {
                boldCounter++;
                if (boldCounter % 2 == 1) {
                    markdownContent.replace(counter, counter + 2, "<b>");
                } else if (boldCounter % 2 == 0) {
                    markdownContent.replace(counter, counter + 2, "</b>");
                }
            } else if (chars.equals("//")) {
                italicCounter++;
                if (italicCounter % 2 == 1) {
                    markdownContent.replace(counter, counter + 2, "<i>");
                } else if (italicCounter % 2 == 0) {
                    markdownContent.replace(counter, counter + 2, "</i>");
                }
            } else if (chars.equals("__")) {
                underlineCounver++;
                if (underlineCounver % 2 == 1) {
                    markdownContent.replace(counter, counter + 2, "<u>");
                } else if (underlineCounver % 2 == 0) {
                    markdownContent.replace(counter, counter + 2, "</u>");
                }
            } else if (chars.equals("##")) {
                blockQuoteCounter++;
                if (blockQuoteCounter % 2 == 1) {
                    markdownContent.replace(counter, counter + 2, "<blockquote>");
                } else if (blockQuoteCounter % 2 == 0) {
                    markdownContent.replace(counter, counter + 2, "</blockquote>");
                }
            }else if(chars.equals("~~")){
                markdownContent.replace(counter, counter+2, "<br>");
            }else if(chars.equals("--")){
                centerCounter++;
                if(centerCounter % 2 == 1){
                    markdownContent.replace(counter, counter+2, "<center>");
                }else if(centerCounter % 2==0){
                    markdownContent.replace(counter, counter+2, "</center>");
                }
            }
        }

        return markdownContent.toString();
    }
}
