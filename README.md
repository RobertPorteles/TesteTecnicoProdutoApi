<img width="712" height="653" alt="image" src="https://github.com/user-attachments/assets/d258834f-faa4-4e50-a5ac-ee369231c57b" />

🧭 Interpretação do seu diagrama
🔹 HL – High Level (Regra de Negócio / Domain)
Essa é a camada de alto nível, que contém:

Entity → a estrutura central dos seus dados

DTOs → ProdutoRequest e ProdutoResponse para entrada e saída de dados

Uma interface que define o contrato para o serviço de produtos

➡️ Ou seja, a regra de negócio define o que precisa ser feito, mas não sabe como será feito (isso é abstração).

🔹 ML – Module Low (Infraestrutura / Implementação)
Aqui temos:

A interface ProdutoService

A implementação concreta ProdutoServiceImpl

➡️ A implementação do método salvar() está em ProdutoServiceImpl, mas quem define que existe esse método é a interface (ProdutoService), que pertence à camada de domínio (Domain/HL).


🧩 ProdutoMapper – Separando a Lógica de Conversão
Para manter a classe ProdutoServiceImpl limpa e com responsabilidade única, foi criado o pacote mappers, contendo a classe ProdutoMapper.

✅ Objetivo
A ProdutoMapper centraliza a lógica de conversão entre os objetos de domínio (Produto) e os objetos de entrada e saída da API (ProdutoRequest e ProdutoResponse), além de encapsular lógicas auxiliares como atualização e busca por ID.

🚀 Benefícios
Organização: separa responsabilidades, evitando que a service fique sobrecarregada com lógica de mapeamento.

Reutilização: os métodos toEntity, toResponse e updateEntityFromRequest podem ser usados em qualquer parte da aplicação que precise dessas conversões.

Facilidade para testes unitários: é mais fácil testar transformações de dados isoladamente.

Aderência ao princípio SRP (Single Responsibility Principle).

📁 Localização
text
Copiar
Editar
src/
└── main/
    └── java/
        └── br/com/estudo/
            ├── domain/
            │   ├── dtos/
            │   ├── entities/
            │   └── mappers/
            │       └── ProdutoMapper.java
            └── service/
                └── ProdutoServiceImpl.java
🔧 Exemplo de métodos presentes:
java
Copiar
Editar
public Produto toEntity(ProdutoRequest produtoRequest)
public ProdutoResponse toResponse(Produto produto)
public void updateEntityFromRequest(ProdutoRequest req, Produto produto)
public Produto achaPorId(UUID id)
Com isso, a classe ProdutoServiceImpl foca apenas na regra de negócio, delegando a transformação de dados para o mapper.

