package com.start.catproject.cat.entity;

import com.start.catproject.audit.BaseEntity;
import com.start.catproject.user.entity.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "cats")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class Cat extends BaseEntity {


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String loveSnack;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String info;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String etc;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;

    public void addUser(User user) {
        this.user = user;
        user.addCat(this);
    }

}
