package wordcountpackage;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class WordCountReducer extends Reducer <Text, IntWritable, Text, IntWritable>
{
  // Declaring the count as MapReduce IntWritable object to capture the final count of the word
  private IntWritable count = new IntWritable();

  // Declare the reduce function
  public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
  {
    // Declare valueSum=0 the sum of all the count values for a word
    int valueSum = 0;
    // Loop all the values for a word from the map phase
    for (IntWritable val : values)
    {
      // Sum the values for the word
      valueSum += val.get();
    }
    // Set the count value from variable valueSum
    count.set(valueSum);
    // write the final output <word,count> to the context
    context.write(key, count);
  }
}