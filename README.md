# Description
This project is a simple backend rest api using Java 17 & the spring-boot framework as well as PostgreSQL,
The API is divided into 3 distinct layers:
  - Rest controller (API endpoints)
  - Service (Business logic)
  - Data Access (Repository)



# Documentation

`GET <server.url>/api/clients/all `
- Get all user information

`POST <server.url>/api/clients/add`
```
{
  "email": String,
  "password": String,
  "accountBalance": Integer
}
```
- Register a new user
- Returns an error if the email is already in use

`DELETE <server.url>/api/clients/delete/{id}`
- Delete a registered user from the database
- Returns an error if the id is invalid 🔴

`PUT <server.url>/api/clients/withdraw/id/amount`
- Withdraws the amount from the user and updates the user balance in the database
- Returns an error if the id is invalid, the amount is invalid, or the balance is insufficient (with the appropriate error message) 🔴


`PUT <server.url>/api/clients/deposit/id/amount`
- Deposits the amount from the user and updates the user balance in the database
- Returns an error if the id is invalid, the amount is invalid (with the appropriate error message) 🔴
