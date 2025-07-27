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

