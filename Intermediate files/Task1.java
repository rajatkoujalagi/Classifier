import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Task1 {


public static void main(String args[])
{

try{

StringBuilder stringBuild = new StringBuilder();
for(int i=0;i<300;i++)
{
stringBuild.append(i).append(",");
}
stringBuild.append("Label");

writeFile(stringBuild.toString(),"Task2_Input.csv");

File folder = new File("csvfiles");
BufferedReader br =null;
String line="";
for(File file : folder.listFiles()){

readDir(file);
 

}
 }catch (Exception e){
e.printStackTrace();
 }
}

public static void writeFile(String line,String fileName) throws Exception{
BufferedWriter bufferedwrite = null;
File file = new File(fileName); 

bufferedwrite = new BufferedWriter(new FileWriter(file,true));
bufferedwrite.write(line);
bufferedwrite.write("\n");
bufferedwrite.close();




}

public static void readDir(File Folder) throws Exception{


File folder = new File("inputFolder");  //Folder for the csv file
BufferedReader br =null;
String line="";
for(File file : Folder.listFiles()){
if(file.isDirectory()){


readDir(file);
 
 /*else{
			.put((i+1)+(scale*30), (i+2)+(scale*30));
				br = System.nanoTime();
				}
				
					putstarttime = System.nanoTime();
					c1.put((i+1)+(scale*30), (i+2)+(scale*30));
					putendtime = System.nanoTime();
				}
				if(choice ==3){
					putstarttime = System.nanoTime();
					Collections.synchronizedMap(c2).put((i+1)+(scale*30), (i+2)+(scale*30));
					putendtime = System.nanoTime();
				}
				putruntime= putruntime +putendtime-putstarttime;
			}*/

}else
{
 // reading the csv file

file.getParentFile().getName();

StringBuilder stringBuild = new StringBuilder();
 
 int counter = 0;
br = new BufferedReader(new FileReader(file));
 while((line = br.readLine()) != null){

for(String token : line.split(",")){  //spliting the line with commas
stringBuild.append(Math.round(Double.parseDouble(token)*(16.0/256))).append(",");
}

 counter++;
 

 
 }


stringBuild.append(file.getParentFile().getName().replaceAll(" ","_"));
writeFile(stringBuild.toString(),"Task2_Input.csv"); //  writing it to the csv file


}

}

}

/*	
		// TODO Auto-generated method stub
		if(flag){
			for(int i = 0;i < 30;i++){
				if(choice ==1){
				getstarttime = System.nanoTime();
				c.get((i+1)+(scale*30));
				getendtime = System.nanoTime();
				}
				if(choice ==2){
				getstarttime = System.nanoTime();
				c1.get((i+1)+(scale*30));
				
				}
				if(choice ==3){
				getstarttime = System.nanoTime();
				Collections.synchronizedMap(c2).get((i+1)+(scale*30));
				getendtime = System.nanoTime();
				}
				getruntime= getruntime +getendtime-getstarttime;
			}
			System.out.println("gettime "+getruntime);
		}
			System.out.println("puttime "+putruntime);
		}*/





}
