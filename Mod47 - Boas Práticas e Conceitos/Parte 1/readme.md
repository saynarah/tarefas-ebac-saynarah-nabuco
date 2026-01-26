# Boas práticas e conceitos

## Módulo 47 - Especialista Back-end Java (EBAC)

### Palavras-chave

* Boas práticas de escrita de código
* Nomenclaturas
* Código limpo


### Exercício 1 – Importância de se escrever código limpo

Explique, com suas palavras, por que os seguintes princípios de código limpo são importantes:

1 - Usar nomenclatura adequada: - uma boa nomenclatura diminui o cansaço cognitivo ao ler um código, facilita na manutenção e no entendimento por terceiros.

2 - Resolver os problemas na causa raiz: ao resolver um problema na causa raiz é possível diminuir complexidade ou ajustes temporários em trechos de código intermediário.

3 - Seguir a política do escoteiro: - a política do escoteiro afirma que devemos deixar o local mais limpo do que quando chegamos. Uma boa prática em desenvolvimento de software é, sempre que possível, melhorar um trecho de código ao identificar uma oportunidade de melhoria. Se não for possível implementar, é importante registrar um ticket e manter aquele ajuste no radar para um momento oportuno.


### Exercício 2 - Para cada uma das assinaturas de método abaixo, explique qual o princípio de código limpo que eles estão ferindo:


1- private void somaNumeros(int a, int b, int c, int d, int e, int f)

O método acima possui muitos argumentos para uma simples soma de números. Isso indica que, provavelmente, o método não está realizando somente uma função.

2- private void oPaiTaOn()

O método acima não possui uma nomenclatura explicativa e que facilite o entendimento. Deve-se ajustar a nomenclatura para a ação que o método propõe realizar.

3- private double checaSaldoEAtualiza(long userId, double value)

Pela nomenclatura do método percebe-se que ele está, possivelmente, realizando mais de uma ação ao mesmo tempo (checkarSaldo e Atualizar). É indicado que essas ações estejam em métodos separados.