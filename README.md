# OracleOneChallenge-2---Conversor-de-moeda-
//Portuguese version below.

//EN
Currency Converter

This is a simple Java application that allows you to convert values from Colombian peso (COP), Argentine peso (ARS), and Brazilian real (BRL) to US dollar (USD), and vice versa. The application is capable of querying a real-time API to fetch the latest exchange rates.

Features
  Conversion between the following currencies:
    Colombian peso (COP) / US dollar (USD)
    Argentine peso (ARS) / US dollar (USD)
    Brazilian real (BRL) / US dollar (USD)

  Real-time exchange rate lookup: the application uses an API to fetch the latest exchange rates.

Note
  The application is not able to convert from BRL to COP or ARS, only from USD to another currency pair (but it would be easy to implement new currencies).

Prerequisites
  Java JDK installed on your machine
  Java IDE (recommended: IntelliJ IDEA, Eclipse, NetBeans)
  Gson library downloaded to include as a dependency in the package;
  Have an API key from https://www.exchangerate-api.com/. This key must be saved in a JSON file in the following format:
  {"apiKey" : "Your_api_key_here"};

How to Use
  Clone or download this repository to your local machine.
  Open the project in your Java IDE.
  In the ConversionPairRequisition.java class, change line 36 to the correct path of the JSON file containing the API key. In the current setup, you can generate a .jar with dependencies and run it, provided that the file with the API key is in the same folder.
  Generate a .jar file including the dependencies (Gson is the only project dependency) with your IDE. Using IntelliJ:

    1 - Go to File > Project Structure.
    2 - Select Artifacts tab and click on the "+" icon.
    3 - Choose to generate a JAR from modules with dependencies.
    4 - Choose your module and its main class and save changes.
    5 - Now go to Build > build artifacts > build* (rebuild if necessary);
Run with:
  java -jar .\com.allogica.ChallengeConversorMoedas.jar
  Follow the instructions in the command-line interface to perform the desired conversions.

Author

Gustavo Henrique da Costa


//PTBR
Conversor de Moedas

Este é um simples aplicativo em Java que permite converter valores de peso colombiano (COP), peso argentino (ARS) e real brasileiro (BRL) para dólar americano (USD) e de dólar para todas essas. A aplicação é capaz consultar uma API em tempo real para obter as taxas de câmbio mais recentes.
Funcionalidades

    Conversão entre as seguintes moedas:
        Peso colombiano (COP) / Dólar americano (USD)
        Peso argentino (ARS) / Dólar americano (USD)
        Real brasileiro (BRL) / Dólar americano (USD)

    Consulta de taxas de câmbio em tempo real: a aplicação utiliza uma API para obter as taxas de câmbio mais recentes.

Observação

    A aplicação não é capaz de converter de BRL para COP ou ARS, somente o par USD com outra moeda (mas seria fácil de implementar novas moedas).

Pré-requisitos

    Java JDK instalado na máquina
    IDE Java (recomendado: IntelliJ IDEA, Eclipse, NetBeans)
    Gson library baixada para incluir como dependencia do pacote;
    Ter uma chave de API da https://www.exchangerate-api.com/. Essa chave deve estar salva em um arquivo JSON no seguinte formato:
 {"apiKey" : "Sua_chave_de_api_aqui"};

Como usar

    Clone ou faça o download deste repositório para sua máquina local.
    Abra o projeto em sua IDE Java.
    Na classe ConversionPairRequisition.java altere a linha 36 para o caminho correto do arquivo json contendo a chave da api. Na configuração atual pode gerar um .jar com as dependencias e rodar, desde que o arquivo com a chave da api esteja na mesma pasta.
    Gere um .jar incluindo as dependências (Gson é a única dependência do projeto) com a sua IDE. Usando Intellij:
      
      1 - Go to File > Project Structure.
      2 - Select Artifacts tab and click on the "+" icon.
      3 - Choose to generate a JAR from modules with dependencies.
      4 - Choose your module and its main class and save changes.
      5 - Now go to Build > build artifacts > build* (rebuild if necessary);
      1 - Vá para Arquivo > Estrutura do Projeto.
      2 - Selecione a aba Artefatos e clique no ícone "+".
      3 - Escolha gerar um JAR a partir de módulos com dependências.
      4 - Escolha seu módulo e sua classe principal e salve as alterações.
      5 - Agora vá para Build > Construir artefatos > construir* (reconstruir se necessário);
    Rode com:
      java -jar .\com.allogica.ChallengeConversorMoedas.jar
    Siga as instruções na interface de linha de comando para realizar as conversões desejadas.


Autor

Gustavo Henrique da Costa
