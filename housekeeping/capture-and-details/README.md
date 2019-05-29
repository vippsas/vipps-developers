## Capture eCom v2 payments
Requires the programming language Go (https://golang.org/)

To run a capture batch in production<br/>
`go run main.go -config config.json -orders orders.txt -capture -production`<br/>
To run in test simply omit "-production" 

`conf.json` and `orders.txt` need to either be filled in or you can refer to some other file above.

orders.txt should be filled with a single OrderID per line 


Running program without any arguments will give you the list of options
