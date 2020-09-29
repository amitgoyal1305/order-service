# order-service


# Find Order by Id
GET - http://localhost:8100/order/{id}  or http://localhost:8100/order/10001

# Respone : 


{
    "customerName": "Amit Goyal",
    "orderDate": "2020-09-29T18:30:00.000+00:00",
    "shippingAddress": "Pune",
    "orderItems": [
        {
            "id": 11107,
            "productCode": "CR",
            "productName": "Card Reader",
            "quantity": 10
        },
        {
            "id": 11101,
            "productCode": "CR",
            "productName": "Card Reader",
            "quantity": 10
        },
        {
            "id": 11103,
            "productCode": "HD",
            "productName": "Hard Disk",
            "quantity": 10
        },
        {
            "id": 11109,
            "productCode": "HD",
            "productName": "Hard Disk",
            "quantity": 10
        },
        {
            "id": 11102,
            "productCode": "PD",
            "productName": "Pen Drive",
            "quantity": 10
        }
    ],
    "total": 30
}




# Find All Order List : 

GET - http://localhost:8100/orders


# For Place Order 
POST : 

http://localhost:8100/order/place  

Request : 


{
        "customerName": "User Test",
        "orderDate": "2020-09-26T18:30:00.000+00:00",
        "shippingAddress": "Pune",
        "orderItems": [
            {
               
                "productCode": "CR",
                "productName": "Card Reader",
                "quantity": 2
            },
            {
              
                "productCode": "PD",
                "productName": "Pen Drive",
                "quantity": 6
            }
        ],
        "price" : 10
    }
