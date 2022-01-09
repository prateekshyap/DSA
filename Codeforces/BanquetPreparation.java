/*https://codeforces.com/problemset/problem/1607/H*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

public class BanquetPreparation
{
	static class Food
	{
		private int fish;
		private int meat;
		private int eatable;
		private int rem;
		private int index;

		Food(int a, int b, int m, int i)
		{
			this.fish = a;
			this.meat = b;
			this.eatable = m;
			this.index = i;
		}

		public void setFish(int value) { this.fish = value; }
		public int getFish() { return this.fish; }
		public void setMeat(int value) { this.meat = value; }
		public int getMeat() { return this.meat; }
		public void setEatable(int value) { this.eatable = value; }
		public int getEatable() { return this.eatable; }
		public void setRem(int value) { this.rem = value; }
		public int getRem() { return this.rem; }
		public void setIndex(int value) { this.index = value; }
		public int getIndex() { return this.index; }
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		int n = -1;
		String[] tokens;
		Food[] food;
		int result = -1;
		int[][] reductions;
		while (testCases-- > 0)
		{
			br.readLine();
			n = Integer.parseInt(br.readLine());
			food = new Food[n];
			reductions = new int[n][2];
			for (int i = 0; i < n; ++i)
			{
				tokens = br.readLine().trim().split(" +");
				food[i] = new Food(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),i);
			}
			HashSet<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < n; ++i)
			{
				int reminder = food[i].getFish()+food[i].getMeat()-food[i].getEatable();
				food[i].setRem(reminder);
				set.add(reminder);
			}
			result = set.size();
			Arrays.sort(food,new Comparator<Food>()
				{
					public int compare(Food food1, Food food2)
					{
						return food1.getRem()-food2.getRem();
					}
				});
			
			int index = 0;
			while (index < food.length)
			{
				ArrayList<Food> list = new ArrayList<Food>();
				Food currFood = food[index++];
				list.add(currFood);
				while (index < food.length && food[index].getRem() == currFood.getRem())
					list.add(food[index++]);
				if (list.size() == 1)
				{
					Food foodItem = list.get(0);
					reductions[foodItem.getIndex()][0] = foodItem.getFish();
					reductions[foodItem.getIndex()][1] = foodItem.getEatable()-foodItem.getFish();
					if (reductions[foodItem.getIndex()][1] < 0)
					{
						reductions[foodItem.getIndex()][0] += reductions[foodItem.getIndex()][1];
						reductions[foodItem.getIndex()][1] = 0;
					}
					continue;
				}
				int minIndex, maxIndex;
				boolean isEqual = false;
				if (list.get(0).getFish() <= list.get(0).getMeat())
				{
					minIndex = 0; maxIndex = 1;
					if (list.get(0).getFish() == list.get(0).getMeat())
					{
						isEqual = true;
						for (Food f : list)
						{
							if (f.getFish() != f.getMeat())
							{
								isEqual = false;
								break;
							}
						}
					}
				}
				else
				{
					minIndex = 1; maxIndex = 0;
				}
				int minValue = Integer.MAX_VALUE;
				for (Food foodItem : list)
					minValue = Math.min(minValue,minIndex == 0 ? foodItem.getFish() : foodItem.getMeat());
				for (int i = 0; i < list.size(); ++i)
				{
					if (minIndex == 0)
					{
						int currFishValue = list.get(i).getFish();
						list.get(i).setFish(minValue);
						list.get(i).setEatable(list.get(i).getEatable()-(currFishValue-minValue));
						reductions[list.get(i).getIndex()][0] = currFishValue-minValue;
						reductions[list.get(i).getIndex()][1] = list.get(i).getEatable();
						if (isEqual)
						{
							reductions[list.get(i).getIndex()][1] = Math.min(list.get(i).getEatable(),list.get(i).getMeat());
							list.get(i).setEatable(list.get(i).getEatable()-reductions[list.get(i).getIndex()][1]);
						}
					}
					else
					{
						int currMeatValue = list.get(i).getMeat();
						list.get(i).setMeat(minValue);
						list.get(i).setEatable(list.get(i).getEatable()-(currMeatValue-minValue));
						reductions[list.get(i).getIndex()][0] = list.get(i).getEatable();
						reductions[list.get(i).getIndex()][1] = currMeatValue-minValue;
					}
				}
				if (isEqual)
				{
					for (int i = 0; i < list.size(); ++i)
					{
						reductions[list.get(i).getIndex()][0] = list.get(i).getEatable();
					}
				}
			}

			System.out.println(result);
			for (int i = 0; i < n; ++i)
			{
				for (int j = 0; j < 2; ++j)
					System.out.print(reductions[i][j]+" ");
				System.out.println();
			}
		}
	}
}