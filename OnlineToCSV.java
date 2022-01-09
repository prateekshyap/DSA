import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

class OnlineToCSV
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("README.md"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("ZInfo/OnlineInfo.csv"));
		String nextLine = "";
		while ((nextLine = reader.readLine()) != null)
		{
			if (nextLine.equals("## Arrays")) break;
		}
		while ((nextLine = reader.readLine()) != null)
		{
			String[] tokens = nextLine.split("[|]");
			if (tokens.length == 6)
			{
				String[] linkParts = tokens[3].split("/");
				for (int i = 0; i < linkParts.length; ++i)
				{
					String linkPart = linkParts[i];
					if (linkPart.equals("practice.geeksforgeeks.org"))
					{
						writer.write(linkParts[i+2]+","+tokens[5]);
						writer.newLine();
						break;
					}
				}
				//writer.write();
				//writer.write(",");
				//writer.write();
				//writer.newLine();
			}
		}
		reader.close();
		writer.close();
	}
}