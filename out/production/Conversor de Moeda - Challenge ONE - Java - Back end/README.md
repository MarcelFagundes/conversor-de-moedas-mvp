
# Aplicação Conversora de Moedas

Esta é uma aplicação **Conversora de Moedas** desenvolvida em Java que segue a arquitetura **MVP (Model-View-Presenter)**. Ela permite que usuários convertam valores entre duas moedas diferentes utilizando taxas de câmbio atualizadas da ExchangeRate API.

## Índice

- [Recursos](#recursos)
- [Tecnologias](#tecnologias)
- [Arquitetura](#arquitetura)
- [Configuração](#configuração)
- [Uso](#uso)
- [Estrutura do Código](#estrutura-do-código)
- [Melhorias](#melhorias)
- [Licença](#licença)

## Recursos

- Converte um valor de uma moeda para outra utilizando taxas de câmbio atualizadas.
- Valida a entrada do usuário para códigos de moedas e valores.
- Exibe erros caso dados inválidos sejam inseridos.
- Utiliza uma separação clara de responsabilidades através da arquitetura **MVP**.

## Tecnologias

- Java 17
- ExchangeRate API para taxas de câmbio ao vivo.
- Gson para análise de respostas JSON.
- Maven (para gerenciamento de dependências).

## Arquitetura

Este projeto implementa o padrão **MVP (Model-View-Presenter)** para separar as responsabilidades:

- **Model**: Trata a lógica de obtenção das taxas de câmbio da API.
- **View**: Gerencia as interações com o usuário via console, coletando entradas e exibindo resultados ou erros.
- **Presenter**: Coordena a comunicação entre o Model e a View, gerenciando validações e lógica de controle.

### Camadas

1. **Model (`CurrencyConverter.java`)**
   - Responsável pela lógica de conversão de moedas e interação com a ExchangeRate API.

2. **View (`ConsoleCurrencyConverterView.java`)**
   - Interage com o usuário através do console, coleta entradas e exibe resultados.

3. **Presenter (`CurrencyConverterPresenter.java`)**
   - Realiza a validação das entradas do usuário e coordena a comunicação entre a View e o Model.
   - Valida as entradas do usuário (códigos de moedas e valores) antes da conversão.

## Configuração

### Pré-requisitos

- JDK 17 ou superior instalado.
- Maven instalado (para gerenciamento de dependências).

### Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/conversor-de-moedas-mvp.git
cd conversor-de-moedas-mvp
```

### Instalar Dependências

```bash
mvn clean install
```

### Configurar a Chave da API

Atualize a constante `API_KEY` no arquivo `CurrencyConverter.java` com sua chave da API obtida na [ExchangeRate API](https://www.exchangerate-api.com/):

```java
private static final String API_KEY = "sua-chave-api-aqui";
```

### Executando a Aplicação

Compile e execute a aplicação com Maven:

```bash
mvn compile exec:java -Dexec.mainClass="com.exemplo.presenter.CurrencyConverterPresenter"
```

## Uso

Quando você executar a aplicação, será solicitado que insira os seguintes detalhes:

1. **Moeda de Origem**: O código da moeda que você deseja converter (por exemplo, USD, BRL).
2. **Moeda de Destino**: O código da moeda para a qual você deseja converter (por exemplo, EUR, JPY).
3. **Valor**: O valor a ser convertido.

A aplicação validará suas entradas e exibirá o valor convertido se tudo estiver correto. Caso contrário, uma mensagem de erro será mostrada, solicitando que o usuário corrija os dados inseridos.

### Exemplo de Entrada

```
Digite a moeda de origem, ex: USD, BRL, JPY, GBP: USD
Digite a moeda de destino, ex: EUR, JPY, GBP: EUR
Digite o valor que deseja converter: 100
```

### Exemplo de Saída

```
100.00 USD é igual a 94.50 EUR
```

## Estrutura do Código

```
src/main/java/
└── com/exemplo/
    ├── model/
    │   └── CurrencyConverter.java              # Lida com a lógica de conversão de moedas
    ├── presenter/
    │   └── CurrencyConverterPresenter.java     # Gerencia a interação entre Model e View
    │    └── DataValidator.java                 # Valida as entradas do usuário
    └── view/
        └── ConsoleCurrencyConverterView.java   # Gerencia a interação com o usuário via console
```

### Classes Principais

- **CurrencyConverter (Model)**: Contém a lógica para se comunicar com a ExchangeRate API e converter moedas.
- **ConsoleCurrencyConverterView (View)**: Interface de usuário baseada em console para coletar entradas e exibir resultados.
- **CurrencyConverterPresenter (Presenter)**: Valida as entradas, coordena a comunicação entre Model e View.
- **DataValidator**: Contém a lógica para validar códigos de moedas e valores inseridos.

## Melhorias

Algumas possíveis melhorias futuras incluem:

- Implementar uma interface gráfica utilizando JavaFX.
- Adicionar suporte para múltiplas conversões em uma única sessão.
- Implementar um mecanismo de cache para respostas da API, reduzindo chamadas à API.
- Adicionar um tratamento de erros mais detalhado e logging.
- Suportar diferentes formatos para a entrada de valores (por exemplo, permitindo vírgulas em números).

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
