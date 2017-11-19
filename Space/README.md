# Space
- Create a REST interface for a coffee machine
- Coffee machine: 
![alt text](http://www.mewa-kaffee.de/files/automaten/sielaff_kaffeeautomat_cvt.jpg "sielaff kaffeeautomat")

# REST Interface

| HTTP verb | Data operation |
| --------------- | --------------- |
| GET | Retrieve |
| POST | Create |
| PUT | Update (update all fields and use default values for any undefined fields) |
| DELETE | Delete |
| MERGE | Update (update only the fields that are specified and changed from current version) |

# Client

| List of operations | HTTP verb | Data operation | URL
| --------------- | --------------- | --------------- | --------------- |
| 1 | GET | Awake machine, briefing | /api/v1/coffeemachine/briefing |
| 2 | GET | Select product | /api/v1/coffeemachine/product |
| 3 | GET | Product options | /api/v1/coffeemachine/option |
| 4 | POST | Pay | /api/v1/coffeemachine/payment |
| 5 | GET | Product Selected | /api/v1/coffeemachine/product |
| 6 | GET | Cancel order | /api/v1/coffeemachine/product-options |
