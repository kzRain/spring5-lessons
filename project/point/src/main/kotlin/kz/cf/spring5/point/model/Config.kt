package kz.cf.spring5.point.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Config(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? =  null,
        var name: String? = null,
        var value: String? = null
) {
}