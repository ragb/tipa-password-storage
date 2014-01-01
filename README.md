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


## Licence

This software is licensed under the Apache 2 license, quoted below.

Copyright 2013, 2014 Rui Batista.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this project except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
