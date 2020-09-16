# order-service

Below Liks are Port 8100 for Order service and Port 8200 is for order item service.


# Find Order Item by Id 

GET -  http://localhost:8200/order/item/{id}   or   http://localhost:8200/order/item/11102 
Response : 
{
    "id": 11102,
    "productCode": "PD",
    "productName": "Pen Drive",
    "quantity": 10
}

# Find All Order Items : 

GET -  http://localhost:8200/order/items



# Find Order by Id
GET - http://localhost:8100/order/{id}  or http://localhost:8100/order/10001


# Find All Order List : 

GET - http://localhost:8100/orders


# For Place Order 
POST : 

http://localhost:8100/order/place  

Request : 

	{	 
	"customerName" : "Ram Agnihotri",
	"shippingAddress":"Pune",
	"itemId" :11108  ,
    "quantity" :3,
	"price":10
	}
