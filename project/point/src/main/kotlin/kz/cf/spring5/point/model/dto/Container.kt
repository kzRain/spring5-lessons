package kz.cf.spring5.point.model.dto

class Container(
        var num: String? = null,
        var packs: List<Pack> = mutableListOf()
) {
}