package taiju.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

public class TaijuForm {
    private String id;

    @NotEmpty
    @Pattern(regexp = "[0-9]{4}/[0-9]{1,2}/[0-9]{1,2}")
    //@DateTimeFormat(pattern = "yyyy/MM/dd")
    private String recordedAt;

    @NotEmpty
    @Digits(integer = 3, fraction = 2)
    private String weight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecordedAt() {
        return recordedAt;
    }

    public void setRecordedAt(String recordedAt) {
        this.recordedAt = recordedAt;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
