package com.knoldus.validator

import com.knoldus.models.User
import org.scalatest.flatspec.AnyFlatSpec

class UserValidatorTest extends AnyFlatSpec {

  val userValidator:UserValidator=new UserValidator()

  behavior of  "this user"

  it should "be valid as its company exist in database and the email id is also written in correct format" in{
    val user:User= User("Punit","Ramani","pkg@gmail.com","Knoldus")
    assert(userValidator.userIsValid(user))
  }

  it should "not be valid as its company does not exist in database and the email id is also invalid" in{
    val user:User= User("Sam","Singh","sam@gm@ail.com","Kuliza Tech")
    assert(!userValidator.userIsValid(user))
  }

  it should "not be valid as its email id is invalid" in{
    val user:User= User("Shubham","Singh","sb235@gmail..com","Knoldus")
    assert(!userValidator.userIsValid(user))
  }

   it should "not be valid as its company does not exist in database" in{
     val user:User= User("Shiv","Kumar","shiv893@gmail.com","Tech Mahindra")
     assert(!userValidator.userIsValid(user))
   }

}
