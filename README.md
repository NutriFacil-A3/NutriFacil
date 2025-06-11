# NutriFacil
Repositório principal do projeto-A3 da UC - Gestão e Qualidade de Software.

# Descrição do projeto
O projeto NutriFácil foi desenvolvido com o objetivo de oferecer uma ferramenta que facilite o trabalho de nutricionistas no planejamento e acompanhamento de dietas personalizadas para seus pacientes. A aplicação possibilita o gerenciamento dos dados nutricionais, controle da evolução física dos pacientes e comunicação direta entre profissional e paciente. Os dados são armazenados em arquivos JSON, o que proporciona uma estrutura simples para o armazenamento e recuperação das informações.
# Instalação e Execução do Projeto
Para executar o projeto localmente, é necessário ter instalado Java (versão 11 ou superior) e Maven para a construção e execução do backend, além das ferramentas necessárias para o frontend conforme especificado no manual do projeto.
Os passos básicos para instalação são:

Clonar o repositório do projeto;

Construir e executar o backend usando Maven;

Configurar e executar o frontend conforme orientações específicas.
# Uso do projeto
## Documentação da classe Menu
A classe `Menu` gerencia a interface de linha de comando do sistema NutriFácil, permitindo interação com o usuário para cadastro, consulta e cálculo de dados nutricionais.

## Principais funcionalidades

**Exibir dietas disponíveis**: lê e mostra as dietas cadastradas no sistema.
- **Exibir usuários cadastrados:** lista os usuários com seus dados básicos.
- **Cadastrar novo usuário:** coleta informações do usuário via input, processa restrições e dieta, e salva os dados.
- **Exibir cálculos nutricionais:** para cada usuário, mostra Taxa Metabólica Basal (TMB), Índice de Massa Corporal (IMC) e consumo diário recomendado de água.
- **Exibir recomendações calóricas:** apresenta déficit ou superávit calórico baseado no objetivo do usuário (emagrecimento ou hipertrofia).
- **Menu principal:** exibe opções numeradas para navegar pelas funcionalidades e controla o fluxo do programa via `Scanner`.

## Dependências

- Utiliza a classe `FileDB` para persistência de dados.
- Depende das classes `Usuario` e `Dieta` para manipulação e validação dos dados do usuário.

# Créditos
Desenvolvido por: 
Gabriel Alves Amorim Vasconcelos (https://github.com/GabrielV21)
Arthur Felipe Silva Leandro (https://github.com/ArthurFelipeSL)
Victor Joseph Faria (https://github.com/VictorJosephF)
Pedro Henrique de Melo Silva (https://github.com/pedroohms)
Ideval Alves de Lima (https://github.com/idevalima)
Lucas Oliveira Souza (https://github.com/Lucasos8)
Matheus Magalhães Alves Lopes (https://github.com/MatheusLopes21
Josué Israel Rodrigues (https://github.com/josuedev04)

## Licença
Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
Você pode:
- Usar o código livremente em projetos pessoais e comerciais.
- Modificar, distribuir e sublicenciar o projeto, desde que mantenha os créditos aos autores originais.

Para saber mais sobre outras licenças, visite: [https://choosealicense.com/](https://choosealicense.com/)
