package method.youdao_API;

import java.net.HttpURLConnection;
import java.util.Scanner;
import java.io.*;
import java.net.*;

public class TestPost {

    public static void main(String[] args) {
        new ReadByPost().start();
    }

}

class ReadByPost extends Thread{
    @Override
    
    public void run() {
    	Scanner in = new Scanner(System.in);
        try {
        	String str = null;
        	System.out.println("请输入要翻译的单词：");
        	str= in.nextLine();
        	//str="温柔";
        	str =URLEncoder.encode(str, "utf-8"); 
            URL url = new URL("http://fanyi.youdao.com/openapi.do");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.addRequestProperty("encoding", "UTF-8");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            connection.setRequestMethod("POST");

            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);


            bw.write("keyfrom=PaperNoteManage&key=1951063421&type=data&doctype=json&version=1.1&q="+str);
            bw.flush();

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is,"UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            
            StringBuilder builder = new StringBuilder();
            while((line = br.readLine()) != null){
                builder.append(line);
            }

            bw.close();
            osw.close();
            os.close();

            br.close();
            isr.close();
            is.close();

            System.out.println(builder.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
