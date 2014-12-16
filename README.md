edemocracia
===========
O portal e-Democracia é um espaço público, virtual e interativo da Câmara dos Deputados, criado para incentivar a participação da sociedade, por meio da internet, no debate de temas importantes para o país. Em 2013, a discussão do marco civil da internet recebeu 374 contribuições ao projeto de lei, seis delas acatadas pelo relator. Com mais de 55 mil acessos por mês em 2014, o e-Democracia tem 32 mil usuários cadastrados. <br/><br/>
Está dividido em dois grandes blocos colaborativos: as Comunidades Legislativas e o Espaço Livre. No primeiro, são debatidos temas específicos, normalmente relacionados a projetos de lei já existentes. As Comunidades oferecem diferentes instrumentos de colaboração e, ainda, orientações quanto ao andamento da matéria no Congresso Nacional. No Espaço Livre, pode-se definir o tema da discussão e motivá-la. O debate é acompanhado pela equipe e-Democracia e pode vir a se tornar uma Comunidade Legislativa.<br/>
Para participar, basta se cadastrar. <br/><br/>
Funcionalidades<br/><br/>
•	Fóruns de discussão com temas escolhidos pelos próprios usuários do portal (Espaço Livre);<br/>
•	Comunidades legislativas – para participação em debates relacionados a projetos de lei já existentes;<br/>
•	Eventos interativos – para acompanhar, ao vivo, eventos que estão acontecendo na Câmara dos Deputados (audiências públicas, seminários de Comissões etc.), com envio de sugestões, dúvidas e opiniões, por meio de bate-papo on-line;<br/>
•	Biblioteca virtual – espaço de comunidades temáticas onde são armazenados documentos digitais relacionados aos temas (estudos e artigos científicos, legislação existente etc.);<br/>
•	Salas de bate-papo;<br/>
•	Enquetes;<br/>
•	Notícias e eventos; <br/>
•	Wikilegis – espaço colaborativo para propor alterações a projetos de lei em discussão ou construir novo texto. Após fazer sugestões, proposta pode ser salva para visualização e contribuição;<br/>
•	Informações produzidas pelo sistema podem ser sintetizadas em relatórios e enviadas aos deputados.<br/><br/>
Como acessar: <br/><br/>
Pela internet: http://edemocracia.camara.leg.br/<br/>
Facebook: https://www.facebook.com/edemocraciacamara <br/>
Twitter: https://twitter.com/Edemocracia<br/>
YouTube: http://www.youtube.com/user/edemocraciacd/featured <br/>
Flickr: https://www.flickr.com/photos/edemocracia/ <br/>

<br/><br/>

##Instalação do e-Democracia 

###Ambiente

* Liferay Portal Community Edition 6.1.1 CE GA2 (Tomcat bundle)
* JRE 1.6
* SQL Server 10


###Instruções

1. Baixar os pacotes source (código fonte do liferay) e portal(liferay) do site da liferay observando versões especificadas  acima

2. Adicionar as bibliotecas do jsf  versão 2.1.13 no diretório: /tomcat-7.0.27/lib/ext dentro do liferay

3. Criar o banco de dados e configurar o datasource com as configurações do banco utilizado e adicionar o nome do datasource criado no arquivo portal-ext.properties através da propriedade: jdbc.default.jndi.name=NOMEDODATASOURCE

* Este arquivo se encontra dentro do projeto cd-edemocracia-ext, no diretório: cd-edemocracia-ext-ext
* É necessário abrir este arquivo e adicionar as configurações necessárias
* Copiar este arquivo para um diretório acima da pasta do tomcat

4. Instalar o ext

* Fazer o build do projeto cd-edemocracia-ext utilizando o maven
* Acessar a pasta cd-edemocracia-ext-ext-impl/target/classes dentro do projeto. Copiar os subdiretórios br, com e templates e colar dentro do arquivo jar do liferay chamado portal-impl.jar, localizado no diretório /tomcat-7.0.27/webapps/ROOT/WEB-INF/lib. Copiar o arquivo ext-spring que está dentro de cd-edemocracia-ext-ext-impl/target/classes/META-INF para a pasta META-INF dentro do portal-impl.jar.
* Acessar a pasta cd-edemocracia-ext-ext-util-java/target/classes dentro do projeto. Copiar o subdiretório chamado com e colar dentro do arquivo jar do liferay chamado util-java.jar, localizado no diretório /tomcat-7.0.27/webapps/ROOT/WEB-INF/lib/

5. Copiar o arquivo usuário.lar no diretório cd-edemocracia-ext/doc para o diretório /data que fica um diretório acima da pasta do tomcat

6. Fazer o build de todos os portlets e efetuar o deploy no servidor. Para isso copie o war (máximo recomendado: 2 em 2 por vez) e cole na pasta deploy

7. Configurar SSL do Tomcat (http://tomcat.apache.org/tomcat-7.0-doc/ssl-howto.html)


