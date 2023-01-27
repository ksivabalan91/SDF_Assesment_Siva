package task;

public class Words implements Comparable<Words>{
    private String key;
    private double freq;

    public Words(String key, double freq) {
        this.key = key;
        this.freq = freq;
    }

    public String getKey() {return key;}
    public void setKey(String key) {this.key = key;}

    public double getFreq() {return freq;}
    public void setFreq(double freq) {this.freq = freq;}

    @Override
    public String toString() {
        return "Word:" + key + ", freq:" + freq;
    }
    
    @Override
    public int compareTo(Words o){
        return this.getKey().compareTo(o.getKey());
    }
}
