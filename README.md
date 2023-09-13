# Objetivo
Projeto tem como principal objetivo a avaliação do teste prático de API utilizando RestAssured, cujo objetivo era testar o método CREATE - POST da api [Reqres](https://reqres.in/api/), validando o Status Code, Campos obrigatórios e Contrato da Response. Também foi utilizado
dados dinâmicos para geração dos dados da request.
# Tecnologias utilizadas
- Java 8
- RestAssured
- JUnit
- Maven
# Cenarios de Teste
- **Criar Usuário** - Realiza a criação do usuário com os atributos não obrigatórios **Name** e **Job**, validando o **Status Code**, o **schema** da response e comparando os dados inseridos na **request** com os retornados na **response**
- **Criar Usuário** passando apenas o parâmetro Name - Realiza a criação de usuário com o atributo não obrigatório **Name**, validando  **Status Code**, o **Schema** da response e compara os dados inseridos na **request** com os retornados na **response**
- **Criar Usuário** passando o parâmetro Name como Inteiro - Realiza a criação de usuário com o atributo não obrigatório **Name**, porém, formatado como **Inteiro**. A definição de nosso **"contrato"** diz que esse atributo é do tipo **String**, portando, esse cenário de teste **falhará**.
# Gerenciando ambiente
- Dependencias do projeto constam no arquivo pom.xml - importar como projeto existente Maven
- Executar classe UserTest como JUnitTest
