package lab2;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<TextPair, Text, Text, Text> {
    @Override
    protected void reduce(TextPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException{
        Iterator<Text> iter = values.iterator();
        int count = 0;
        float maxTime = Integer.MIN_VALUE;
        float minTime = Integer.MAX_VALUE;
        float sum = 0;
        Text airport = new Text(iter.next().toString() + ",");
        while (iter.hasNext()){
            String call = iter.next().toString();
            float correntTime;
            correntTime = Float.parseFloat(call);
            if (correntTime > maxTime)
                maxTime = correntTime;
            if (correntTime < minTime)
                minTime = correntTime;
            sum += correntTime;
            count++;
        }
        if (count != 0){
            float average = sum/count;
            context.write(airport, new Text("Min: " + minTime + ", Max: " + maxTime + ", Average: " + average));
        }
    }
}
