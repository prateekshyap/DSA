import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Questions
{
	private String questionKey;
	private HashMap<String,Integer> questionLinks;
	private HashMap<String,String> solutionLinks;

	Questions(String key, HashMap<String,Integer> qLinks, String sLink)
	{
		this.questionKey = key;
		this.questionLinks = qLinks;
		this.solutionLinks = new HashMap<String,String>();
		if (sLink.charAt(sLink.length()-1) == 'a')
			this.solutionLinks.put("Java",sLink);
		else if (sLink.charAt(sLink.length()-1) == 'p')
			this.solutionLinks.put("CPP",sLink);
	}

	//getter methods
	public String getQuestionKey() { return this.questionKey; }
	public HashMap<String,Integer> getQuestionLinks() { return this.questionLinks; }
	public HashMap<String,String> getSolutionLinks() { return this.solutionLinks; }

	//solution link updation
	public void addSolutionLink(String sLink)
	{
		if (sLink.charAt(sLink.length()-1) == 'a')
			this.solutionLinks.put("Java",sLink);
		else if (sLink.charAt(sLink.length()-1) == 'p')
			this.solutionLinks.put("CPP",sLink);
	}

	public void printQuestion(BufferedWriter writer) throws IOException
	{
		writer.write("Question-"+questionKey); writer.newLine();
		Iterator linkIterator = questionLinks.entrySet().iterator();
		writer.write("Question links-"); writer.newLine();
		while (linkIterator.hasNext())
		{
			Map.Entry questionLink = (Map.Entry)linkIterator.next();
			writer.write((String)questionLink.getKey()); writer.newLine();
		}
		linkIterator = solutionLinks.entrySet().iterator();
		writer.write("Solution links-"); writer.newLine();
		while (linkIterator.hasNext())
		{
			Map.Entry solutionLink = (Map.Entry)linkIterator.next();
			writer.write((String)solutionLink.getValue()); writer.newLine();
		}
	}
}

class Topics
{
	private String topic; //name of the topic/directory
	private int javaCount; //total number of .java files
	private int cppCount; //total number of .cpp files
	private HashMap<String,Integer> questionIndexMap; //stores the question key and the index of indexDetailsMap array
	private Questions[] indexDetailsMap; //stores the details for each question in an array
	private int qIndex;

	Topics(String topic, int noq)
	{
		this.topic = topic;
		javaCount = cppCount = 0;
		questionIndexMap = new HashMap<String,Integer>();
		indexDetailsMap = new Questions[noq];
		qIndex = 0;
	}

	//setter methods
	public void setJavaCount(int count) { this.javaCount = count; }
	public void setCppCount(int count) { this.cppCount = count; }

	//getter methods
	public String getTopicName() { return this.topic; }
	public int getJavaCount() { return this.javaCount; }
	public int getCppCount() { return this.cppCount; }
	public HashMap<String,Integer> getQuestionIndexMap() { return this.questionIndexMap; }
	public Questions[] getIndexDetailsMap() { return this.indexDetailsMap; }

	//methods for adding questions
	public void addQuestion(HashMap<String,Integer> links, String topic, String program)
	{
		String link = "";
		int nameIndex = -1;
		Iterator linkIterator = links.entrySet().iterator();
		if (linkIterator.hasNext())
		{
			Map.Entry linkDetails = (Map.Entry)linkIterator.next();
			link = (String)linkDetails.getKey();
			nameIndex = (Integer)linkDetails.getValue();
		}
		String[] tokens = link.split("/");
		String questionKey = "";
		if (nameIndex < 0)
		{
			questionKey += tokens[Math.abs(nameIndex)];
			questionKey += "-";
			questionKey += tokens[Math.abs(nameIndex)+1];
		}
		else
		{
			questionKey += tokens[nameIndex];
		}
		String solutionLink = "./";
		solutionLink += topic;
		solutionLink += "/";
		solutionLink += program;

		//check existence of the current question
		boolean exists = false;
		String existingQuestionKey = "";
		Iterator questionIndexMapIterator = questionIndexMap.entrySet().iterator();
		while (questionIndexMapIterator.hasNext())
		{
			int questionIndex = (Integer)((Map.Entry)questionIndexMapIterator.next()).getValue();
			Questions currentQuestion = indexDetailsMap[questionIndex];
			HashMap<String,Integer> currentQuestionLinks = currentQuestion.getQuestionLinks();
			Iterator questionLinkIterator = currentQuestionLinks.entrySet().iterator();
			while (questionLinkIterator.hasNext())
			{
				String currentQuestionLink = (String)((Map.Entry)questionLinkIterator.next()).getKey();
				String[] currentTokens = currentQuestionLink.split("/");
				for (String currentToken : currentTokens)
				{
					if (currentToken.equals(questionKey))
					{
						exists = true;
						existingQuestionKey = currentQuestion.getQuestionKey();
					}
				}
			}
		}

		if (exists)
		{
			int questionIndex = (Integer)questionIndexMap.get(existingQuestionKey);
			indexDetailsMap[questionIndex].addSolutionLink(solutionLink);
		}
		else
		{
			Questions question = new Questions(questionKey,links,solutionLink);
			indexDetailsMap[qIndex] = question;
			questionIndexMap.put(questionKey,qIndex);
			++qIndex;
		}
	}

	public void printTopic(BufferedWriter writer) throws IOException
	{
		writer.write("TOPIC NAME: "+this.topic); writer.newLine();
		writer.write("Java files: "+this.javaCount); writer.newLine();
		writer.write("CPP files: "+this.cppCount); writer.newLine();
		writer.write("---------------------------------------------------------------------------------"); writer.newLine();
		Iterator linkIterator = this.questionIndexMap.entrySet().iterator();
		int bullet = 1;
		while (linkIterator.hasNext())
		{
			Map.Entry questionAndIndex = (Map.Entry)linkIterator.next();
			int index = (Integer)questionAndIndex.getValue();
			Questions question = indexDetailsMap[index];
			writer.write((bullet++)+"."); writer.newLine();
			question.printQuestion(writer);
			writer.newLine();
		}
	}
}

class UpdateReadme
{
	public static void main(String[] args) throws IOException
	{
		//important declarations
		String mainPathStr = "E:\\DSA\\Coding";
		File mainPath = new File(mainPathStr);
		Topics[] topicDetails; //main arrat that stores all the details of the folder

		//get the list of folders i.e. the topics
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
			if (!containsDot(topic)) //if it doesn't contain a dot that means it is a directory
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
				for (String program : programs) //for each file
				{
					if (program.equals("dummy.txt")) continue; //ignore txt files
					if (program.charAt(program.length()-1) == 'p') ++cppCount; //increase cpp count
					if (program.charAt(program.length()-1) == 'a') ++javaCount; //increase java count
					
					//get the file path
					String codeFileName = new String(topicPathStr);
					codeFileName += "\\";
					codeFileName += program;
					File codeFile = new File(codeFileName);

					//open a reader to read the code file
					BufferedReader reader = new BufferedReader(new FileReader(codeFile));

					String nextLine = "";
					HashMap<String,Integer> questionLinks = new HashMap<String,Integer>(); //stores the question links and their indices after splitting from "/"
					while ((nextLine = reader.readLine()) != null) //for each line
					{
						int nameIndex = isALink(nextLine); //get the index of the question
						if (nameIndex != -1) //if the index is not -1
							questionLinks.put(nextLine,nameIndex); //add to map

						//add time complexity and space complexity logic here
					}
					topicDetails[index].addQuestion(questionLinks,topic,program); //add the question to the main array

					reader.close();
				}
				topicDetails[index].setJavaCount(javaCount);
				topicDetails[index].setCppCount(cppCount);

				++index;
			}
		}

		//write the data to a txt file for future reference
		File outputFile = new File("ConsoleOutput.txt");
		if (!outputFile.exists()) outputFile.createNewFile();
		BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(outputFile, true));
		//write the execution time
		DateTimeFormatter currentDateAndTime = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		outputFileWriter.write("("+currentDateAndTime.format(now)+")"); outputFileWriter.newLine(); outputFileWriter.newLine();
		for (Topics topic : topicDetails) //for each topic
		{
			topic.printTopic(outputFileWriter); //print the current topic
			//print large topic separators
			outputFileWriter.write("=================================================================================================="); outputFileWriter.newLine();
			outputFileWriter.write("=================================================================================================="); outputFileWriter.newLine();
			outputFileWriter.newLine();			outputFileWriter.newLine();
		}
		outputFileWriter.newLine();		outputFileWriter.newLine();		outputFileWriter.newLine();		outputFileWriter.close();

		//write folder wise counts and total count
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

		int bullet = 1;
		//write question and solution details
		for (Topics topic : topicDetails)
		{
			fileWriter.write("## "+topic.getTopicName()); fileWriter.newLine(); fileWriter.newLine();
			fileWriter.write("|  #  | Title           |  Links          |  Solution       |"); fileWriter.newLine();
			fileWriter.write("|-----|---------------- | --------------- | --------------- |"); fileWriter.newLine();

			HashMap<String,Integer> questionIndexMap = topic.getQuestionIndexMap(); //get the question to index map
			Questions[] indexDetailsMap = topic.getIndexDetailsMap(); //get the index to details map

			Iterator questionIndexMapIterator = questionIndexMap.entrySet().iterator(); //map iterator
			while (questionIndexMapIterator.hasNext()) //for each entry in question map
			{
				fileWriter.write("|  "+(bullet++)+"  |"); //write the number
				int questionIndex = (Integer)((Map.Entry)questionIndexMapIterator.next()).getValue(); //get the index
				Questions currentQuestion = indexDetailsMap[questionIndex]; //get the current question from array
				String currentQuestionName = frameQuestion(currentQuestion.getQuestionKey()); //get the key and transform it to title case
				fileWriter.write(currentQuestionName+"|"); //write the question key

				HashMap<String,Integer> currentQuestionLinks = currentQuestion.getQuestionLinks(); //get question links
				Iterator questionLinkIterator = currentQuestionLinks.entrySet().iterator(); //question links iterator
				HashMap<String,String> currentSolutionLinks = currentQuestion.getSolutionLinks(); //get solution links
				Iterator solutionLinkIterator = currentSolutionLinks.entrySet().iterator(); //solution links iterator

				int questionLinkCount = 0;
				while (questionLinkIterator.hasNext()) //for each question link
				{
					String currentQuestionLink = (String)((Map.Entry)questionLinkIterator.next()).getKey(); //get the link
					currentQuestionLink = extractProperLink(currentQuestionLink); //trim the link
					questionLinkCount = getLinkName(currentQuestionLink); //get the platform name
					fileWriter.write("["+(questionLinkCount == 1 ? "LC" :
											questionLinkCount == 2 ? "GFG" :
												questionLinkCount == 3 ? "HR" :
													questionLinkCount == 4 ? "IB" : "CF")+"]("+currentQuestionLink+") "); //write the link
				}
				fileWriter.write("|");
				while (solutionLinkIterator.hasNext())
				{
					Map.Entry solutionLink = (Map.Entry)solutionLinkIterator.next();
					fileWriter.write("["+(String)solutionLink.getKey()+"]("+(String)solutionLink.getValue()+") ");
				}
				fileWriter.write("|");
				fileWriter.newLine();
			}

			bullet = 1;
		}

		fileWriter.close();
	}

	public static String frameQuestion(String str)
	{
		String[] tokens = str.trim().split("-");
		StringBuffer question = new StringBuffer();
		StringBuffer temp = new StringBuffer();
		for (String token : tokens)
		{
			char firstChar = token.charAt(0);
			firstChar = (char)(((int)firstChar)-32);
			temp = new StringBuffer(Character.toString(firstChar));
			temp.append(token.substring(1));
			question.append(temp);
			question.append(" ");
		}
		return question.toString().trim();
	}

	public static int getLinkName(String str)
	{
		String[] tokens = str.split("/");
		for (int i = 0; i < tokens.length; ++i)
		{
			String token = tokens[i];
			if (token.equals("leetcode.com")) return 1;
			else if (token.equals("practice.geeksforgeeks.org")) return 2;
			else if (token.equals("www.hackerrank.com")) return 3;
			else if (token.equals("www.interviewbit.com")) return 4;
			else if (token.equals("codeforces.com")) return 5;
		}
		return -1;
	}

	public static String extractProperLink(String str)
	{
		StringBuilder buffer = new StringBuilder(str.trim());

		//starting part
		if (buffer.charAt(0) == '/') //covers both // case and /* case
		{
			buffer.deleteCharAt(0);
			buffer.deleteCharAt(0);
		}
		else if (buffer.charAt(0) == '*') //covers multi line comments case
			buffer.deleteCharAt(0);

		//ending part
		if (buffer.charAt(buffer.length()-2) == '*' && buffer.charAt(buffer.length()-1) == '/')
		{
			buffer.deleteCharAt(buffer.length()-1);
			buffer.deleteCharAt(buffer.length()-1);
		}
		return buffer.toString().trim();
	}

	public static int isALink(String str)
	{
		String[] tokens = str.split("/");
		for (int i = 0; i < tokens.length; ++i)
		{
			String token = tokens[i];
			if (token.equals("leetcode.com") || token.equals("practice.geeksforgeeks.org") || token.equals("www.hackerrank.com") || token.equals("www.interviewbit.com"))
				return i+2; //question name appears after two indices
			else if (token.equals("codeforces.com"))
				return (i+3)*(-1); //question name appears after three indices
		}
		return -1;
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
			writer.write("# Topicwise-Solutions-To-Coding-Questions"); writer.newLine(); writer.newLine();
			writer.write("Solutions to the algorithmic problems in [LeetCode](https://leetcode.com/problemset/algorithms/), [GeeksForGeeks](https://practice.geeksforgeeks.org/explore/?problemType=full&page=1), [Hackerrank](https://www.hackerrank.com/domains/algorithms?filters%5Bstatus%5D%5B%5D=unsolved&badge_type=problem-solving), [Interviewbit](https://www.interviewbit.com/courses/programming/) and [Codeforces](https://codeforces.com/problemset) written in **C++** and **JAVA**"); writer.newLine(); writer.newLine();
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