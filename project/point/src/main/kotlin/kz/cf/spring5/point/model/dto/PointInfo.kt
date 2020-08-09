package kz.cf.spring5.point.model.dto

import kz.cf.spring5.point.model.enums.DistrType

class PointInfo(
        var name: String? = null,
        var freeBoxes: Int? = null,
        var capacity: Int? = null,
        var distrType: DistrType = DistrType.ASCEDING
) {
}