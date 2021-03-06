package markov_clustering;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MatrixReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
	public void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
		double result = 0;
		Iterator<DoubleWritable> it = values.iterator();
		while(it.hasNext()) {
			result += it.next().get();
		}
		context.write(key, new DoubleWritable(result));
	}
}
