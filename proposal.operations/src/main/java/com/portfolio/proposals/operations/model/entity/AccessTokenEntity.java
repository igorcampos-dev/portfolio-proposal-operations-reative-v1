package com.portfolio.proposals.operations.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ACCESS_TOKENS")
public class AccessTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String key;

}
