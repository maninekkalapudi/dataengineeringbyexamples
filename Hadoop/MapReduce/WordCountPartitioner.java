package wordcountpackage;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class WordCountPartitioner extends Partitioner < Text, IntWritable> {
  @Override
  public int getPartition(Text key, IntWritable value, int numReduceTasks)
  {
     String str = key.toString();
         
         if(numReduceTasks == 0)
         {
            return 0;
         }
         
         else if(str.charAt(0) == 'a')
         {
        	 return 1 % numReduceTasks;
         }
         else if(str.charAt(0) == 'b')
         {
            return 2 % numReduceTasks;
         }
         else if(str.charAt(0) == 'c')
         {
            return 3 % numReduceTasks;
         }
         else if(str.charAt(0) == 'd')
         {
            return 4 % numReduceTasks;
         }
         else if(str.charAt(0) == 'e')
         {
            return 5 % numReduceTasks;
         }
         else if(str.charAt(0) == 'f')
         {
            return 6 % numReduceTasks;
         }
         else if(str.charAt(0) == 'g')
         {
            return 7 % numReduceTasks;
         }
         else if(str.charAt(0) == 'h')
         {
            return 8 % numReduceTasks;
         }
         else if(str.charAt(0) == 'i')
         {
            return 9 % numReduceTasks;
         }
         else if(str.charAt(0) == 'j')
         {
            return 10 % numReduceTasks;
         }
         else if(str.charAt(0) == 'k')
         {
            return 11 % numReduceTasks;
         }
         else if(str.charAt(0) == 'l')
         {
            return 12 % numReduceTasks;
         }
         else if(str.charAt(0) == 'm')
         {
            return 13 % numReduceTasks;
         }
         else if(str.charAt(0) == 'n')
         {
            return 14 % numReduceTasks;
         }
         else if(str.charAt(0) == 'o')
         {
            return 15 % numReduceTasks;
         }
         else if(str.charAt(0) == 'p')
         {
            return 16 % numReduceTasks;
         }
         else if(str.charAt(0) == 'r')
         {
            return 17 % numReduceTasks;
         }
         else if(str.charAt(0) == 's')
         {
            return 18 % numReduceTasks;
         }
         else if(str.charAt(0) == 't')
         {
            return 19 % numReduceTasks;
         }
         else if(str.charAt(0) == 'u')
         {
            return 20 % numReduceTasks;
         }
         else if(str.charAt(0) == 'v')
         {
            return 21 % numReduceTasks;
         }
         else if(str.charAt(0) == 'w')
         {
            return 22 % numReduceTasks;
         }
         else if(str.charAt(0) == 'x')
         {
            return 23 % numReduceTasks;
         }
         else if(str.charAt(0) == 'y')
         {
            return 24 % numReduceTasks;
         }
         else if(str.charAt(0) == 'z')
         {
            return 25 % numReduceTasks;
         }
         else
         {
        	 return 26%numReduceTasks;
         }
      }
   }

