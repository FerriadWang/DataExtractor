package edu.ncepu.cs.ferriad;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DataExtractorMain {
	private String[] city_data= new String[9];
	//private static final String dirHead = ".\\generatedata\\";
	public static boolean createFile(File file){
		boolean flag = false;
		try{
			if(!file.exists()){
				file.createNewFile();
				flag=true;
			}
		}
		catch(Exception e){
				e.printStackTrace();
			}
		return flag;
	} 
	public static boolean readTxtFile(File file)throws Exception{
		String result[] = new String[9];
		FileReader fileReader = null;
		BufferedReader br = null;
		String dataLine = null;
		fileReader=new FileReader(file);  
		br=new BufferedReader(fileReader);
		while((dataLine=br.readLine())!=null){
			String locnum = dataLine.substring(0, 5);
			dataLine = dataLine.replaceAll("\\s", "");
			String city = null;
			switch(locnum){
			case "94846":
				city = "Chicago";
				dataLine = dataLine+"\r\n";
				writeTextFile(dataLine,city);
				break;
			case "24233":
				city = "Seattle";
				dataLine = dataLine+"\r\n";
				writeTextFile(dataLine,city);
				break;
			case "23174":
				city = "Los_Angeles";
				dataLine = dataLine+"\r\n";
				writeTextFile(dataLine,city);
				break;
			case "14732":
				city = "New_York_City";
				dataLine = dataLine+"\r\n";
				writeTextFile(dataLine,city);
				break;
			case "12839":
				city = "Miami";
				dataLine = dataLine+"\r\n";
				writeTextFile(dataLine,city);
				break;
			case "12904":
				city = "Houston";
				dataLine = dataLine+"\r\n";
				writeTextFile(dataLine,city);
				break;
			case "23234":
				city = "San_Francisco";
				dataLine = dataLine+"\r\n";
				writeTextFile(dataLine,city);
				break;
			case "14739":
				city = "Boston";
				dataLine = dataLine+"\r\n";
				writeTextFile(dataLine,city);
				break;
			case "53819":
				city = "Atlanta";
				dataLine = dataLine+"\r\n";
				writeTextFile(dataLine,city);
				break;
			default:
				break;
			}
			
		}
		return false;
		
	}
	private static boolean writeTextFile(String dataLine, String city) {
		boolean flag =false;
		FileOutputStream o = null;
		File city_file = new File(city);
		//createFile(city_file);
		try {
			    FileWriter fw = new FileWriter(city_file,true);
//				o = new FileOutputStream(city_file);
//				o.write(dataLine.getBytes("UTF-8"),(int)city_file.length(),dataLine.length());
//				o.close();
			    fw.write(dataLine,0,dataLine.length());  
    		    fw.flush(); 
				flag = true;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}finally{
				;
			}
		
		return flag;
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        File file = new File(".\\rawdata\\200401daily.txt");
        if(file.exists())
        readTxtFile(file);
        
//        File file1 = new File(".\\rawdata\\201104daily.txt");
//        if(file1.exists())
//        readTxtFile(file1);
               
	}
}
