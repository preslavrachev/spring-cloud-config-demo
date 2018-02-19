import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SharedApplication {
}

fun main(args: Array<String>) {
    SpringApplication.run(SharedApplication::class.java, *args)
}
