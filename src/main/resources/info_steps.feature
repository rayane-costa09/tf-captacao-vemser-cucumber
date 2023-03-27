Funcionalidade: Testar o formulário de informações pessoais

@TC10
Cenário: Verificar quantidade de dígitos a mais permitidos no campo de celular
    Dado que estou na página de informações pessoais
    Quando preencho os campos do formulário com um número de celular inválido
    Então o ícone de confirmação não deve ser exibido

@TC06
Cenário: Tentar informar cidade que não contém no estado escolhido
    Dado que estou na página de informações
    Quando preencho o nome com um nome completo válido
    E preencho o email com um email válido
    E preencho o RG com um RG válido
    E preencho o CPF com um CPF válido
    E preencho o telefone celular com um telefone válido
    E preencho a data de nascimento com uma data válida
    E preencho a cidade com "Fortaleza"
    E preencho o estado com "BA"
    E marco a opção de neurodiversidade como "false"
    E clico no botão "Próximo"
    Então o ícone de confirmação não deve ser exibido

@TC20
Cenário: Tentar fazer inscrição com email inválido usando acento no texto
    Dado que o usuário preenche o formulário com um email inválido contendo acento no nome
    Quando o usuário clica no botão Avançar após preencher o formulário com um email inválido contendo acento no nome
    Então o ícone de confirmação não deve ser exibido para o formulário preenchido com um email inválido contendo acento no nome


@TC21
Cenário: Tentar fazer cadastro com idade não permitida
    Dado que o usuário preenche o formulário com uma data de nascimento que representa uma idade menor que 16 anos
    Quando o usuário clica no botão Avançar após preencher o formulário com uma data de nascimento que representa uma idade menor que 16 anos
    Então a mensagem de erro "A data de nascimento deve ter no mínimo 16 anos" deve ser exibida
