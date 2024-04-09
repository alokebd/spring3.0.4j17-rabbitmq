#Setup (following distributions are required)
1). [Download] https://www.erlang.org/downloads
2). Setup System Environment Variable for ERLANG (ERLANG_HOME =<PATH>) and set to path (%ERLANG_HOME%\bin)
3). [Download] https://www.rabbitmq.com/docs/install-windows



# Start & Stop RabitMQ from service
1) Go to RabbitMQ 'sbin' location (C:\Porjects\erAndrabbitmq\rabbitMQ\rabbitmq_server-3.13.1\sbin)
and type the following command 

rabbitmq-plugins enable rabbitmq_management

# Check Rabbit MQ in browser
http://localhost:15672 (login as guest and password guest)

# Start RabbitMA Springboot Application 
NOTE: In console you will see as it is configured with RabbitMQ as bellow:
Created new connection: rabbitConnectionFactory#2dbfcf7:0/SimpleConnection@22ead351 [delegate=amqp://guest@127.0.0.1:5672/, localPort=59137]


# Call from Postman to send an order and check it in RabbitMQ
POST: http://localhost:8080/api/order
{
  "id": 1001,
  "name": "Mansurian Chilly Chicken",
  "qty": 5,
  "price": 35.35
}

# Check messages in RabbitMQ server 
