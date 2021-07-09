package ua.training.entity;

import java.time.LocalDate;

public interface HumanDoctor {
    String name();
    LocalDate birthday();
    Human.Gender gender();
}
