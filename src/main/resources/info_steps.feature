Funcionalidade: Testar o formulário de informações pessoais


Cenário: Verificar quantidade de dígitos a mais permitidos no campo de celular
    Dado que estou na página de informações pessoais
    Quando preencho os campos do formulário com um número de celular inválido
    Então o ícone de confirmação não deve ser exibido


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


Cenário: Tentar fazer inscrição com email inválido usando acento no texto
    Dado que o usuário preenche o formulário com um email inválido contendo acento no nome
    Quando o usuário clica no botão Avançar após preencher o formulário com um email inválido contendo acento no nome
    Então o ícone de confirmação não deve ser exibido para o formulário preenchido com um email inválido contendo acento no nome



Cenário: Tentar fazer cadastro com idade não permitida
    Dado que estou na página de informações pessoais
    Quando preencho o formulário com uma data de nascimento menor que 16 anos
    E clico no botão Avançar
    Então a mensagem de erro "A data de nascimento deve ter no mínimo 16 anos" deve ser exibida

Cenário: Tentar fazer cadastro com RG inválido (contendo letras)
    Dado que estou na página de informações pessoais
    Quando preencho o formulário com um RG contendo letras
    E clico no botão Avançar
    Então a mensagem de erro "O RG deve conter apenas números" deve ser exibida

Cenário: Preenchimento de formulário de informações com opção de neurodiversidade ativada
    Dado que estou na página de informações pessoais
    Quando eu preencher todos os campos obrigatórios com dados válidos, incluindo a opção de neurodiversidade ativada
    E clicar no botão Próximo
    Então devo ver o ícone de marcação de verificação na página do formulário

Cenário: Email já cadastrado impede envio do formulário
    Dado que estou na página de informações pessoais
    Quando eu preencher o campo de e-mail com um e-mail já cadastrado
    E clicar no botão Próximo
    Quando eu preencher a segunda parte do formulário
    E clicar no botão Próximo
    Então devo ver uma mensagem de erro informando que o e-mail já está cadastrado

Cenário: CPF já cadastrado impede envio do formulário
    Dado que estou na página de informações pessoais
    Quando eu preencher o campo de CPF com um CPF já cadastrado
    E clicar no botão Próximo
    Então devo ver uma mensagem de erro informando que o CPF já está cadastrado
    E não devo ser direcionado para a página do formulário preenchido com sucesso