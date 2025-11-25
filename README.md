## Projeto

Grafo com Busca em Largura (BFS) e Interface Swing

## Descrição do Problema e Solução

O objetivo do trabalho é implementar uma estrutura de grafo com operações básicas e, opcionalmente, algoritmos clássicos.
A solução desenvolvida utiliza um grafo não direcionado representado por lista de adjacência, permitindo adicionar e remover vértices e arestas, exibir o grafo e executar a Busca em Largura (BFS).
Também foi criada uma interface gráfica simples para demonstrar o funcionamento do grafo e do algoritmo.

## Linguagme Utilizada

Java 8+

## Exemplo entrada e saída

`Exemplo 1: Criar grafo de amigos` 

## Entrada

Ana - Bruno
Ana - Carla
Bruno - Diego
Carla - Diego
Diego - Elisa

## Saída

Ana -> [Bruno, Carla]
Bruno -> [Ana, Diego]
Carla -> [Ana, Diego]
Diego -> [Bruno, Carla, Elisa]
Elisa -> [Diego]


`Exemplo 2: Criar grafo de amigos` 

## Entrada

Início: Ana
Destino: Elisa

## Saída 

Ordem de visita: [Ana, Bruno, Carla, Diego, Elisa]
Caminho mínimo: [Ana, Bruno, Diego, Elisa]
Distancia: 3

## Requisitos Implementados

Requisitos mínimos:

Representação do grafo (lista de adjacência)

Adicionar vértice
Remover vértice
Adicionar aresta
Remover aresta
Exibir grafo
Caso de uso demonstrativo (rede de amigos)
Requisito avançado:
Algoritmo BFS com: Ordem de visita

Caminho mínimo em número de arestas


