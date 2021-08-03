package com.project.orange.entity.user;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
public class Salt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull()
    private String salt;

    public Salt() {
    }

    public Salt(String salt) {
        this.salt = salt;
    }
}
