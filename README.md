This is a POC for the A360 Consumer component that consumes messages from a topic containing policy status and information and mapping the information in the messages to fields and posting that JSON object to a rest API, in this case publishing a message to another topic via Rest Proxy.

Setup

To run on local, set up a Kafka cluster on your local:
https://docs.confluent.io/current/quickstart/ce-docker-quickstart.html

Create 2 topics, one from which to consume from and one to publish to via the Rest Proxy.

Add or modify the topic names, consumer groups, REST URL in the application.properties.

Create a console producer to the source topic and send messages in the following format:

{"number": 1, "status": "pending"}

Create a console consumer to view the messages from the destination topic that receives messages via the Rest Proxy.

