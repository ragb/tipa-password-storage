# Password-storage

This component provides functionality to easy on key derivation suitable to password storage.
For now only "scryt" algorithm is supported, however new algorithms can be added easily.

## Goals

* Provide an easy and configurable component to help with password storage.
* Use strong and "slow" algorithms to avoid brut-force atacs on our authentication services.
* Configure algorithm parameters (i.g. scrypt parameter that change the CPU and memory used) without recompilation. We used typesafe config for this.

## Dependencies

* Sbt (for building)
* scrypt java implementation, typesafe config and scala test all pulled from maven repositories).

## Authors

* Rui Batista <ruiandrebatista@gmail.com> (Tiflotecnia, Lda.)

