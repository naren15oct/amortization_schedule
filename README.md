This has amortization calculator with and without baloon Pay.
with baloon pay - 
http://localhost:8080/amortization/calculate/withbaloonpay/10000  - here 10000 is the baloon pay.
sample request - 
{
    "principal": 20000.00,
    "interestRate": 7.5,
    "term": 1
}

with out baloon pay  - 
http://localhost:8080/amortization/calculate 
sample request - 
{
    "principal": 20000.00,
    "interestRate": 7.5,
    "term": 1
}

For swagger Ui implementation - need more time. facing few challenges also for including H2 database. Need more time to work on the configuration.

For - Test cases - need more time to complete.
