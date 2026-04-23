# ShoppingCartApp
Spring Boot REST API for shopping cart management using FakeStoreAPI.

## Endpoints

### Get Products
GET /products/get-product-list

#### Response 200 OK
```json
[
    {
        "category": "men's clothing",
        "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
        "id": 1,
        "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png",
        "price": 109.95,
        "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
    },
    {
        "category": "men's clothing",
        "description": "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
        "id": 2,
        "image": "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_t.png",
        "price": 22.3,
        "title": "Mens Casual Premium Slim Fit T-Shirts "
    }
]
```

### Create a new Order
POST /orders/create-new-order

#### ContentType application/json
```json
{
"userId":1,
"products":[
    {
        "id": 1,
        "price": 109.95
    },
    {
        "id": 2,
        "price": 22.3
    }
]
}
```

#### Response 200 OK
```json
{
"orderId": 1,
"products": [
    {
        "category": "men's clothing",
        "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
        "id": 1,
        "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_t.png",
        "price": 109.95,
        "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
    },
    {
        "category": "men's clothing",
        "description": "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
        "id": 2,
        "image": "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_t.png",
        "price": 22.3,
        "title": "Mens Casual Premium Slim Fit T-Shirts "
    }
],
"status": "PAYMENT_PENDING",
"total": 132.25,
"userId": 1
}
```
### Process Payment
POST /payments/process-payment

#### ContentType application/json
```json
{
    "orderId":1,
    "paymentMethod":"Credit Card"
}
```

#### Response 200 OK
```json
{
    "orderId": 1,
    "paymentId": 1,
    "paymentMethod": "Credit Card",
    "status": "PROCESSED"
}
```
#### Response 400 Bad Request
```json
{
    "errorMessage": "Payment has already been processed for this order",
    "status": 400,
    "timestamp": "2026-04-23T07:10:36.1681038"
}
```
### Verify payments registry
GET /payments/get-payments-registry-by-user/{userId}

/payments/get-payments-registry-by-user/1
#### Response 200 OK
```json
[
    {
        "orderId": 1,
        "paymentId": 1,
        "paymentMethod": "Credit Card",
        "status": "PROCESSED"
    }
]
```