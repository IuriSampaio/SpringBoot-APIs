package TODO

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class app

fun main (){
    SpringApplication.run(app::class.java)
    println("APP RUNNING AT : http://127.0.0.1:8080")
}