package net.tiflotecnia.tipa.components.passwordStorage.tests

import org.scalacheck._
import org.scalacheck.Prop._
import net.tiflotecnia.tipa.components.passwordStorage.KeyDerivator



object KeyderivatorSpecification extends Properties("KeyDerivator") {

  val kd  = new KeyDerivator
  property("Passwords must verify if they are the same") = forAll((s  : String) => (! (s isEmpty)) ==> {
    val key = kd.deriveKey(s)
    kd.check(s, key)
  })
  
  property("Passwords must not verify if they are not equal") = forAll((s1 : String, s2 : String) => (! (s1 equals s2)) ==> {
    val key = kd.deriveKey(s1)
    ! kd.check(s2, key)
  })
}