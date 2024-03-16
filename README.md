# Inicio rápido

### Baixe as collections do postman
[Postman](https://firebasestorage.googleapis.com/v0/b/app-english-class.appspot.com/o/hackaton.postman_collection.json?alt=media&token=9c92c08c-2a9b-4c1f-a916-850b00924094)

### 1- Siga os passos abaixo

# Clientes

consultar clientes
```curl
curl --location 'http://localhost:8080/api/clientes'
```

cadastrar clientes
```curl
curl --location 'http://localhost:8080/api/clientes' \
--header 'Content-Type: application/json' \
--data-raw '{
	"paisDeOrigem": "Brasil",
	"cpf": "12345678902",
	"nomeCompleto": "Fulano de Tal",
	"dataNascimento": "1990-01-01",
	"rua": "Rua um dois tres quarto",
	"estado": "São Paulo",
	"cidade": "Sao paulo",
	"cep": "07865320",
	"telefone": "1112345678",
	"email": "ADD_EMAIL_VALIDO"
}'
```

editar cliente
```curl
curl --location --request PUT 'http://localhost:8080/api/clientes/ID_DO_CLIENTE' \
--header 'Content-Type: application/json' \
--data-raw '{
	"paisDeOrigem": "Brasil",
	"cpf": "12345678901",
	"nomeCompleto": "Fulano de Tal atualizado",
	"dataNascimento": "1990-01-01",
	"rua": "rua um dois tres",
	"estado": "São Paulo",
	"cidade": "sao paulo",
	"cep": "12345678",
	"telefone": "111234-5678",
	"email": "ADD_EMAIL_VALIDO"
}'
```

remover cliente
```curl
curl --location --request DELETE 'http://localhost:8080/api/clientes/ID_DO_CLIENTE'
```

# Predios

Adicionar predos e amenidades
```curl
curl --location 'http://localhost:8080/api/predios' \
--header 'Content-Type: application/json' \
--data '{
	"rua": "Rua Teste, 123",
	"cep": "04851410",
	"cidade": "Cidade Teste",
	"estado": "Estado Teste",
	"amenidades": [
		{
			"nome": "Academia",
			"descricao": "Academia equipada com os mais modernos aparelhos de exercício."
		},
		{
			"nome": "Piscina",
			"descricao": "Piscina climatizada para relaxar e se refrescar nos dias quentes."
		}
	]
}'
```

Consultar predios
```curl
curl --location 'http://localhost:8080/api/predios'
```

Editar predios e amenidades
```curl
curl --location --request PUT 'http://localhost:8080/api/predios/PREDIO_ID' \
--header 'Content-Type: application/json' \
--data '{
	"rua": "Rua Teste, 123",
	"cep": "04851410",
	"cidade": "Cidade Teste",
	"estado": "Estado Teste",
	"amenidades": [
		{
			"id": "AMENIDADE_ID",
			"nome": "Academia",
			"descricao": "Academia equipada com os mais modernos aparelhos de exercício."
		},
		{
			"id": "AMENIDADE_ID",
			"nome": "Piscina",
			"descricao": "Piscina climatizada para relaxar e se refrescar nos dias quentes."
		}
	]
}'
```

Remover Predios
```curl
curl --location --request DELETE 'http://localhost:8080/api/predios/'
```

# Quartos

Adicionar quartos
```curl
curl --location 'http://localhost:8080/api/quartos' \
--header 'Content-Type: application/json' \
--data '{
	"quantidade": 2,
	"tipo": "Quarto de Luxo",
	"totalDePessoas": 4,
	"valorDaDiaria": 200.00,
	"predioId": "PREDIO_ID",
	"moveis": [
		{
			"nome": "Cama king size",
			"descricao": "Cama de Casal",
			"quantidade": 1
		},
		{
			"nome": "Guarda-roupa ",
			"descricao": "Guarda-roupa espelhado",
			"quantidade": 1
		},
		{
			"nome": "Mesa de escritorio",
			"descricao": "Mesa de Trabalho",
			"quantidade": 1
		}
	],
	"banheiros": [
		{
			"descricao": "Banheiro Social",
			"quantidade": 1
		},
		{
			"descricao": "Banheiro da Suíte",
			"quantidade": 1
		}
	]
}'
```

Remover quartos
```curl
curl --location --request DELETE 'http://localhost:8080/api/quartos/QUARTO_ID'
```

Editar quartos
```curl
curl --location --request PUT 'http://localhost:8080/api/quartos/QUARTO_ID' \
--header 'Content-Type: application/json' \
--data '{
	"tipo": "Quarto Luxo att",
	"totalDePessoas": 2,
	"valorDaDiaria": 150.00,
	"quantidade": 5,
	"banheiro": [
		{
			"id": "BANHEIRO_ID",
			"descricao": "Banheiro Social att",
			"quantidade": 2
		},
		{
			"id": "BANHEIRO_ID",
			"descricao": "Banheiro da Suíte att",
			"quantidade": 1
		}
	],
	"movel": [
		{
			"id": "MOVEL_ID",
			"nome": "Cama King att",
			"quantidade": 1
		},
		{
			"id": "MOVEL_ID",
			"nome": "Guarda-roupa Grande att",
			"quantidade": 1
		}
	]
}'
```

Consultar quartos
```curl
curl --location 'http://localhost:8080/api/quartos/consultar' \
--header 'Content-Type: application/json' \
--data '{
	"quantidadeDePessoas": 2,
	"dataEntrada": "2024-03-15",
	"dataSaida": "2024-03-17"
}'
```

# Servicos

consultar servicos

```curl
curl --location 'http://localhost:8080/api/servicos'
```

Adicionar servicos
```curl
curl --location 'http://localhost:8080/api/servicos' \
--header 'Content-Type: application/json' \
--data '{
	"nome": "Aulas de Judo",
	"predioId": "82f4a93b-2a25-4cd2-a5d0-058204550478",
	"preco": 200
}'
```

Editar servicos
```curl
curl --location --request PUT 'http://localhost:8080/api/servicos/SERVICO_ID' \
--header 'Content-Type: application/json' \
--data '{
	"nome": "Aulas de judo 123",
	"preco": 34.90
}'
```

Remover servicos
```curl
curl --location --request DELETE 'http://localhost:8080/api/servicos/'
```

# Produtos

consultar
```curl
curl --location 'http://localhost:8080/api/produtos'
```

editar
```curl
curl --location --request PUT 'http://localhost:8080/api/produtos/PRODUTO_ID' \
--header 'Content-Type: application/json' \
--data '{
	"quantidade": "300",
	"nome": "Guarana",
	"preco": 20.00
}'
```

remover
```curl
curl --location --request DELETE 'http://localhost:8080/api/produtos/'
```

adicionar
```curl
curl --location 'http://localhost:8080/api/produtos' \
--header 'Content-Type: application/json' \
--data '{
	"nome": "Coca-Cola",
	"id": "PREDIO_ID",
	"preco": 12.60,
	"quantidade": 40
}'
```


#### Reservas
```curl
curl --location 'http://localhost:8080/api/reservas/CLIENTE_ID' \
--header 'Content-Type: application/json' \
--data '[
	{
		"dataEntrada": "2024-03-15",
		"dataSaida": "2024-03-20",
		"quantidadeDePessoas": 2,
		"quantidadeDeQuartos": 1,
		"idDoQuarto": "QUARTO_ID",
		"servico": [
			{
				"id": "SERVICO_ID",
				"quantidade": 2
			}
		],
		"produto": [
			{
				"id": "PRODUTO_ID",
				"quantidade": 5
			}
		]
	}
]'
```

### Documentação do(s) bancos de dados utilizados
Banco: Postgresql

[Diagrama do banco de dados e relacionamento entre tabelas](https://firebasestorage.googleapis.com/v0/b/app-english-class.appspot.com/o/DiagramaDeTabelas-hackaton.drawio.png?alt=media&token=e715dff0-1200-419f-abe0-5803613160b3)
