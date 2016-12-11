package com.paper.action;

import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.PrintWriter;
import java.util.Arrays;  
  
public class StringandACSII {  
  
    public static char ascii2Char(int ASCII) {  
        return (char) ASCII;  
    }  
  
    public static int char2ASCII(char c) {  
        return (int) c;  
    }  
  
    public static String ascii2String(int[] ASCIIs) {  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < ASCIIs.length; i++) {  
            sb.append((char) ascii2Char(ASCIIs[i]));  
        }  
        return sb.toString();  
    }  
  
  
    public static int[] string2ASCII(String s) { 
        if (s == null || "".equals(s)) {  
            return null;  
        }  
  
        char[] chars = s.toCharArray();  
        int[] asciiArray = new int[chars.length];  
  
        for (int i = 0; i < chars.length; i++) {  
            asciiArray[i] = char2ASCII(chars[i]);  
        }
        System.out.println("asciiArray="+asciiArray);
        return asciiArray;  
    }  
  
  
    public static String showIntArray(int[] intArray, String delimiter) {  
    	String str=null;
        for (int i = 0; i < intArray.length; i++) {  
            str=str+intArray[i]+delimiter;  
        } 
        return str.substring(4);
    }  

    public String strasc(String s){//字符串转为ASCII路径
    	String path=null;
    	String s2=null;
    	int index = s.lastIndexOf("/");
    	path=s.substring(0, index+1);
        s2=s.substring(index+1,s.length()-4);
        //showIntArray(string2ASCII(s2), "%");
        path=path+showIntArray(string2ASCII(s2), "%").substring(0, showIntArray(string2ASCII(s2), "%").length()-1)+".pdf";
    	return path;
    }
    public  String ascstr(String s){//ASCII码转为字符串路径
    	String path=null;
    	String s2=null;
    	
    	String[] str;
    	int index = s.lastIndexOf("/");
    	path=s.substring(0, index+1);
        s2=s.substring(index+1,s.length()-4);
        System.out.println(s2);
        str=s2.split("%");
        //System.out.println(Arrays.toString(str));
        int[] i = new int[str.length];
        for(int j=0;j<str.length;j++){
        	i[j]=Integer.parseInt(str[j]);
        }
        System.out.println(i);
        //showIntArray(string2ASCII(s2), "%");
        path=path+ascii2String(i)+".pdf";
    	return path;
    }
//    public static void main(String[] args) throws IOException {  
//  
//        String s1=null,s2=null;
//    	String s = "pw@163.com/zxc/5-3 黑盒测试.pdf";
//    	String ss="pw@163.com/zxc/53%45%51%32%40657%30418%27979%35797.pdf";
//    	s1=ascstr(ss);
//    	System.out.println(s1);
//
//      //  System.out.println(ascii2String(string2ASCII(s)));  
//  
//    }  
  
}  
