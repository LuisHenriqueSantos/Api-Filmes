# 🎬 API de Filmes

Projeto desenvolvido em Java 21 com Spring Boot, com o objetivo de gerenciar o cadastro de filmes. A aplicação oferece uma API RESTful documentada com SpringDoc (OpenAPI 3).


## 🔧 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring DevTools
- SpringDoc OpenAPI (Swagger)
- Maven

- ## 📌 Funcionalidades

- ✅ Cadastro de filmes  
- ✅ Id do filme deve ser único
- ✅ A nota do filme deve ser um inteiro entre 1 e 5, não sendo aceitas notas diferentes
- ✅ O conjunto de nome, ano e diretor deve ser úmico para evitar o cadastro de filmes duplicados
- ✅ Lista todos os filmes cadastrados
- ✅ Busca de filmes por ID  
- ✅ Atualização de dados do filme  
- ✅ Deleta o filme por ID
- ✅ Documentação automática com Swagger UI

## 📄 Estrutura do projeto

```
src
└── main
└── java
└── com.mentorama.apifilmes
├── controller
│ ├── FilmeController.java
├── entities
│ ├── Filme.java
├── repository
│ ├── FilmeRepository.java
├── service
│ └── FilmeService.java
| └── IFilmeService.java
└── ApiFilmesApplication.java
```

---

## 🔗 Endpoints

| Método HTTP | Endpoint         | Descrição                                 |
|-------------|------------------|------------------------------------------ | 
| `POST`      | `/api/filme`         | Adiciona um novo filme                |
| `GET`       | `/api/filme`         | Lista todos os filmes                 |
| `GET`       | `/api/filme{id}`    | Busca um filme específico pelo ID      |
| `PUT`       | `/api/filme{id}`    | Atualiza os dados de um filme existente|
| `DELETE`    | `/api/filme{id}`    | Remove um filme do sistema             |

---

## ▶️ Como executar

1. Clone o repositório:
```bash
git clone https://github.com/LuisHenriqueSantos/Api-Filmes.git
```
2. Execute o projeto
```bash
cd Api-Filmes
```
3. Execute a Class de inicialização

# 🌐 Acessando a API
Após subir a aplicação, acesse:
- Documentação: [Acesse a documentação aqui](http://localhost:8080/v3/api-docs)


🧑‍💻 Autor
Desenvolvido por **Luis Henrique Santos** durante o curso Java Pro da Mentorama.






