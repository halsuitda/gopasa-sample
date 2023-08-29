package com.start.catproject.catitem.entity;

import com.start.catproject.audit.BaseEntity;
import com.start.catproject.cart.entity.Cart;
import com.start.catproject.contents.Membership;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cat_items")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class CatItem extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String info;

    @Column(nullable = false)
    private boolean waterMark;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Membership authority;

    @ToString.Exclude
    @OneToMany(mappedBy = "catItem", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id")
    private Set<Cart> carts = new LinkedHashSet<>();

    public void addCart(Cart cart) {
        this.carts.add(cart);
    }


}
