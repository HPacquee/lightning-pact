# Consumer driven contract testing using Pact

# Branches

* Master : The baseline branch where the presentation kicks off

* Spongebob : Changes made by Spongebob, breaking the pact provider tests in Queenslize

* Annhannah : Changes made by not-Spongebob, adding functionality for Ann Hannah's change request

# Pact Tests

* You can find the Pact tests in all 3 (or 4 depending on the branch) projects in the `QueenSlizePactTest` for consumers and in the `QueenSlizeProviderPactVerificationTest`for the provider.

* After running the consumer tests you need to manually copy & paste (or use the checked in versions) the json pact files from the `/target/pact` folder of the consumer modules to the `/src/test/resources/pacts` folder of the provider.  
Then you can validate the pact contracts.
