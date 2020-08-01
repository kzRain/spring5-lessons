package kz.cf.spring5.point.model

import kz.cf.spring5.point.model.enums.BoxType

class Box(
        var id:Int? = null,
        var num: String? = null,
        var type: BoxType? = null,
        var isBusy: Boolean = false
) {
}