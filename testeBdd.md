🧪 Cenários de Teste (BDD)
A seguir, são descritos os principais cenários de teste comportamentais (BDD - Behavior Driven Development) aplicados ao projeto, com foco em funcionalidade, usabilidade e cobertura de regras de negócio.

✅ Cenário 1: Seleção de dieta e cálculo de TMB, IMC e consumo de água
Objetivo: Garantir que, ao selecionar uma dieta e informar os dados pessoais, o sistema calcule corretamente os indicadores.

Dado que o usuário informou peso, altura, idade e sexo
E selecionou a dieta Mediterrânea
Quando ele confirma os dados
Então o sistema deve exibir os valores corretos de:

Taxa de Metabolismo Basal (TMB)

Índice de Massa Corporal (IMC)

Consumo de água recomendado

✅ Cenário 2: Exibição de alimentos recomendados conforme dieta
Objetivo: Verificar se os alimentos exibidos estão de acordo com a dieta escolhida pelo usuário.

Dado que o usuário selecionou a dieta Low Carb
Quando ele avança para a recomendação alimentar
Então o sistema deve exibir alimentos:

Ricos em proteínas

Com gorduras boas

Com baixo teor de carboidratos

✅ Cenário 3: Considerar restrições alimentares nas recomendações
Objetivo: Validar que o sistema filtra os alimentos com base nas restrições alimentares indicadas.

Dado que o usuário informou intolerância à lactose
E escolheu a dieta Vegetariana
Quando o sistema gerar a recomendação de alimentos
Então não deve incluir leite ou derivados nos alimentos sugeridos

✅ Cenário 4: Personalização de alimentos por categoria
Objetivo: Confirmar que o usuário consegue escolher preferências alimentares e isso afeta as recomendações.

Dado que o usuário selecionou a dieta Cetogênica
E marcou preferência por proteínas e legumes
Quando ele gerar a recomendação alimentar
Então o sistema deve priorizar esses grupos nas sugestões

✅ Cenário 5: Teste de usabilidade na seleção de dieta e preenchimento de dados
Objetivo: Avaliar a facilidade de uso da interface, especialmente para usuários com pouca familiaridade digital.

Dado que um usuário abre o formulário de seleção de dieta
Quando ele preenche os dados e navega pelas etapas
Então todas as interações devem ser:

Intuitivas

Com instruções claras

Com respostas rápidas e consistentes