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

public class WordCount extends Configured implements Tool
{
	@Override
	public int run(String[] args) throws Exception {
    Job wcJob = Job.getInstance(getConf());
    wcJob.setJobName("Wordcount-MapReduce");
    wcJob.setJarByClass(WordCount.class);
    wcJob.setMapperClass(WordCountMapper.class);
    
    // wcJob.setPartitionerClass(WordCountPartitioner.class);
    
    // wcJob.setCombinerClass(WordCountReducer.class);
    // wcJob.setReducerClass(WordCountReducer.class);
    // wcJob.setNumReduceTasks(26);
    wcJob.setOutputKeyClass(Text.class);
    wcJob.setOutputValueClass(IntWritable.class);
    Path inputFilePath = new Path(args[0]);
    Path outputFilePath = new Path(args[1]);
    FileInputFormat.addInputPath(wcJob, inputFilePath);
    FileOutputFormat.setOutputPath(wcJob, outputFilePath);
	return wcJob.waitForCompletion(true) ? 0 : 1;
  }

	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new WordCount(), args);
		System.exit(exitCode);
	}


}