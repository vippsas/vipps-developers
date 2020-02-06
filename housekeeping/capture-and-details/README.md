# Capture or details request on eCom v2 transactions
Requires the programming language [Go](https://golang.org/)

To run a capture batch in production<br/>
`go run main.go -config config.json -orders orders.txt -capture -production`<br/>
To run in test simply omit "-production" 

To run detail requests on a batch of orders<br/>
`go run main.go -config config.json -orders orders.txt -detail -production`<br/>

`conf.json` and `orders.txt` need to either be filled in or you can refer to some other file above.

Running program without any arguments will give you the list of parameters available

## Input
### Orders input
The order input _must_ be filled with a single OrderID and the amount to be captured per line.<br/>
Regardless of if you wish to perform a details request or a capture on the orders.<br/>
*If you only wish to perform a details request just fill in 0*
```
OrderID;CaptureAmount
Woo123;0
Woo200;5000
```
**Note** The amount captured should be an integer and "øre" (cent in EUR/USD) in case of NOK.<br/>
Thus "NOK 50,95" would written as 5095 and NOK 50,- would be 5000.<br/>
**0 means "capture everything"**

### Configuration file
You'll find the required information for this file in the developer portal.<br/>
See: [Getting started](https://github.com/vippsas/vipps-developers/blob/master/vipps-getting-started.md) for help on getting started with the developer portal.


## Production & Test
Specify if you wish to run in the production environment by adding `-production` as an argument on the command line.<br/>
If you don't specify `-production`, the tool will default to the Merchant Test (MT) environment.

## Tips & tricks
Since you can specify the config file as a parameter you can create multiple config files like this:
`conf.SaleUnitName.json` if you have multiple sale units.<br/> 
That way you don't need to re-edit the same config file if you have multiple sale units you need to capture and/or perform details requests on.

This of course also works for the order input, i.e.
`orders_SaleUnitName.txt`

The .gitignore file for this particular directory is setup to ignore orders_\*.txt and conf.\*.json 


