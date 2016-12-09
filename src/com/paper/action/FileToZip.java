package com.paper.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileToZip {

	 public static void zip(String zipFileName , String inputFile)throws Exception
	 {
	  File f = new File(inputFile);
	  ZipOutputStream out=new ZipOutputStream(new FileOutputStream(zipFileName));
	  zip(out,f,null);
	  System.out.println("zip done");
	  out.close();
	 }
	  
	 private static void zip(ZipOutputStream out,File f,String base)throws Exception
	 {
	  System.out.println("zipping " + f.getAbsolutePath());
	  if (f.isDirectory()) {
	   File[] fc =f.listFiles();
	   if(base!=null)
	      out.putNextEntry(new ZipEntry(base+"/"));
	   base=base==null?"":base+"/";
	   for (int i=0;i<fc.length ;i++ ) {
	    zip(out,fc[i],base+fc[i].getName());
	   }
	  }
	  else {
	   out.putNextEntry(new ZipEntry(base));
	   FileInputStream in=new FileInputStream(f);
	   int b;
	   while ((b=in.read()) != -1)
	    out.write(b);
	   in.close();
	  }
	 }
	 public void filezip(String zip,String path)
	 {
	  try{
		  FileToZip t=new FileToZip();
		  t.zip(zip,path);
	 //  t.zip("c:\\test.zip","c:\\test");
	//   t.unzip("c:\\test.zip","c:\\test2");
	  }catch(Exception e){
	   e.printStackTrace(System.out);
	  }
	 }
//	 public static void main(String[] args)
//	 {
//	  try{
//		  FileToZip t=new FileToZip();
//	 //  t.zip("c:\\test.zip","c:\\test");
//	//   t.unzip("c:\\test.zip","c:\\test2");
//	  }catch(Exception e){
//	   e.printStackTrace(System.out);
//	  }
//	 }
}