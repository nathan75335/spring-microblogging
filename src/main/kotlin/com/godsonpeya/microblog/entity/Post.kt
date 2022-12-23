package com.godsonpeya.microblog.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.*

/**
 * l'entite publication (post)
 */
@Entity
@Table(name = "publication")
data class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?=null,
    var content: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    var user: User,
    @CreationTimestamp
    var createdAt: Timestamp?=null,
    @UpdateTimestamp
    var updatedAt: Timestamp? = null,
)