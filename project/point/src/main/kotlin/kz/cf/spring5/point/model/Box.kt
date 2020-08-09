package kz.cf.spring5.point.model

import kz.cf.spring5.point.model.dto.Pack
import kz.cf.spring5.point.model.enums.BoxType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Box(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var num: String? = null,
        var type: BoxType? = null,
        var isBusy: Boolean = false,
        var packInfo: String? = null
) {
}