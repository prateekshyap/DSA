import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class TrieNode
{
	TrieNode[] hash;
	boolean isEndOfWord;
	TrieNode()
	{
		hash = new TrieNode[128];
		isEndOfWord = true;
	}
}

class Trie
{
	TrieNode root;
	Trie()
	{
		root = new TrieNode();
	}
	public void add(String keyword)
	{
		TrieNode temp = root;
		for (char ch : keyword.toCharArray())
		{
			if (temp.hash[ch] == null)
				temp.hash[ch] = new TrieNode();
			temp = temp.hash[ch];
		}
		temp.isEndOfWord = true;
	}
	public String search(String keyword)
	{
		TrieNode temp = root;
		StringBuffer returnKeyword = new StringBuffer("");
		for (int i = 0; i < keyword.length(); ++i)
		{
			char ch = keyword.charAt(i);
			if (temp.hash[ch] == null)
				return "";
			temp = temp.hash[ch];
			returnKeyword.append(ch);
			if (temp.isEndOfWord && i+1 < keyword.length() && !(keyword.charAt(i+1) >= 'a' && keyword.charAt(i+1) <= 'z') && !(keyword.charAt(i+1) >= 'A' && keyword.charAt(i+1) <= 'Z'))
				return returnKeyword.toString();
		}
		return temp.isEndOfWord ? returnKeyword.toString() : "";
	}
}

class OnlineInfo
{
	TreeMap<String,String> questionDifficultyMap;
	OnlineInfo()
	{
		this.questionDifficultyMap = new TreeMap<String,String>();
		try{
		BufferedReader reader = new BufferedReader(new FileReader("ZInfo/OnlineInfo.csv"));
		String nextLine = "";
		while ((nextLine = reader.readLine()) != null)
		{
			String[] tokens = nextLine.split(",");
			this.questionDifficultyMap.put(tokens[0],tokens[1]);
		}
		reader.close();
		}
		catch(IOException ie)
		{}
	}

	//getter methods
	public TreeMap<String,String> getQuestionDifficultyMap() { return this.questionDifficultyMap; }

	//updater methods
	public TreeMap<String,String> updateFile(String questionKey, String difficulty) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter("ZInfo/OnlineInfo.csv",true));
		writer.write(questionKey);
		writer.write(",");
		writer.write(difficulty);
		writer.newLine();
		writer.close();
		this.questionDifficultyMap = new TreeMap<String,String>();
		BufferedReader reader = new BufferedReader(new FileReader("ZInfo/OnlineInfo.csv"));
		String nextLine = "";
		while ((nextLine = reader.readLine()) != null)
		{
			String[] tokens = nextLine.split(",");
			this.questionDifficultyMap.put(tokens[0],tokens[1]);
		}
		reader.close();
		return this.questionDifficultyMap;
	}
}

class Questions
{
	private String questionKey;
	private TreeMap<String,Integer> questionLinks;
	private TreeMap<String,String> solutionLinks;
	private String difficulty;

	Questions(String key, TreeMap<String,Integer> qLinks, String sLink, String difficulty)
	{
		this.questionKey = key;
		this.questionLinks = qLinks;
		this.solutionLinks = new TreeMap<String,String>();
		if (sLink.charAt(sLink.length()-1) == 'a') //java
			this.solutionLinks.put("Java",sLink);
		else if (sLink.charAt(sLink.length()-1) == 'p') //cpp
			this.solutionLinks.put("CPP",sLink);
		else if (sLink.charAt(sLink.length()-1) == 'y') //python
			this.solutionLinks.put("Python",sLink);
		this.difficulty = difficulty;
	}

	//getter methods
	public String getQuestionKey() { return this.questionKey; }
	public TreeMap<String,Integer> getQuestionLinks() { return this.questionLinks; }
	public TreeMap<String,String> getSolutionLinks() { return this.solutionLinks; }
	public String getDifficulty() { return this.difficulty; }

	//solution link updation
	public void addSolutionLink(String sLink)
	{
		if (sLink.charAt(sLink.length()-1) == 'a') //java
			this.solutionLinks.put("Java",sLink);
		else if (sLink.charAt(sLink.length()-1) == 'p') //cpp
			this.solutionLinks.put("CPP",sLink);
		else if (sLink.charAt(sLink.length()-1) == 'y') //python
			this.solutionLinks.put("Python",sLink);
	}

	public void printQuestion(BufferedWriter writer) throws IOException
	{
		writer.write("Question-"+questionKey); writer.newLine();
		Iterator linkIterator = questionLinks.entrySet().iterator(); //question links iterator
		writer.write("Question links-"); writer.newLine();
		while (linkIterator.hasNext()) //for each entry
		{
			Map.Entry questionLink = (Map.Entry)linkIterator.next(); //get the entry
			writer.write((String)questionLink.getKey()); writer.newLine(); //write the link
		}
		linkIterator = solutionLinks.entrySet().iterator(); //solution links iterator
		writer.write("Solution links-"); writer.newLine();
		while (linkIterator.hasNext()) //for each entry
		{
			Map.Entry solutionLink = (Map.Entry)linkIterator.next(); //get the entry
			writer.write((String)solutionLink.getValue()); writer.newLine(); //write the link
		}
	}
}

class Topics
{
	private String topic; //name of the topic/directory
	private int javaCount; //total number of .java files
	private int cppCount; //total number of .cpp files
	private int pyCount; //total number of .py files
	private TreeMap<String,Integer> questionIndexMap; //stores the question key and the index of indexDetailsMap array
	protected Questions[] indexDetailsMap; //stores the details for each question in an array
	protected int qIndex;

	Topics()
	{}

	Topics(String topic, int noq)
	{
		this.topic = topic;
		javaCount = cppCount = pyCount = 0;
		questionIndexMap = new TreeMap<String,Integer>();
		indexDetailsMap = new Questions[noq];
		qIndex = 0;
	}

	//setter methods
	public void setJavaCount(int count) { this.javaCount = count; }
	public void setCppCount(int count) { this.cppCount = count; }
	public void setPyCount(int count) { this.pyCount = count; }

	//getter methods
	public String getTopicName() { return this.topic; }
	public int getJavaCount() { return this.javaCount; }
	public int getCppCount() { return this.cppCount; }
	public int getPyCount() { return this.pyCount; }
	public TreeMap<String,Integer> getQuestionIndexMap() { return this.questionIndexMap; }
	public Questions[] getIndexDetailsMap() { return this.indexDetailsMap; }

	public String getQuestionKey(String link, int nameIndex)
	{
		String[] tokens = link.split("/"); //split by "/"
		for (int i = 0; i < tokens.length; ++i)
		{
			System.out.print("'"+tokens[i]+"',");
		}
		System.out.println();
		String questionKey = "";
		if (nameIndex < 0) //for codeforces, attach two elements
		{
			questionKey += tokens[Math.abs(nameIndex)];
			questionKey += "-";
			questionKey += tokens[Math.abs(nameIndex)+1];
		}
		else //for others, attach one element
		{
			questionKey += tokens[nameIndex];
		}
		return questionKey;
	}

	//methods for adding questions
	public void addQuestion(TreeMap<String,Integer> links, String topic, String program, String difficulty)
	{
		String link = "";
		int nameIndex = -1;
		Iterator linkIterator = links.entrySet().iterator(); //iterator for question links
		if (linkIterator.hasNext()) //for the first entry in links
		{
			Map.Entry linkDetails = (Map.Entry)linkIterator.next(); //get the entry
			link = (String)linkDetails.getKey(); //get the link
			nameIndex = (Integer)linkDetails.getValue(); //get the index of the question in the array splitted by "/"
		}
		String questionKey = getQuestionKey(link,nameIndex);

		//get the solution link
		String solutionLink = "./";
		solutionLink += topic;
		solutionLink += "/";
		solutionLink += program;

		//check existence of the current question
		boolean exists = false;
		String existingQuestionKey = "";
		Iterator questionIndexMapIterator = questionIndexMap.entrySet().iterator(); //question to index map iterator
		while (questionIndexMapIterator.hasNext()) //for each entry in the map
		{
			int questionIndex = (Integer)((Map.Entry)questionIndexMapIterator.next()).getValue(); //get the current question index
			Questions currentQuestion = indexDetailsMap[questionIndex]; //get the current question
			TreeMap<String,Integer> currentQuestionLinks = currentQuestion.getQuestionLinks(); //get the question links
			Iterator questionLinkIterator = currentQuestionLinks.entrySet().iterator(); //question links iterator
			while (questionLinkIterator.hasNext()) //for each entry in the question links
			{
				String currentQuestionLink = (String)((Map.Entry)questionLinkIterator.next()).getKey(); //get the link
				String[] currentTokens = currentQuestionLink.split("/"); //split by "/"
				/*for (String currentToken : currentTokens) //for each token
				{
					if (currentToken.equals(questionKey)) //if the current token matches with the question key created above
					{
						exists = true; //mark exists
						existingQuestionKey = currentQuestion.getQuestionKey(); //get the current question key and store
					}
				}*/
				for (int i = 0; i < currentTokens.length; ++i)
				{
					String currentToken = currentTokens[i];
					if (currentToken.equals(questionKey)) //if the current token matches with the question key created above
					{
						exists = true; //mark exists
						existingQuestionKey = currentQuestion.getQuestionKey(); //get the current question key and store
					}
					else if (i < currentTokens.length-1)
					{
						if ((currentToken+"-"+currentTokens[i+1]).equals(questionKey))
						{
							exists = true; //mark exists
							existingQuestionKey = currentQuestion.getQuestionKey(); //get the current question key and store
						}
					}
				}
			}
		}

		System.out.println(questionKey);
		if (exists)
		{
			int questionIndex = (Integer)questionIndexMap.get(existingQuestionKey); //get the existing question index
			indexDetailsMap[questionIndex].addSolutionLink(solutionLink); //add new solution to the existing question
		}
		else //if question does not exist
		{
			Questions question = new Questions(questionKey,links,solutionLink,difficulty); //create a new question with all data provided
			indexDetailsMap[qIndex] = question; //store in index to details map
			questionIndexMap.put(questionKey,qIndex); //add the index to question to index map
			++qIndex; //increase index
		}
	}

	public void printTopic(BufferedWriter writer) throws IOException
	{
		writer.write("TOPIC NAME: "+this.topic); writer.newLine();
		writer.write("Java files: "+this.javaCount); writer.newLine();
		writer.write("CPP files: "+this.cppCount); writer.newLine();
		writer.write("Python files: "+this.pyCount); writer.newLine();
		writer.write("---------------------------------------------------------------------------------"); writer.newLine();
		Iterator linkIterator = this.questionIndexMap.entrySet().iterator(); //question to index map iterator
		int bullet = 1;
		while (linkIterator.hasNext()) //for each entry in the map
		{
			Map.Entry questionAndIndex = (Map.Entry)linkIterator.next(); //get the current entry
			int index = (Integer)questionAndIndex.getValue(); //get the index
			Questions question = indexDetailsMap[index]; //get the current question
			writer.write((bullet++)+"."); writer.newLine(); //print a number
			question.printQuestion(writer); //print the current question
			writer.newLine();
		}
	}
}

class Parse extends Topics
{
	private Trie javaKeywords, cppKeywords, javaPrimitiveDatatypes, cppDataTypes, cppModifiers, javaUserDatatypes, cppUserDatatypes, javaClasses, javaCollections;
	private int[] time, space;
	
	Parse(Topics topic) throws IOException
	{
		time = new int[topic.indexDetailsMap.length];
		space = new int[topic.indexDetailsMap.length];
		javaKeywords = new Trie();
		cppKeywords = new Trie();
		javaPrimitiveDatatypes = new Trie();
		cppDataTypes = new Trie();
		cppModifiers = new Trie();
		javaUserDatatypes = new Trie();
		cppUserDatatypes = new Trie();
		javaClasses = new Trie();
		javaCollections = new Trie();
	
		String nextLine = "";

		//java
		BufferedReader reader = new BufferedReader(new FileReader(new File("ZInfo/JavaKeywords.txt")));
		while ((nextLine = reader.readLine()) != null)
			javaKeywords.add(nextLine);

		reader = new BufferedReader(new FileReader(new File("ZInfo/JavaClasses.txt")));
		while ((nextLine = reader.readLine()) != null)
			javaClasses.add(nextLine);

		reader = new BufferedReader(new FileReader(new File("ZInfo/JavaCollections.txt")));
		while ((nextLine = reader.readLine()) != null)
			javaCollections.add(nextLine);

		reader = new BufferedReader(new FileReader(new File("ZInfo/JavaPrimitiveDataTypes.txt")));
		while ((nextLine = reader.readLine()) != null)
			javaPrimitiveDatatypes.add(nextLine);


		//cpp
		reader = new BufferedReader(new FileReader(new File("ZInfo/CppKeywords.txt")));
		while ((nextLine = reader.readLine()) != null)
			cppKeywords.add(nextLine);

		reader = new BufferedReader(new FileReader(new File("ZInfo/CppModifiers.txt")));
		while ((nextLine = reader.readLine()) != null)
			cppModifiers.add(nextLine);

		reader = new BufferedReader(new FileReader(new File("ZInfo/CppPrimitiveDataTypes.txt")));
		while ((nextLine = reader.readLine()) != null)
			cppDataTypes.add(nextLine);


		reader.close();
	}

	public int[] getTimeComplexities() { return this.time; }
	public int[] getSpaceComplexities() { return this.space; }

	public void parseFile(String fileName, String program, Topics topic) throws IOException
	{
		if (program.charAt(program.length()-1) == 'a')
		{
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			String prevLine = "", currLine = "", nextLine = "";
			Stack<Character> stack = new Stack<Character>();
			Stack<String> control = new Stack<String>();
			Stack<String> loop = new Stack<String>();
			int openCurlyBracesCount = 0;
			String currentControl = "";
			int power = 0, maxPower = 0;
			nextLine = reader.readLine();
			nextLine = nextLine.trim();
			currLine = nextLine;

			while (currLine != null)
			{
				nextLine = reader.readLine();
				if (nextLine != null)
				{
					nextLine = nextLine.trim();
					if (nextLine.length() == 0) continue;
				}
				if (openCurlyBracesCount < 2)
				{
					if (openCurlyBracesCount == 1) //if only class is encountered, no methods encountered or method finished
					{
						String[] tokens = currLine.trim().split(" +");
						if (tokens.length > 1 && tokens[0].length() > 1)
						{
							tokens[0] = tokens[0].trim();
							/*extract data types declared within class outside method*/
						}
					}
					for (char ch : currLine.toCharArray())
					{
						if (ch == '}')
						{
							--openCurlyBracesCount;
							stack.pop();
							control.pop();
						}
						if (ch == '{')
						{
							++openCurlyBracesCount;
							stack.push('{');
						}
						if (openCurlyBracesCount == 1) 
						{
							control.push("class");
							currentControl = control.peek();
						}
						if (openCurlyBracesCount == 2)
						{
							control.push("method");
							currentControl = control.peek();
							break;
						}
					}
				}
				else
				{
					if (javaKeywords.search(currLine).equals("for") || javaKeywords.search(currLine).equals("while"))
					{
						currentControl = javaKeywords.search(currLine);
						if (currLine.charAt(currLine.length()-1) == '{' || nextLine.charAt(0) == '{')
						{
							++power;
							maxPower = Math.max(maxPower,power);
						}
						else
							maxPower = Math.max(maxPower,power+1);
					}
					for (char ch : currLine.toCharArray())
					{
						if (ch == '{')
						{
							++openCurlyBracesCount;
							stack.push('{');
							control.push(currentControl);
						}
					}
					if (currLine.charAt(0) == '}' || currLine.charAt(currLine.length()-1) == '}')
					{
						--openCurlyBracesCount;
						stack.pop();
						String top = control.pop();
						currentControl = control.peek();
						if (top.equals("for") || top.equals("while")) --power;
					}
				}

				prevLine = currLine;
				currLine = nextLine;
			}

			reader.close();

			time[topic.qIndex-1] = maxPower;
			//store space complexity here
		}
		else if (program.charAt(program.length()-1) == 'p')
		{}
	}
}

class UpdateReadme
{
	public static void main(String[] args) throws IOException
	{
		//important declarations
		String mainPathStr = "E:\\DSA\\Coding"; //pp system
		// String mainPathStr = "C:\\PP\\coding\\DSA"; //iitg lab system
		File mainPath = new File(mainPathStr);
		Topics[] topicDetails; //main arrat that stores all the details of the folder

		//read online information
		OnlineInfo onlineInfo = new OnlineInfo();
		TreeMap<String,String> questionDifficultyMap = onlineInfo.getQuestionDifficultyMap();

		//
		Parse[] parseDetails;

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
		topicDetails = new Topics[dirCount-1];
		parseDetails = new Parse[dirCount-1];
		int index = 0;

		for (String topic : topics) //for each topic
		{
			if (!containsDot(topic) && !topic.equals("ZInfo")) //if it doesn't contain a dot that means it is a directory
			{
				//get the topic directory path
				String topicPathStr = new String(mainPathStr);
				topicPathStr += "\\";
				topicPathStr += topic;
				File topicPath = new File(topicPathStr);

				String[] programs = topicPath.list(); //list the files in that folder
				int javaCount = 0, cppCount = 0, pyCount = 0;

				topicDetails[index] = new Topics(topic,programs.length); //create a new topic
				parseDetails[index] = new Parse(topicDetails[index]);

				//store java and cpp counts
				for (String program : programs) //for each file
				{
					if (program.equals("dummy.txt")) continue; //ignore txt files
					if (program.charAt(program.length()-1) == 'p') ++cppCount; //increase cpp count
					if (program.charAt(program.length()-1) == 'a') ++javaCount; //increase java count
					if (program.charAt(program.length()-1) == 'y') ++pyCount; //increase py count
					
					//get the file path
					String codeFileName = new String(topicPathStr);
					codeFileName += "\\";
					codeFileName += program;
					File codeFile = new File(codeFileName);

					System.out.println(codeFileName);

					//open a reader to read the code file
					BufferedReader reader = new BufferedReader(new FileReader(codeFile));

					String nextLine = "", difficulty = "";
					TreeMap<String,Integer> questionLinks = new TreeMap<String,Integer>(); //stores the question links and their indices after splitting from "/"
					while ((nextLine = reader.readLine()) != null) //for each line
					{
						int nameIndex = isALink(nextLine); //get the index of the question
						if (nameIndex != -1) //if the index is not -1
						{
							nextLine = extractProperLink(nextLine);
							nameIndex = isALink(nextLine);
							questionLinks.put(nextLine,nameIndex); //add to map
							/*
							// one time full online updation done, no need to uncomment
							if (getLinkName(nextLine) == 2) //for GFG links
							{
								System.out.println(nextLine);
								System.setProperty("http.proxyHost", "127.0.0.1");
 						       	System.setProperty("http.proxyPort", "8182");
      							Document document = Jsoup.connect(nextLine).get();
								Elements strongs = document.getElementsByTag("strong");
								for (Element strong : strongs)
								{
									if (strong.attr("class").equals("problem-tab__problem-level"))
									difficulty = strong.text();
								}
							}*/
							if (getLinkName(nextLine) == 2) //for GFG links
							{
								String gfgQuestionKey = new Topics().getQuestionKey(nextLine,nameIndex);
								if (questionDifficultyMap.containsKey(gfgQuestionKey)) //if old gfg question
									difficulty = questionDifficultyMap.get(gfgQuestionKey); //retrieve data from map
								else //if new gfg question
								{
									//get info from webpage
									System.setProperty("http.proxyHost", "127.0.0.1");
	 						       	System.setProperty("http.proxyPort", "8182");
	      							Document document = Jsoup.connect(nextLine).get();
									Elements strongs = document.getElementsByTag("span");
									int points = 0;
									for (Element strong : strongs)
									{
										if (strong.attr("class").equals("problem-tab__value") && (strong.text().trim().equals("1") || strong.text().trim().equals("2") || strong.text().trim().equals("4") || strong.text().trim().equals("8")))
											points = Integer.parseInt(strong.text());
									}
									difficulty = points == 1 ? "Basic" :
													points == 2 ? "Easy" :
														points == 4 ? "Medium" :
															points == 8 ? "Hard" : "null";
									//update the online info file
									questionDifficultyMap = onlineInfo.updateFile(gfgQuestionKey,difficulty);
								}
							}
						}
					}
					topicDetails[index].addQuestion(questionLinks,topic,program,difficulty); //add the question to the main array
					parseDetails[index].parseFile(codeFileName,program,topicDetails[index]);
					reader.close();
				}
				topicDetails[index].setJavaCount(javaCount);
				topicDetails[index].setCppCount(cppCount);
				topicDetails[index].setPyCount(pyCount);

				++index;
			}
		}

		//write the data to a txt file for future reference
		File outputFile = new File("ZInfo/ConsoleOutput.txt");
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
		fileWriter.write("| Topic Name | Java | CPP | Python | "); fileWriter.newLine();
		fileWriter.write("| :--------: | :--------: | :--------: | :--------: | "); fileWriter.newLine();
		int totalJava = 0, totalCpp = 0, totalPython = 0;
		for (Topics topic : topicDetails)
		{
			fileWriter.write("| ["+topic.getTopicName()+"](https://github.com/prateekshyap/DSA#"+topic.getTopicName().toLowerCase()+") | "+topic.getJavaCount()+" | "+topic.getCppCount()+" | "+topic.getPyCount()+" |"); fileWriter.newLine();
			totalJava += topic.getJavaCount(); totalCpp += topic.getCppCount(); totalPython += topic.getPyCount();
		}
		fileWriter.write("| Total | "+totalJava+" | "+totalCpp+" | "+totalPython+" |"); fileWriter.newLine(); fileWriter.newLine();

		//write next fixed segment
		printFixedMessage(fileWriter,2);

		int bullet = 1;
		//write question and solution details
		for (int i = 0; i < topicDetails.length; ++i)
		{
			Topics topic = topicDetails[i];
			Parse parse = parseDetails[i];
			fileWriter.write("## "+topic.getTopicName()); fileWriter.newLine(); fileWriter.newLine();
			fileWriter.write("|  #  |Title            |Links            |Solution         |Difficulty       |Time Complexity  |Space Complexity |"); fileWriter.newLine();
			fileWriter.write("|-----|---------------- |---------------- |---------------- |---------------- |---------------- |---------------- |"); fileWriter.newLine();

			TreeMap<String,Integer> questionIndexMap = topic.getQuestionIndexMap(); //get the question to index map
			Questions[] indexDetailsMap = topic.getIndexDetailsMap(); //get the index to details map
			int[] timeComplexities = parse.getTimeComplexities();
			//get space complexity here

			Iterator questionIndexMapIterator = questionIndexMap.entrySet().iterator(); //map iterator
			while (questionIndexMapIterator.hasNext()) //for each entry in question map
			{
				fileWriter.write("|  "+(bullet++)+"  |"); //write the number
				int questionIndex = (Integer)((Map.Entry)questionIndexMapIterator.next()).getValue(); //get the index
				Questions currentQuestion = indexDetailsMap[questionIndex]; //get the current question from array
				String currentQuestionName = frameQuestion(currentQuestion.getQuestionKey()); //get the key and transform it to title case
				fileWriter.write(currentQuestionName+"|"); //write the question key

				TreeMap<String,Integer> currentQuestionLinks = currentQuestion.getQuestionLinks(); //get question links
				Iterator questionLinkIterator = currentQuestionLinks.entrySet().iterator(); //question links iterator
				TreeMap<String,String> currentSolutionLinks = currentQuestion.getSolutionLinks(); //get solution links
				Iterator solutionLinkIterator = currentSolutionLinks.entrySet().iterator(); //solution links iterator

				int questionLinkCount = 0;
				while (questionLinkIterator.hasNext()) //for each question link
				{
					String currentQuestionLink = (String)((Map.Entry)questionLinkIterator.next()).getKey(); //get the link
					//currentQuestionLink = extractProperLink(currentQuestionLink); //trim the link
					questionLinkCount = getLinkName(currentQuestionLink); //get the platform name
					fileWriter.write("["+(questionLinkCount == 1 ? "LC" :
											questionLinkCount == 2 ? "GFG" :
												questionLinkCount == 3 ? "HR" :
													questionLinkCount == 4 ? "IB" : 
														questionLinkCount == 5 ? "CF" : 
															questionLinkCount == 6 ? "BS" : "LC2")+"]("+currentQuestionLink+") "); //write the link
				}
				fileWriter.write("|");
				while (solutionLinkIterator.hasNext())
				{
					Map.Entry solutionLink = (Map.Entry)solutionLinkIterator.next();
					System.out.println("["+(String)solutionLink.getKey()+"]("+(String)solutionLink.getValue()+") ");
					fileWriter.write("["+(String)solutionLink.getKey()+"]("+(String)solutionLink.getValue()+") ");
				}
				fileWriter.write("|"+currentQuestion.getDifficulty()+"|");
				if (timeComplexities[questionIndex] == 0)
					fileWriter.write("O(1)");
				else if (timeComplexities[questionIndex] == 1)
					fileWriter.write("O(n)");
				else
					fileWriter.write("O(n<sup>"+timeComplexities[questionIndex]+"</sup>)");
				fileWriter.write("|");
				//write space complexity
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
		boolean flag = false;
		for (String token : tokens)
		{
			if (token.length() == 0) continue;
			char firstChar = token.charAt(0);
			if (firstChar >= 'a' && firstChar <= 'z') firstChar = (char)(((int)firstChar)-32);
			temp = new StringBuffer(Character.toString(firstChar));
			temp.append(token.substring(1));
			question.append(temp);
			question.append(" ");
		}
		//if (flag) System.out.println("'"+question.toString().trim()+"'");
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
			else if (token.equals("binarysearch.com")) return 6;
			else if (token.equals("www.lintcode.com")) return 7;
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
			if (token.equals("leetcode.com") || token.equals("practice.geeksforgeeks.org") || token.equals("www.hackerrank.com") || token.equals("www.interviewbit.com") || token.equals("binarysearch.com") || token.equals("www.lintcode.com"))
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
			writer.write("If you want to update the readme file as well, you have to install [Java](https://www.tutorialspoint.com/java/java_environment_setup.htm) and [Jsoup](https://www.tutorialspoint.com/jsoup/jsoup_environment.htm). Then you can run the [UpdateReadme.java](./UpdateReadme.java) file to update the readme file."); writer.newLine(); writer.newLine();
			writer.write("## When to contribute?"); writer.newLine(); writer.newLine();
			writer.write("1. If there is no solution to a problem in the main branch"); writer.newLine();
			writer.write("2. If your solution is asymptotically faster than the one in the main branch"); writer.newLine();
			writer.write("3. If your algorithm is of the same time complexity but with reduced code size (In this case, comment out the original solution and make a pull request with your solution.)"); writer.newLine();
			writer.write("4. If you have another method of solving the problem which is asymptotically slower than the original method (In this case, comment your solution in the main file and make a pull request.)"); writer.newLine();
			writer.write("5. If you want to update the [UpdateReadme.java](./UpdateReadme.java) file"); writer.newLine(); writer.newLine();
			writer.write("## Format for solution files"); writer.newLine(); writer.newLine();
			writer.write("1. Paste the link for the question within comments."); writer.newLine();
			writer.write("2. Paste the solution."); writer.newLine();
			writer.write("3. Save with proper extension name."); writer.newLine(); writer.newLine();
			writer.write("## Description of auto-updation of Readme file"); writer.newLine(); writer.newLine();
			writer.write("[UpdateReadme.java](./UpdateReadme.java) is the main file. It reads information (that are obtained online) from [OnlineInfo.csv](./OnlineInfo.csv) file. If you have updated the readme file with some online information without adding into csv file, then you need to run [OnlineToCSV.java](./OnlineToCSV.java) file to read that from readme and store in the csv file."); writer.newLine(); writer.newLine();
			writer.write("For difficulty level, csv file is already updated. For other online information columns you'll have to update it."); writer.newLine(); writer.newLine();
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