package com.loiane;

import com.loiane.enums.Category;
import com.loiane.model.Course;
import com.loiane.model.Lesson;
import com.loiane.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CourseRepository courseRepository) {
        return args -> {
            courseRepository.deleteAll();

            Course c = new Course();
            c.setName("Angular com Spring");
            c.setCategory(Category.FRONT_END);

            Lesson l = new Lesson();
            l.setName("Introdução");
            l.setYoutubeUrl("watch?v=1");
            l.setCourse(c);
            c.getLessons().add(l);

            Lesson l1 = new Lesson();
            l1.setName("Angular");
            l1.setYoutubeUrl("watch?v=2");
            l1.setCourse(c);
            c.getLessons().add(l1);

            courseRepository.save(c);
        };
    }
}
