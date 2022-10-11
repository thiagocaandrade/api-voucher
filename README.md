# API VOUCHER

Micro serviço de pool de vouchers.

## Requisitos

Para que seja possível rodar essa aplicação é necessário atender alguns requisitos básicos.

- Java 17
- Maven 3.8+
- Docker

## Como Usar:

```
$ docker-compose -f docker-compose-mongo.yml up
```
# Endpoints

### Acessar endpoint no postman abaixo para acesso ao access_token:

Metodo HTTP POST:

	localhost:8080/oauth/token
    
Authorization Basic Auth: 

    Username: getnet
    Password: 123

Body: 
    
    password: user
    username: user
    grant_type: password

### Inserir Voucher: 

Metodo HTTP POST:

    localhost:8080/vouchers/save

Authorization Bearer Token:

    token: access_token (gerado no localhost:8080/oauth/token)

Body: 
    
    "destinatario": "Thiago Andrade",
    "nome": "Thiago Andrade",
    "email": "testando@gmail.com"

### Resgatar Voucher:

Metodo HTTP GET:

    localhost:8080/vouchers?email={parametro}&codigoVoucher={parametro}
    
    url exemplo: localhost:8080/vouchers?email=testando@gmail.com&codigoVoucher=VOUCHER70

Authorization Bearer Token:

    token: access_token (gerado no localhost:8080/oauth/token)

# Documentação Swagger: 

	http://localhost:8080/swagger-ui/index.html
    
    adicionar /voucher no campo de pesquisa do swagger


