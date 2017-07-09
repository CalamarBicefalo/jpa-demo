package io.spring.jpa.mysteriesofjpa

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import javax.persistence.Entity
import javax.persistence.Id

@SpringBootApplication
class MysteriesOfJpaApplication

fun main(args: Array<String>) {
    SpringApplication.run(MysteriesOfJpaApplication::class.java, *args)
}

@Entity
data class Account (
        @Id
        var name : String,
        var balance : Long = 0
) {
    fun incrementCounter(amount: Long) {
        balance+=amount
    }
}

interface AccountRepository: CrudRepository<Account, String>

@Service
class AccountService(val repository: AccountRepository) {

    fun deposit(amount: Long, accountName: String){
        TODO()
    }
}