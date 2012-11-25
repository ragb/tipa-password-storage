# Password-storage

This components provides functionality to easy on key derivation suitable to password stoage.
For now only "scryt" algorithm is supported, however new algorithms can be added easily.

## Goals

* Provide an easy and configurable component to help with password storage.
* Use strong ans "slow" algorithms to avoid brut-force attacs on our authentication services.
* Configure algorithm parameters (i.g. scrypt parameter that change the CPU and memory used) without recompilation. We used typesafe config for this.

## Dependencis

* Sbt (for building)
* scrypt java implementaiton, typesafe config and scala test 8all pulled from maven repositories).

## Authors

Rui Batista <ruiandrebatista@gmail.com>
