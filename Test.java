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

class Parse
{
	Trie javaKeywords, cppKeywords, javaPrimitiveDatatypes, cppDataTypes, cppModifiers, javaUserDatatypes, cppUserDatatypes, javaClasses, javaCollections;
	Parse() throws IOException
	{
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

	public static void main(String[] args) throws IOException
	{
		Parse parse  = new Parse();
		//important declarations
		String mainPathStr = "E:\\DSA\\Coding";
		File mainPath = new File(mainPathStr);

		String[] topics = mainPath.list();
		
		int dirCount = 0;
		for (String topic : topics)
			if (!containsDot(topic)) ++dirCount;

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

				for (String program : programs) //for each file
				{
					if (program.equals("dummy.txt")) continue; //ignore txt files

					String codeFileName = new String(topicPathStr);
					codeFileName += "\\";
					codeFileName += program;
					File codeFile = new File(codeFileName);

					parse.parseFile(codeFileName, program);					
				}
			}
		}
	}

	public void parseFile(String fileName, String program) throws IOException
	{
		if (program.charAt(program.length()-1) == 'a')
		{
			System.out.println("\n\n"+fileName);
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
				/*if (program.equals("AddOne.java"))
				{
					System.out.print("'"+currLine+"' ("+power+")");
				}*/
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
							//control.push(currentControl);
							//stack.push('{');
							++power;
							maxPower = Math.max(maxPower,power);
						}
						else
						{
							maxPower = Math.max(maxPower,power+1);
						}
					}
					/*if (currLine.charAt(0) == '{' || currLine.charAt(currLine.length()-1) == '{')
					{
						stack.push('{');
						control.push("");
					}*/
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
						/*if (program.equals("AddOne.java"))
						{
							System.out.print("("+top+")");
						}*/
						if (top.equals("for") || top.equals("while")) --power;
						/*else if (top.equals("method") || top.equals("class")) 
						{
							power = 0;
							maxPower = 0;
						}*/
					}
				}

				prevLine = currLine;
				currLine = nextLine;
				//System.out.println();
			}

			reader.close();
			System.out.println("time complexity - "+maxPower);
		}
	}


	public static boolean containsDot(String str)
	{
		for (int i = 0; i < str.length(); ++i)
			if (str.charAt(i) == '.')
				return true;
		return false;
	}

	private int isAKeyWord(String str, String fileName)
	{
		if (fileName.charAt(fileName.length()-1) == 'a' && (str.equals("abstract") || str.equals("assert") || str.equals("boolean") || str.equals("break") || str.equals("byte") || str.equals("case") || str.equals("catch") || str.equals("char") || str.equals("class") || str.equals("const") || str.equals("continue") || str.equals("default") || str.equals("do") || str.equals("double") || str.equals("else") || str.equals("extends") || str.equals("false") || str.equals("final") || str.equals("finally") || str.equals("float") || str.equals("for") || str.equals("goto") || str.equals("if") || str.equals("implements") || str.equals("import") || str.equals("instanceof") || str.equals("int") || str.equals("interface") || str.equals("long") || str.equals("native") || str.equals("new") || str.equals("null") || str.equals("package") || str.equals("private") || str.equals("protected") || str.equals("public") || str.equals("return") || str.equals("short") || str.equals("static") || str.equals("strictfp") || str.equals("super") || str.equals("switch") || str.equals("synchronized") || str.equals("this") || str.equals("throw") || str.equals("throws") || str.equals("transient") || str.equals("true") || str.equals("try") || str.equals("void") || str.equals("volatile") || str.equals("while")))
			return 1;
		if (fileName.charAt(fileName.length()-1) == 'p' && (str.equals("asm") || str.equals("auto") || str.equals("break") || str.equals("case") || str.equals("catch") || str.equals("char") || str.equals("class") || str.equals("const") || str.equals("continue") || str.equals("default") || str.equals("delete") || str.equals("do") || str.equals("double") || str.equals("else") || str.equals("enum") || str.equals("extern") || str.equals("float") || str.equals("for") || str.equals("friend") || str.equals("goto") || str.equals("if") || str.equals("inline") || str.equals("int") || str.equals("long") || str.equals("new") || str.equals("operator") || str.equals("private") || str.equals("protected") || str.equals("public") || str.equals("register") || str.equals("return") || str.equals("short") || str.equals("signed") || str.equals("sizedof") || str.equals("static") || str.equals("struct") || str.equals("switch") || str.equals("template") || str.equals("this") || str.equals("throw") || str.equals("try") || str.equals("typedef") || str.equals("union") || str.equals("unsigned") || str.equals("virtual") || str.equals("void") || str.equals("volatile") || str.equals("while") || str.equals("using") || str.equals("namespace") || str.equals("std")))
			return 2;
		return 0;
	}
}