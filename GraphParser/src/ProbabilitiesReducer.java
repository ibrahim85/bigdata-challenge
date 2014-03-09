import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


/** Creates sum over probabilities for one arc in one hour interval
	 * 
	 * @author Michele Carignani
	 *
	 */
	public class ProbabilitiesReducer extends Reducer<Text, Text, Text, Text> {
		
		private class ArcTail {
			public ArcTail(int dest, double weight) {
				super();
				this.dest = dest;
				this.weight = weight;
			}
			public int dest;
			public double weight;
			
		}
        public void reduce(Text key, Iterator<Text> values, Context context)
            throws IOException, InterruptedException {
        	// takes ((D:P:Source),(Dest:Val))
        	// puts ((D:P:Source:Sum),(Dest:Prob))
        	
        	List<ArcTail> l = new LinkedList<ArcTail>();
        	int d;
        	double w;
        	String [] s;
        	double sum = 0;
        	while(values.hasNext()){
        		s = values.next().toString().split(":");
        		d = Integer.parseInt(s[0]);
        		w = Double.parseDouble(s[1]);
        		sum += w;
        		l.add(new ArcTail(d,w));
        	}
        	
        	Text newKey = new Text(key.toString() + ":" + sum);
        	ArcTail at;
        	double prob;
        	
        	Iterator<ArcTail> lit = l.iterator();
        	while(lit.hasNext()){
        		at = lit.next();
        		prob = at.weight / sum;
        		context.write(newKey, new Text(at.dest + ":" + prob));
        	}
        }
    }