package aggregated_graphs;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;


/**
 * 
 *
 */
public class WritableArc implements Writable {
	
	int sourceNode, destinationNode;
	double weight;
	

	/* (non-Javadoc)
	 * @see org.apache.hadoop.io.Writable#readFields(java.io.DataInput)
	 */
	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.apache.hadoop.io.Writable#write(java.io.DataOutput)
	 */
	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub

	}

}