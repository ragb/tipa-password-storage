package net.tiflotecnia.tipa.components.passwordStorage.tests

import org.scalatest._

import net.tiflotecnia.tipa.components.passwordStorage.KeyDerivator;


class KeyDerivatorTests extends FlatSpec {

  "A KeyDerivator with the default configuration" should "Load correctly" in {
    val kd = new KeyDerivator()
  }
  
  it should "Return \"scrypt\" in the available algorithms" in {
    val kd = new KeyDerivator
    assert(kd.getAvailableAlgorithms() contains("scrypt"))
  }
  
  it should "Derive a key that is not null" in {
    val kd = new KeyDerivator
    val key = kd.deriveKey("password")
    assert(key != null)
  }
  
  it should "Successfully check the keys when keys are the same" in {
    val kd = new KeyDerivator
    val key = kd.deriveKey("password")
    assert(kd.check("password", key))
  }
  
  it should "not check a key if the password is not exactly the same that was used to derive the provided key" in {
    val kd = new KeyDerivator
    val key = kd.deriveKey("password")
    assert(! kd.check("AnotherPassword", key))
  }
  
  it should "Throw IllegalArgumentException when an non-existent algorithm is tried" in {
    val kd = new KeyDerivator
    intercept[IllegalArgumentException] {
      kd.deriveKey("password", "dummycrap")
    }
  }
}