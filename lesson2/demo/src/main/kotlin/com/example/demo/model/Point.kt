package com.example.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Point(
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        val id: Long? = null,
        val num: String,
        val address: String,
        val boxNum: Int,
        val boxBusy: Int
) {
}