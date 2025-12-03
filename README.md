## Projeto

Grafo com Busca em Profundidade (DFS) e Interface Swing

## Descrição do Problema e Solução

O objetivo do trabalho é implementar uma estrutura de grafo com operações básicas e, opcionalmente, algoritmos clássicos.
A solução desenvolvida utiliza um grafo não direcionado representado por lista de adjacência, permitindo:

adicionar e remover vértices

adicionar e remover arestas

exibir o grafo

executar a Busca em Profundidade (DFS) a partir de um vértice inicial

Também foi criada uma interface gráfica simples em Java Swing para demonstrar o funcionamento do grafo e do algoritmo de busca.

## Linguagme Utilizada

Java 8+

## Exemplo entrada e saída

`Exemplo 1: Criar grafo de amigos` 

## Entrada (arestas adicionadas):

Ana - Bruno
Ana - Carla
Bruno - Diego
Carla - Diego
Diego - Elisa

## Saída (representação do grafo):

Ana -> [Bruno, Carla]
Bruno -> [Ana, Diego]
Carla -> [Ana, Diego]
Diego -> [Bruno, Carla, Elisa]
Elisa -> [Diego]


`Exemplo 2: Execução da DFS` 

## Entrada

Início da DFS: Ana

## Saída 

Ordem de visita (DFS) a partir de Ana:
[Ana, Bruno, Diego, Carla, Elisa]

(A ordem exata pode variar conforme a ordem de visita dos vizinhos, mas sempre segue a lógica da busca em profundidade.)

## Requisitos Implementados

Requisitos mínimos:

Representação do grafo por lista de adjacência

Adicionar vértice

Remover vértice

Adicionar aresta

Remover aresta

Exibir grafo

Caso de uso demonstrativo (rede de amigos)

Requisito avançado:

Implementação do algoritmo clássico DFS (Busca em Profundidade), exibindo a ordem de visita dos vértices a partir de um vértice inicial escolhido pelo usuário na interface gráfica.


