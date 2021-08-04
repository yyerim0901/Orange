package com.project.orange.entity.challenge;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
    private Challenges blueTeam;

    @OneToOne
    @JoinColumn(name="red_team")
    private Challenges redTeam;
}
