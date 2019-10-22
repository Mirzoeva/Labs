package lab2;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FirstComparator extends WritableComparator {
    public FirstComparator(){
        super(TextPair.class, true);
    }
    @Override
    public int compare(WritableComparable a, WritableComparable b){
        TextPair a1 = (TextPair)a;
        TextPair b1 = (TextPair)b;

        int t = a1.getFirst().compareTo(b1.getFirst());
        return t == 0 ? a1.getSecond().compareTo(b1.getSecond()) : t;
    }
}
