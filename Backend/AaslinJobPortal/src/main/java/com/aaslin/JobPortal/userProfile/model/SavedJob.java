package com.aaslin.JobPortal.userProfile.model;

import com.aaslin.JobPortal.JobPosts.JobPost;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SavedJob {


    private JobPost jobPost;

    private LocalDate applicationDeadline;

    @UpdateTimestamp
    private LocalDateTime savedAt;
}
