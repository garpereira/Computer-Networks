# Projeto Conteúdo Dinâmico

Este é um projeto simples que demonstra como criar uma página HTML com conteúdo dinâmico que exibe o endereço IP, data, hora e local do visitante. O conteúdo é atualizado a cada solicitação.

## Tecnologias Utilizadas

- HTML: Para a estrutura da página.
- JavaScript: Para obter informações como o endereço IP, data, hora e local do visitante.
- Tailwind CSS: Para estilizar a página de forma simples.

## Como Usar

1. Clone o repositório:

   ```shell
   git clone https://github.com/garpereira/Computer-Networks.git
   ```
1.1 Acesse o diretório recém-clonado:

   ```shell
   cd Computer-Networks
   git sparse-checkout init --cone
   git sparse-checkout set PROJETO_WEB
   ```
2. Abra o arquivo index.html em seu navegador:

    - Basta abrir o arquivo index.html em seu navegador para ver a página em funcionamento.

## Configuração do Servidor Apache2

Se você deseja configurar o projeto para rodar no servidor Apache2, siga estas etapas:

3. Certifique-se de que o Apache2 está instalado em seu servidor.

4. Copie o conteúdo do projeto para o diretório raiz do Apache2. Isso pode ser feito, por exemplo, copiando os arquivos para o diretório `/var/www/html/` no seu servidor.

5. Configure um VirtualHost no Apache2 para o seu projeto. Você pode criar um arquivo de configuração para o seu site em `/etc/apache2/sites-available/` e habilitá-lo usando o comando `a2ensite`. Não se esqueça de reiniciar o Apache2 para que as alterações tenham efeito.
   ```shell
      sudo systemctl restart apache2
   ```

7. Certifique-se de que as configurações do Apache2, como as portas e as permissões de diretório, estejam configuradas corretamente para o seu projeto.

## API de Geolocalização

Para obter informações de geolocalização aproximada do visitante, este projeto utiliza a API de geolocalização reversa do OpenCage Data. Certifique-se de obter uma chave de API válida do OpenCage Data e substituir `'apiKey'` no código JavaScript pelo valor correto.

## Personalização

Você pode personalizar o projeto da seguinte forma:

   - Modificar o estilo: Você pode ajustar a aparência da página modificando as classes do Tailwind CSS no arquivo HTML.
   - Alterar o comportamento: Você pode estender a funcionalidade do JavaScript para incluir mais informações ou personalizar o conteúdo dinâmico.

## Como Contribuir

Se você deseja contribuir para este projeto, sinta-se à vontade para abrir problemas (issues) ou enviar solicitações de pull (pull requests) para melhorias, correções ou recursos adicionais. Toda contribuição é bem-vinda!

## Licença

Este projeto está sob a Licença MIT - consulte o arquivo LICENSE para obter detalhes.

## Autor
   - Gabriel Almeida
