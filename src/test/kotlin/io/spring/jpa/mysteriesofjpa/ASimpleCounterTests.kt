package io.spring.jpa.mysteriesofjpa

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.assertj.core.api.Assertions.assertThat

@RunWith(SpringRunner::class)
@SpringBootTest
class ASimpleCounterTests {

	@Autowired
	lateinit var subject: AccountService

	@Autowired
	lateinit var repository: AccountRepository

	@Test
	fun depositIncreasesBalance() {
		val account = repository.save(Account(name = "testAccount"))

		subject.deposit(10, "testAccount")
		subject.deposit(10, "testAccount")

		assertThat(repository.findOne("testAccount").balance).isEqualTo(20L)
	}

}
