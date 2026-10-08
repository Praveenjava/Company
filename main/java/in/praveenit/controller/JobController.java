package in.praveenit.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import in.praveenit.entity.JobApplication;
import in.praveenit.repo.JobRepository;
import in.praveenit.service.FileService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class JobController {

    private final JobRepository repo;
    private final FileService fileService;

    public JobController(JobRepository repo, FileService fileService) {
        this.repo = repo;
        this.fileService = fileService;
    }

    @PostMapping("/apply")
    public String apply(
            @RequestParam @NotBlank String fullName,
            @RequestParam @Email String email,
            @RequestParam String phone,
            @RequestParam String location,
            @RequestParam String position,
            @RequestParam String experience,
            @RequestParam String education,
            @RequestParam String skills,
            @RequestParam String coverLetter,
            @RequestParam boolean relocate,
            @RequestParam MultipartFile file
    ) throws Exception {

        JobApplication app = new JobApplication();

        app.setFullName(fullName);
        app.setEmail(email);
        app.setPhone(phone);
        app.setLocation(location);
        app.setPosition(position);
        app.setExperience(experience);
        app.setEducation(education);
        app.setSkills(skills);
        app.setCoverLetter(coverLetter);
        app.setRelocate(relocate);

        String path = fileService.saveFile(file);
        app.setFilePath(path);

        repo.save(app);

        return "Application Saved!";
    }
}
