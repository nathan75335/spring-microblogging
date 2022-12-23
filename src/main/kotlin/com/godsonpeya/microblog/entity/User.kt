package com.godsonpeya.microblog.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.*

/**
 * L'entite utilisateur (user)
 */
@Entity
@Table(name = "utilisateur")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?=null,
    var username: String,
    var profession: String,
    var ville: String,
    var pays: String,
    var fullname: String,
    var password: String,
    @OneToMany(fetch = FetchType.LAZY)
    var posts: MutableList<Post> = mutableListOf(),
    @CreationTimestamp
    var createdAt: Timestamp?=null,
    @UpdateTimestamp
    var updatedAt: Timestamp? = null,
)