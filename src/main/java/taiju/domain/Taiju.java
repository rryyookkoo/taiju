package taiju.domain;

public class Taiju {
    private int id;
    private long recordedAt;
    private float weight;

    public Taiju(long recordedAt,float weight){
        this.recordedAt = recordedAt;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(long recordedAt) {
        this.recordedAt = recordedAt;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
