package com.start.catproject.user.entity;

import com.start.catproject.audit.BaseEntity;
import com.start.catproject.cart.entity.Cart;
import com.start.catproject.cat.entity.Cat;
import com.start.catproject.contents.LoginType;
import com.start.catproject.contents.Membership;
import com.start.catproject.contents.UserStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @Column(nullable = false, unique = true)
    @Setter
    private String email;

    @Column(nullable = false, unique = true)
    @Setter
    private String nickName;

    @Column(nullable = false)
    @Setter
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Setter
    private LoginType loginType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Setter
    private UserStatus userStatus;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Setter
    private Membership membership;

    @ElementCollection(fetch = FetchType.EAGER)
    @Setter
    private List<String> roles = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id")
    private Set<Cat> cats = new LinkedHashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id")
    private Set<Cart> carts = new LinkedHashSet<>();

    public void addCat(Cat cat) {
        this.cats.add(cat);
    }

    public void addCart(Cart cart) {
        this.carts.add(cart);
    }



}
