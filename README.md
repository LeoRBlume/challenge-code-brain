# Sistema de Score de Vendas

Este projeto se consiste na criação das API's para serem consumidas por um
frontend

## Rodando a aplicação

Para rodar a aplicação basta rodar o seguinte comando no terminal:
```shell script
Na pasta do projeto no terminal, digitar o seguinte comando: 

./mvnw compile quarkus:dev
```

> **_Obs:_**  A Aplicação sera ouvida na porta 8080: http://localhost:8080/

## Explicando os Endpoints
###Endpoints de Vendedor:
Os endpoints vendedores estão divididos em 5 funcionalidades:

####Listar todos os vendedores:
```shell script
Metodo GET:
url: http://localhost:8080/vendedor

Ira retornar uma lista de vendedores

[
  {
      "id": id,
      "matricula": matricula,
      "nome": "nome"
  },
  {
      "id": id,
      "matricula": matricula,
      "nome": "nome"
  },
]

```

####Obter um vendedor especifico:
```shell script
Metodo GET:
url: http://localhost:8080/vendedor/{matriculaDoVendedor}

Ira retornar um vendedor caso tenha com a matricula
{
      "id": id,
      "matricula": matricula,
      "nome": "nome"
}
```

####Cadastrar um vendedor:
```shell script
Metodo POST:
url: http://localhost:8080/vendedor
body: 
{
	"matricula": matricula,
	"nome": "Nome do vendedor"
}

So pode ter um vendedor por matricula e precisa ser informada a matricula.

Ira retornar um JSON do objeto criado com o id

{
      "id": id,
      "matricula": matricula,
      "nome": "nome"
}
```

####Atualizar um vendedor:
```shell script
Metodo PUT:
url: http://localhost:8080/vendedor
body: 
{
      "id": id,
      "matricula": matricula,
      "nome": "nome"
}
Para atualizar um vendedor, o id de um vendedor precisa ser informado.
```

####Deletar um vendedor:
```shell script
Metodo DELETE:
url: http://localhost:8080/vendedor/{idDoVendedor}

Para deletar um vendedor, um id de um vendedor precisa ser informado e sera retornado
um JSON com o Vendedor deletado.
{
      "id": id,
      "matricula": matricula,
      "nome": "nome"
}
```

###Endpoints de Produtos:
Os endpoints produtos estão divididos em 4 funcionalidades:

####Listar todos os produtos:
```shell script
Ira retornar uma lista de produtos

[
{
    "id": id,
    "nome": "nome do produto",
    "preco": preco do produto
  },
{
    "id": id,
    "nome": "nome do produto",
    "preco": preco do produto
  },
]
```

####Cadastrar um produto:
```shell script
Metodo POST:
url: http://localhost:8080/produto
body: 
{
    "nome": "nome do produto",
    "preco": preco do produto
}

So pode ter um produto por nome e pode ser passado ou não o preco 
atribuindo como 0 caso não

Ira retornar um JSON do objeto criado com o id

{
    "id": id,
    "nome": "nome do produto",
    "preco": preco do produto
}
```

####Atualizar um produto:
```shell script
Metodo PUT:
url: http://localhost:8080/produto
body: 
{
    "id": id,
    "nome": "nome do produto",
    "preco": preco do produto
}
Para atualizar um produto, o id de um produto precisa ser informado.
```

####Deletar um produto:
```shell script
Metodo DELETE:
url: http://localhost:8080/produto/{idDoProduto}

Para deletar um produto, um id de um produto precisa ser informado e sera retornado
um JSON com o Produto deletado.
{
    "id": id,
    "nome": "nome do produto",
    "preco": preco do produto
}
```
