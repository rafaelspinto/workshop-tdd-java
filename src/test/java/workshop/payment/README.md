# Payment Broker

Implement a payment broker that meets the following criteria:


**Paying (pay)**

* When paying and:
    * wallet has funds and provider is available and deposit succeeds should return true.
    * wallet does not have funds should throw InsufficientFundsException
    * provider is not available should throw ProviderNotAvailableException