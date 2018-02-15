# Payment Broker

Implement a payment broker that alows for payments to be done to a provider using wallet funds.


## Acceptance Criteria (pay)

* if wallet has funds and provider is available and deposit succeeds should return true.
* if wallet does not have funds should throw InsufficientFundsException
* if provider is not available should throw ProviderNotAvailableException


## Uses

* [JUnit](https://junit.org/junit4/)
* [mockito](http://site.mockito.org/)