package wordcountpackage;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

// WordCount is the driver class which runs others classes like Map, Reduce, Combiner and Partitioner
public class WordCount extends Configured implements Tool
{
	@Override
	public int run(String[] args) throws Exception {
    // Initialize the MapReduce job with a configuation
    Job wcJob = Job.getInstance(getConf());
    // Set the name of the job as "Wordcount-MapReduce"- Helps us for tracking
    wcJob.setJobName("Wordcount-MapReduce");
    // Set the main class file which executes the Map and Reduce classes on the cluster nodes
    wcJob.setJarByClass(WordCount.class);
    // Set the mapper class file which executes the Map jobs on the cluster nodes
    wcJob.setMapperClass(WordCountMapper.class);
    // Set the partitioner class file which executes the partitioner jobs on the cluster nodes
    wcJob.setPartitionerClass(WordCountPartitioner.class);
    // Set the combiner class file which executes the combiner jobs on the cluster nodes
    wcJob.setCombinerClass(WordCountReducer.class);
   // Set the reducer class file which executes the Reduce job(s) on the cluster nodes
    wcJob.setReducerClass(WordCountReducer.class);
    // Set the number of reduce class. This is applicable when we use partitioner class for output classification
    wcJob.setNumReduceTasks(26);
    // Set the output Key class type(Text, IntWritable etc.,) for mapper, combiner and reducer
    wcJob.setOutputKeyClass(Text.class);
    // Set the output Value class type(Text, IntWritable etc.,) for mapper, combiner and reducer
    wcJob.setOutputValueClass(IntWritable.class);
    // Path for input file loaction and output path
    Path inputFilePath = new Path(args[0]);
    Path outputFilePath = new Path(args[1]);
    // Defining File input and output path to the job
    FileInputFormat.addInputPath(wcJob, inputFilePath);
    FileOutputFormat.setOutputPath(wcJob, outputFilePath);
  // Wait for the job completion. retutns 0 on successful completion and else 1
	return wcJob.waitForCompletion(true) ? 0 : 1;
  }

  //main function- Job execution start point
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new WordCount(), args);
		System.exit(exitCode);
	}


}