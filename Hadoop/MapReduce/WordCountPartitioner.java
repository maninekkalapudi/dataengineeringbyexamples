package wordcountmapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class WordCountPartitioner extends Partitioner < Text, IntWritable> {
  @Override
  public int getPartition(Text key, IntWritable value, int numReduceTasks)
  {
   //   Converting the Key to Java String format
     String str = key.toString();
         // Check if the numReduceTasks from Driver class is set to any value other than 0
         if(numReduceTasks == 0)
         {
            // if not set then numReduceTasks=0
            return 0;
         }
         // Here we will check each word for the starting letter and assign it to a partitioner
         // This forms the base logic for Partitioner
         else if(str.charAt(0) == 'a' || str.charAt(0)=='A')
         {
        	 return 1 % numReduceTasks;
         }
         else if(str.charAt(0) == 'b' || str.charAt(0)=='B')
         {
            return 2 % numReduceTasks;
         }
         else if(str.charAt(0) == 'c' || str.charAt(0)=='C')
         {
            return 3 % numReduceTasks;
         }
         else if(str.charAt(0) == 'd' || str.charAt(0)=='D')
         {
            return 4 % numReduceTasks;
         }
         else if(str.charAt(0) == 'e' || str.charAt(0)=='E')
         {
            return 5 % numReduceTasks;
         }
         else if(str.charAt(0) == 'f' || str.charAt(0)=='F')
         {
            return 6 % numReduceTasks;
         }
         else if(str.charAt(0) == 'g' || str.charAt(0)=='G')
         {
            return 7 % numReduceTasks;
         }
         else if(str.charAt(0) == 'h' || str.charAt(0)=='H')
         {
            return 8 % numReduceTasks;
         }
         else if(str.charAt(0) == 'i' || str.charAt(0)=='I')
         {
            return 9 % numReduceTasks;
         }
         else if(str.charAt(0) == 'j' || str.charAt(0)=='J')
         {
            return 10 % numReduceTasks;
         }
         else if(str.charAt(0) == 'k' || str.charAt(0)=='K')
         {
            return 11 % numReduceTasks;
         }
         else if(str.charAt(0) == 'l' || str.charAt(0)=='L')
         {
            return 12 % numReduceTasks;
         }
         else if(str.charAt(0) == 'm' || str.charAt(0)=='M')
         {
            return 13 % numReduceTasks;
         }
         else if(str.charAt(0) == 'n' || str.charAt(0)=='N')
         {
            return 14 % numReduceTasks;
         }
         else if(str.charAt(0) == 'o' || str.charAt(0)=='O')
         {
            return 15 % numReduceTasks;
         }
         else if(str.charAt(0) == 'p' || str.charAt(0)=='P')
         {
            return 16 % numReduceTasks;
         }
         else
        	 if(str.charAt(0) == 'q' || str.charAt(0)=='Q')
         {
            return 17 % numReduceTasks;
         }
         else if(str.charAt(0) == 'r' || str.charAt(0)=='R')
         {
            return 18 % numReduceTasks;
         }
         else if(str.charAt(0) == 's' || str.charAt(0)=='S')
         {
            return 19 % numReduceTasks;
         }
         else if(str.charAt(0) == 't' || str.charAt(0)=='T')
         {
            return 20 % numReduceTasks;
         }
         else if(str.charAt(0) == 'u' || str.charAt(0)=='U')
         {
            return 21 % numReduceTasks;
         }
         else if(str.charAt(0) == 'v' || str.charAt(0)=='V')
         {
            return 22 % numReduceTasks;
         }
         else if(str.charAt(0) == 'w' || str.charAt(0)=='W')
         {
            return 23 % numReduceTasks;
         }
         else if(str.charAt(0) == 'x' || str.charAt(0)=='X')
         {
            return 24 % numReduceTasks;
         }
         else if(str.charAt(0) == 'y' || str.charAt(0)=='Y')
         {
            return 25 % numReduceTasks;
         }
         else if(str.charAt(0) == 'z' || str.charAt(0)=='Z')
         {
            return 26 % numReduceTasks;
         }
         else
         {
        	 return 1%numReduceTasks;
         }
      }
   }

