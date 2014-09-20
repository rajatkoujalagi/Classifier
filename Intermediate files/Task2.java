import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.HashMap;


public class Task2 {


public static void main(String args[])
{

try{

StringBuilder stringBuild = new StringBuilder();
for(int i=0;i<48;i++)
{
stringBuild.append(i).append(",");
}
stringBuild.append("Label");

writefile(stringBuild.toString(),"Task2_Input.csv");

File inputFolder = new File("inputFolder/train");
BufferedReader br =null;
String line="";
for(File file : inputFolder.listFiles()){

readDir(file);
 

}
 }catch (Exception e){
e.printStackTrace();
 }
}

public static void writefile(String line,String fileName) throws Exception{
BufferedWriter bufferWriter = null;
File file = new File(fileName); 

bufferWriter = new BufferedWriter(new FileWriter(file,true));
bufferWriter.write(line);
bufferWriter.write("\n");
bufferWriter.close();




}

public static void readDir(File Folder) throws Exception{


File inputFolder = new File("inputFolder");
BufferedReader br =null;
String line="";
for(File file : Folder.listFiles()){
if(file.isDirectory()){
//then this is a new class , 

readDir(file);
 
 

}else
{
 // read the csv file

HashMap<Integer,Integer> redMap = new HashMap<Integer,Integer>();
HashMap<Integer,Integer> greenMap = new HashMap<Integer,Integer>();
HashMap<Integer,Integer> blueMap = new HashMap<Integer,Integer>();

file.getParentFile().getName();

StringBuilder stringBuild = new StringBuilder();
 
 int counter = 0;
br = new BufferedReader(new FileReader(file));
 while((line = br.readLine()) != null){
counter++;

for(String token : line.split(",")){


int var =  (int) (long) Math.round(Double.parseDouble(token)*(16.0/256));

 
 if(counter <= 10){
//for red

if(redMap.containsKey(var))
 {
redMap.put(var,redMap.get(var)+1);

}
else{
redMap.put(var,1);
}

 
 }else
 if(counter > 10 && counter <= 20){
     //for green

if(greenMap.containsKey(var))
 {
greenMap.put(var,greenMap.get(var)+1);

}
else{
greenMap.put(var,1);
}
      
      
 }
 else{
   //for blue


if(blueMap.containsKey(var))
 {
blueMap.put(var,blueMap.get(var)+1);

}
else{
blueMap.put(var,1);
}
   
 
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
 }// End Split

}// End While 


for(int i=0;i<16;i++){

if(redMap.containsKey(i))
 {

stringBuild.append(redMap.get(i)).append(",");

}
else
 stringBuild.append("0").append(",");


}

System.out.println(stringBuild);

for(int i=0;i<16;i++){

if(greenMap.containsKey(i))
 {

stringBuild.append(greenMap.get(i)).append(",");

}
else
 stringBuild.append("0").append(",");


}
System.out.println(stringBuild);
for(int i=0;i<16;i++){

if(blueMap.containsKey(i))
 {

stringBuild.append(blueMap.get(i)).append(",");

}
else
 stringBuild.append("0").append(",");


}
System.out.println(stringBuild);







stringBuild.append(file.getParentFile().getName().replaceAll(" ","_"));
writefile(stringBuild.toString(),"Task2_Input.csv");


}

}

}





}
