package kz.cf.spring5.point

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PointApplication

fun main(args: Array<String>) {
    runApplication<PointApplication>(*args)
}
