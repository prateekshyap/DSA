import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.HashMap;

class Questions
{
	private String questionKey;
	//private 

	//private
}

class Topics
{
	private String topic; //name of the topic/directory
	private int javaCount; //total number of .java files
	private int cppCount; //total number of .cpp files
	private HashMap<String,Integer> questionIndexMap; //stores the question key and the index of indexDetailsMap array
	private Questions[] indexDetailsMap; //stores the details for each question in an array
	
	Topics(String topic, int noq)
	{
		this.topic = topic;
		javaCount = cppCount = 0;
		questionIndexMap = new HashMap<String,Integer>();
		indexDetailsMap = new Questions[noq];
	}

	//setter methods
	public void setJavaCount(int count) { this.javaCount = count; }
	public void setCppCount(int count) { this.cppCount = count; }

	//getter methods
	public String getTopicName() { return this.topic; }
	public int getJavaCount() { return this.javaCount; }
	public int getCppCount() { return this.cppCount; }
}

class UpdateReadme
{
	public static void main(String[] args) throws IOException
	{
		//important declarations
		String mainPathStr = "E:\\DSA\\Coding";
		File mainPath = new File(mainPathStr);
		Topics[] topicDetails;

		//get the list of folders
		String[] topics = mainPath.list();
		
		//opening readme file in write mode
		File readmeFile = new File("README.md");
		if (!readmeFile.exists()) readmeFile.createNewFile();
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(readmeFile));
		
		//write the first fixed segment
		printFixedMessage(fileWriter,1);
		
		//count the number of topic directories
		int dirCount = 0;
		for (String topic : topics)
			if (!containsDot(topic)) ++dirCount;

		//define topics array
		topicDetails = new Topics[dirCount];
		int index = 0;

		for (String topic : topics) //for each topic
		{
			if (!containsDot(topic)) //if it doesn't contain a dot
			{
				//get the topic directory path
				String topicPathStr = new String(mainPathStr);
				topicPathStr += "\\";
				topicPathStr += topic;
				File topicPath = new File(topicPathStr);

				String[] programs = topicPath.list(); //list the files in that folder
				int javaCount = 0, cppCount = 0;

				topicDetails[index] = new Topics(topic,programs.length); //create a new topic
				//store java and cpp counts
				for (String program : programs)
				{
					if (program.charAt(program.length()-1) == 'p') ++cppCount;
					if (program.charAt(program.length()-1) == 'a') ++javaCount;
					
					String codeFileName = new String(topicPathStr);
					codeFileName += "\\";
					codeFileName += program;
					File codeFile = new File(codeFileName);
					BufferedReader reader = new BufferedReader(new FileReader(codeFile));

					String nextLine = "";
					while ((nextLine = reader.readLine()) != null)
					{
						if (isALink(nextLine))
						{}
					}

					reader.close();
				}
				topicDetails[index].setJavaCount(javaCount);
				topicDetails[index].setCppCount(cppCount);

				++index;
			}
		}


		//write folder wise counts
		fileWriter.write("| Topic Name | Java | CPP | "); fileWriter.newLine();
		fileWriter.write("| :--------: | :--------: | :--------: | "); fileWriter.newLine();
		int totalJava = 0, totalCpp = 0;
		for (Topics topic : topicDetails)
		{
			fileWriter.write("| ["+topic.getTopicName()+"](https://github.com/prateekshyap/DSA#"+topic.getTopicName().toLowerCase()+") | "+topic.getJavaCount()+" | "+topic.getCppCount()+" |"); fileWriter.newLine();
			totalJava += topic.getJavaCount(); totalCpp += topic.getCppCount();
		}
		fileWriter.write("| Total | "+totalJava+" | "+totalCpp+" |"); fileWriter.newLine(); fileWriter.newLine();

		//write next fixed segment
		printFixedMessage(fileWriter,2);

		fileWriter.close();
	}

	public static boolean isALink(String str)
	{
		return false;
	}

	public static boolean containsDot(String str)
	{
		for (int i = 0; i < str.length(); ++i)
			if (str.charAt(i) == '.')
				return true;
		return false;
	}

	public static void printFixedMessage(BufferedWriter writer, int trigger) throws IOException
	{
		switch(trigger)
		{
		case 1:
			writer.write("# GFG-LeetCode-Topicwise-Solutions"); writer.newLine(); writer.newLine();
			writer.write("Solutions to the algorithmic problems in [LeetCode](https://leetcode.com/problemset/algorithms/) & [GeeksForGeeks](https://practice.geeksforgeeks.org/explore/?problemType=full&page=1) written in **C++** and **JAVA**"); writer.newLine(); writer.newLine();
			writer.write("## What you can find in this repository"); writer.newLine(); writer.newLine();
			writer.write("We have solved quite a number of problems from several topics. See the below table for further details."); writer.newLine(); writer.newLine();
			writer.write("## How to contribute?"); writer.newLine(); writer.newLine();
			writer.write("1. Fork the repository"); writer.newLine();
			writer.write("2. Do the desired changes (add/delete/modify)"); writer.newLine();
			writer.write("3. Make a pull request"); writer.newLine(); writer.newLine();
			writer.write("## When to contribute?"); writer.newLine(); writer.newLine();
			writer.write("1. If there is no solution to a problem in the main branch"); writer.newLine();
			writer.write("2. If your solution is asymptotically faster than the one in the main branch"); writer.newLine();
			writer.write("3. If your algorithm is of the same time complexity but with reduced code size (In this case, comment out the original solution and make a pull request with your solution.)"); writer.newLine();
			writer.write("4. If you have another method of solving the problem which is asymptotically slower than the original method (In this case, comment your solution in the main file and make a pull request.)"); writer.newLine(); writer.newLine();
			writer.write("## Algorithms"); writer.newLine(); writer.newLine();
			writer.write("Number of Problems Solved ");//get current date and time and write
			DateTimeFormatter currentDateAndTime = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			writer.write("("+currentDateAndTime.format(now)+")"); writer.newLine(); writer.newLine();
			break;

		case 2:
			writer.write("## Reference"); writer.newLine(); writer.newLine();
			writer.write("* C++"); writer.newLine();
			writer.write("\t* [STL Time Complexity (Detailed)](http://www.cplusplus.com/reference/stl/)"); writer.newLine();
			writer.write("\t* [STL Time Complexity (Summary)](http://john-ahlgren.blogspot.com/2013/10/stl-container-performance.html)"); writer.newLine();
			writer.write("\t* [Data Structure and Algorithms Cheat Sheet](https://github.com/gibsjose/cpp-cheat-sheet/blob/master/Data%20Structures%20and%20Algorithms.md)"); writer.newLine();
			writer.write("* JAVA"); writer.newLine();
			writer.write("\t* [Time Complexity](to-be-updated)"); writer.newLine(); writer.newLine();
			break;
		}
	}
}