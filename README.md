# SpringBootJwt
This repo is poc for jwt and basic auth validation . In order to test this up on your local system you will need to 
install database . The database details are in application.properties file 
Postman curl request is shared as well to test
1.Hello Request 
curl --location 'http://localhost:8080/hello' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBamF5IiwiaWF0IjoxNzY3ODkzNjAxLCJleHAiOjE3Njc4OTM2NjF9.9wv4_h4hxpszEvQAX72wjkv2duvSRKjM-mwvVkRE5hQ' \
--header 'Cookie: JSESSIONID=CF0F53556240E75CF687D08792BE65E3'
2.login Request 
curl --location 'http://localhost:8080/login' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=6E7FC5EF320C2B626D905A16A6900AAA' \
--data '{
    "id": 9,
    "username": "Ajay",
    "password": "1111"
}'


Just copy and update the project . Good to go
Please do let me know if any issue arises happy to debug
