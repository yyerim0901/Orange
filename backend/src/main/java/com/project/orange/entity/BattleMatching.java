package com.project.orange.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="battle_matching")
public class BattleMatching {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="blue_team")
    private Challenges blue_team;

    @OneToOne
    @JoinColumn(name="red_team")
    private Challenges red_team;
}
