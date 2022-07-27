### How to run: 
- Install Docker Desktop
- brew install minikube
- minikube start --driver docker
- kubectl apply -f mongo-secret.yaml
- kubectl apply -f mongo-config.yaml
- kubectl apply -f mongo.yaml
- kubectl apply -f user-ms.yaml
- minikube service $SERVICE_NAME