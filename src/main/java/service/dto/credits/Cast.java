package service.dto.credits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import service.dto.Department;


@AllArgsConstructor
@Getter
public class Cast {
    private boolean adult;
    private long gender;
    private long id;
    private Department known_for_department;
    private String name;
    private String original_name;
    private double popularity;
    private String profile_path;
    private Long castID;
    private String character;
    private String creditID;
    private Long order;
    private Department department;
    private String job;
}
