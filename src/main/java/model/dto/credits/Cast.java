package model.dto.credits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.dto.Department;


@AllArgsConstructor
@Getter
public class Cast {
    private boolean adult;
    private long gender;
    private long id;
    private Department knownForDepartment;
    private String name;
    private String originalName;
    private double popularity;
    private String profilePath;
    private Long castID;
    private String character;
    private String creditID;
    private Long order;
    private Department department;
    private String job;
}
