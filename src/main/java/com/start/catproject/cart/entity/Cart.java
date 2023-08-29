package com.start.catproject.cart.entity;

import com.start.catproject.audit.BaseEntity;
import com.start.catproject.catitem.entity.CatItem;
import com.start.catproject.user.entity.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "carts")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
public class Cart extends BaseEntity {

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User user;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private CatItem catItem;

    public void addUser(User user) {
        this.user = user;
        user.addCart(this);
    }

    public void addCatItem(CatItem catItem) {
        this.catItem = catItem;
        catItem.addCart(this);
    }
}
