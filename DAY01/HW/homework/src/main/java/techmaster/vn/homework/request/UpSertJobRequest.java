package techmaster.vn.homework.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpSertJobRequest {
    private String title;
    private String description;
    private String location;
    private int minSalaray;
    private int maxSalary;
    private String emailTo;
}
