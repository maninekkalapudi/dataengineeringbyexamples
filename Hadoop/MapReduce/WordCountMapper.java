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
      wordToken.set(tokens.nextToken());
      context.write(wordToken, new IntWritable(1));
    }
  }
}

// More on Hadoop data types here -> https://data-flair.training/forums/topic/define-writable-data-types-in-hadoop-mapreduce/