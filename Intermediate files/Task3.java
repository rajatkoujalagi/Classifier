import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.HashMap;


public class Task3 {


public static void main(String args[])
{

try{

writefile("Label,ID,PixelNo,RED,GREEN,BLUE","Task3_Input.csv");

File csvFolder = new File("inputFolder/train");
BufferedReader br =null;
String line="";
for(File file : csvFolder.listFiles()){

readDir(file);
 

}
 }catch (Exception e){
e.printStackTrace();
 }
}

public static void writefile(String line,String fileName) throws Exception{
BufferedWriter bufferWrite = null;
File file = new File(fileName); 

bufferWrite = new BufferedWriter(new FileWriter(file,true));
bufferWrite.write(line);
bufferWrite.write("\n");
bufferWrite.close();




}

public static void readDir(File Folder) throws Exception{


File csvFolder = new File("inputFolder");
BufferedReader br =null;
String line="";
for(File file : Folder.listFiles()){
if(file.isDirectory()){
//then this is a new class , 

readDir(file);
 
 

}else
{
 

int[] redArr = new int[100];
int[] greenArr = new int[100];
int[] blueArr = new int[100];

file.getParentFile().getName();

StringBuilder stringBuild = new StringBuilder();
 
 int counter = 0;
br = new BufferedReader(new FileReader(file));
 while((line = br.readLine()) != null){


for(String token : line.split(",")){



int var =  (int) (long) Math.round(Double.parseDouble(token)*(16.0/256));

 
 if(counter < 100){
//for red
redArr[counter++] = var;

 
 }else
 if(counter >= 100 && counter <200){
      //for green

greenArr[counter++-100] = var;
      
      
 }
 else{
   // for blue


blueArr[counter++ - 200] = var;
   
 
 }
   

 
 }

}

String className = file.getParentFile().getName().replaceAll(" ","_").toString();
String fileName = className+"_"+file.getName();

for(int i=0;i<100;i++){

writefile(className+","+fileName+","+i+","+redArr[i]+","+greenArr[i]+","+blueArr[i],"Task3_Input.csv");

}

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



}

}

}





}
