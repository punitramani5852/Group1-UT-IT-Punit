package com.knoldus.validator

import com.knoldus.models.Email
import com.knoldus.validators.EmailValidator
import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec{

  val emailValidator:EmailValidator=new EmailValidator()

  "This Email" should "be valid as it is written in correct format" in{

    val email:Email=new Email("prateekGupta@gmail.com")
    assert(emailValidator.isEmailValid(email))
  }

  it should "not valid as it contains blank space" in{

    val email:Email=new Email("prateek 92948@gmail.com.net") // blank space not allowed.
    assert(!emailValidator.isEmailValid(email))
  }

  it should "also not valid as it contains two or more dot symbols" in{

    val email:Email=new Email("prateek92948@gmail..com") // two dots are not allowed.
    assert(!emailValidator.isEmailValid(email))
  }

  it should "also not valid as it does not contain @ symbol" in{

    val email:Email=new Email("prateekGupta.com") // here @ symbol is missing.
    assert(!emailValidator.isEmailValid(email))
  }
}
