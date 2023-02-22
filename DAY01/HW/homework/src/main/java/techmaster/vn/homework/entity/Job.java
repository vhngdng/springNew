package techmaster.vn.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    private String id;
    private String title;
    private String description;
    private String location;
    private int minSalaray;
    private int maxSalary;
    private String emailTo;


}
