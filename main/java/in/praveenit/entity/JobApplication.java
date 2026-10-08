package in.praveenit.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String location;
    private String position;
    private String experience;
    private String education;
    private String skills;

    @Column(length = 2000)
    private String coverLetter;

    private boolean relocate;

    private String filePath;
}
