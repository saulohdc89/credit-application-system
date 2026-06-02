/*
 * Original author: Camila Cavalcante
 * Modifications and improvements: Saulo Henrique de Castro
 */
package me.dio.credit.application.system.service.impl

import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.exception.BusinessException
import me.dio.credit.application.system.repository.CreditRepository
import me.dio.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.util.*

@Service
class CreditService(
  private val creditRepository: CreditRepository,
  private val customerService: CustomerService
) : ICreditService {
  override fun save(credit: Credit): Credit {
    this.validNumberOfInstallments(credit.numberOfInstallments)
    this.validDayFirstInstallment(credit.dayFirstInstallment)
    credit.apply {
      customer = customerService.findById(credit.customer?.id!!)
    }
    return this.creditRepository.save(credit)
  }

  private fun validNumberOfInstallments(number: Int): Boolean {
    return if (number in 1..48) true
    else throw BusinessException("Number of installments must be between 1 and 48")
  }


  override fun findAllByCustomer(customerId: Long): List<Credit> =
    this.creditRepository.findAllByCustomerId(customerId)

  override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
    val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
      ?: throw BusinessException("Creditcode $creditCode not found"))
    return if (credit.customer?.id == customerId) credit
    else throw IllegalArgumentException("Contact admin")
    /*if (credit.customer?.id == customerId) {
      return credit
    } else {
      throw RuntimeException("Contact admin")
    }*/
  }

  private fun validDayFirstInstallment(dayFirstInstallment: LocalDate): Boolean {
    val today = LocalDate.now()
    val maxDate = today.plusMonths(3)

    return if (dayFirstInstallment.isAfter(today) && dayFirstInstallment.isBefore(maxDate)) true
    else throw BusinessException("First installment date must be between tomorrow and $maxDate")
  }

}

