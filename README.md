# MagnetoProject

Magneto quer recrutar a maior quantidade de mutantes para lutar contra os X-Men, para isso ele encomendou um software que identifique as sequências de DNA para identificar mutantes e humanos.

## Pre-requisito

Para o funcionamento do projeto será necessário.

| Java 1.8+ |
| Gradle 3+ |
| Mongo 4.0 |

##### Mongo

Efetuar o download do Mongo, descompactar, acessar a pasta do Mongo, criar a pasta de dados e executar o Mongo.

```bash
mkdir data
cd bin
./mongod --dbpath ../data
```

## Obtendo e configurando o projeto
Obtendo o projeto e acessando a pasta

```bash
git clone https://github.com/joaoeduardorf/MagnetoProject.git
cd MagnetoProject
```

Patindo a pasta raíz do projeto é possível acessar a pasta src/main/resources onde se encontra o arquivo application.properties contendo a configuração do Mongo da aplicação.

```bash
spring.data.mongodb.host=127.0.0.1
spring.data.mongodb.port=27017
spring.data.mongodb.database=Magneto
```
## Executando o projeto

Partindo da pasta raíz do projeto é possível executar o projeto com os comando a seguir:

###### Linux ou Mac
```bash
./gradlew bootJar
./gradlew bootRun
```

###### Windows
```bash
gradlew.bat bootJar
gradlew.bat bootRun
```

## Tests

Para executar os testes automatizados via linha de comando será necessário executar o seguinte comando na parta raíz do projeto.

###### Linux ou Mac

```bash
./gradlew test
```

###### Windows

```bash
gradlew.bat test
```

## 

##### Verificar se o DNA é mutante

Para verificar se o DNA é mutante será necessário fazer um POST no **HOST** com o **JSON** do exemplo a seguir:

**HOST**

```host
http://localhost:8080/mutant
```

**JSON**

```json
{
	"dna" : ["GTGCGA","CAGTGC","TTATGT","AGAAGG","ACCCTA","TCACTG"]
}
```

**Response**

O response irá retorna os seguintes status:

Status 200 - mutante

```json
Status code: 200 
Response body: true
```

Staus 403 - humana.


```json
Status code: 403 
Response body: false
```

##### Estatísticas

Para obter a estatística com a proporção de quantos mutantes para cada humano será necessário fazer um **GET** no **HOST**.

**HOST**

```bash
http://localhost:8080/stats
```

**Dados**

```bash
{
    "_countMutants": 15,
    "_countHumans": 2,
    "_ratio": 7.5
}
```

## License

Esse será utilizado apenas para estudo e não será continuado, podendo assim ser utilizado livremente.

[MIT](https://choosealicense.com/licenses/mit/)
