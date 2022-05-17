# baraka-app


Getting Started

git clone https://github.com/sheeraz21/baraka-app.git

## After cloning run the below command to up the application.
mvn clean install

docker image build -t baraka-app .

docker container run --name baraka-app -p 8080:8080 -d baraka-app

## Rest API 

http://localhost:8080/api/v1/candles/{symbol}

Sample Request : http://localhost:8080/api/v1/candles/EES



 
