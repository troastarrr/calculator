# calculator
Loan API calculator 
Go to the directory calculator/

How to run the application: 

1) Running spring boot only via maven
  a)mvn clean install spring-boot:run

2) Running with kubernetes
  a)eval $(minikube docker-env)
  b)mvn clean install fabric8:build fabric8:deploy
  c)kubectl get pods (To check if the pod is created)
* Ensure that kubernetes,docker and minikube are installed locally.
