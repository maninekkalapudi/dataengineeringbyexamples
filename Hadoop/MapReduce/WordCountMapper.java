package wordcountpackage;

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;

// WordCountMapper class uses Mapper class. 
// "<LongWritable, Text"-> input data format to the mapper
// "Text, IntWritable>"-> input data format from the mapper
public class WordCountMapper extends Mapper <LongWritable, Text, Text, IntWritable>
{
  // Create a Text (String datatype for Hadoop) type object
  private Text wordToken = new Text();

  // Create a map function which takes <randomkey, value(text)> and gives output as <word, 1>
  public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
  {
    // StringTokenizer - splits the text based on 
    StringTokenizer tokens = new StringTokenizer(value.toString()); //Dividing String into tokens
    while (tokens.hasMoreTokens())
    {
      // Converting every word from Java String format to MapReduce Text format
      wordToken.set(tokens.nextToken());
      
      /*  Context - Context object: allows the Mapper/Reducer to interact with the 
      // rest of the Hadoop system. It includes configuration data for the job 
      // as well as interfaces which allow it to emit output.

      Applications can use the Context:
       -  to report progress
       -  to set application-level status messages
       -  update Counters
       -  indicate they are alive
       -  to get the values that are stored in job configuration across map/reduce phase. */
      
       // Here we are writing <word,1> to the context which will be picked up by the reduce phase later
      context.write(wordToken, new IntWritable(1));
    }
  }
}

// More on Hadoop data types here -> https://data-flair.training/forums/topic/define-writable-data-types-in-hadoop-mapreduce/