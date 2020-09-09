# order-service

Below Liks are Port 8100 for Order service and Port 8200 is for order item service.

Get Metod below are : 

http://localhost:8200//order-items

http://localhost:8100//orders

http://localhost:8200/itembyname/Card%20Reader

http://localhost:8200/itembyCode/Card%20Reader

http://localhost:8200/itembyid/Card%20Reader

http://localhost:8200/updateitem

http://localhost:8100/order/place

http://localhost:8100/order/{id}





Post : 

http://localhost:8100//order/place

Request : 

	{	 
	"customerName" : "Ram Agnihotri",
	"shippingAddress":"Pune",
	"itemId" :11108  ,
    "quantity" :3,
	"price":10
	}
