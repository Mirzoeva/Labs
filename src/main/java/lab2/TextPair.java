package lab2;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;


public class TextPair implements WritableComparable<TextPair>{
    private Text first;
    private Text second;

    public TextPair(){
        this.first=new Text();
        this.second=new Text();
    }

    public TextPair(Text first, Text second) {
        this.first = first;
        this.second = second;
    }
    public TextPair(String first,String second){
        this.first=new Text(first);
        this.second=new Text(second);
    }

    public Text getFirst() {
        return first;
    }

    public Text getSecond() {
        return second;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(first.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TextPair){
            TextPair tp=(TextPair)obj;
            return first.equals(tp.getFirst());
        }
        return false;
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        first.readFields(in);
        second.readFields(in);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        first.write(out);
        second.write(out);
    }


    @Override
    public int compareTo(TextPair tp) {
        int cmp=first.compareTo(tp.getFirst());
        if(cmp!=0)
            return cmp;
        return second.compareTo(tp.getSecond());

    }

}