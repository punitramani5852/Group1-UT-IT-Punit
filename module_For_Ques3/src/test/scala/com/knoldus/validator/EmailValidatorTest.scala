package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec {

  val emailValidator:EmailValidator=new EmailValidator()

  behavior of "This Email"
  it should "be valid as it is written in correct format" in{
    val email="punit@gmail.com.org"
    assert(emailValidator.emailIdIsValid(email))
  }

  it should "not valid as it contains blank space" in{
    val email="punit 0023@gmail.com.net" // blank space not allowed.
    assert(!emailValidator.emailIdIsValid(email))
  }

  it should "also not valid as it contains two or more dot symbols" in{
    val email= "punit92948@gmail..com" // two dots are not allowed.
    assert(!emailValidator.emailIdIsValid(email))
  }

  it should "also not valid as it does not contain @ symbol" in{
    val email= "punitramani.com" // here @ symbol is missing.
    assert(!emailValidator.emailIdIsValid(email))
  }
}
