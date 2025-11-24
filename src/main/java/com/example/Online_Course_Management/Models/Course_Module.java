package com.example.Online_Course_Management.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
// import lombok.AllArgsConstructor;
import lombok.Data;
// import lombok.NoArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course_module")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Course_Module {

    @Id
    @Column(name = "course_module_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_module_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    @NotNull
    private Course course; 

    @OneToMany(mappedBy = "course_Module")
    private List<Course_Content> course_content_id;

    @Column(name = "module_progress", nullable = false)
    @Min(0)
    @Max(100)
    @Builder.Default
    private int course_module_progress = 0;
    
}
