package com.example.Online_Course_Management.Models;

// import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// import lombok.NonNull;

@Entity
@Table(name = "course_content")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Course_Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_content_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_module_id", nullable = false)
    private Course_Module course_Module;

    @Column(name = "course_content_url", nullable = false, columnDefinition="TEXT")
    @NotBlank
    private String course_content_url;

    @Column(name = "isComplete", nullable = false) 
    @NotNull
    @Builder.Default
    private boolean isComplete = false;

    @Column(name = "content_sequence", nullable = false, unique = true)
    @Min(1)
    private int content_sequence;

}
