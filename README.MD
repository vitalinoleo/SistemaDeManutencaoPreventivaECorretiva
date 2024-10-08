# Sistema de Controle de Estoque e Suprimentos Industriais 

**Descrição**:
O Sistema de Manutenção Preventiva e Corretiva é uma solução projetada para gerenciar o ciclo de manutenção de máquinas e equipamentos industriais. O sistema visa controlar as manutenções preventivas programadas, registrar ocorrências de falhas e gerenciar a alocação de técnicos para intervenções corretivas, além de gerar relatórios detalhados sobre o histórico de manutenção e desempenho dos equipamentos.

## Escopo do Sistema:

### 1 - Cadastro de Máquinas, Equipamentos e Histórico de Manutenção:
**Máquinas e Equipamentos:** Registro completo de cada máquina ou equipamento presente no parque industrial, incluindo:
- Identificação (código, nome da máquina, modelo, fabricante).
- Data de aquisição e vida útil estimada.
- Localização dentro da planta industrial (setor, linha de produção, etc.).
- Epecificações técnicas e manual de operação.
- Histórico completo de intervenções (manutenções preventivas e corretivas).

**Histórico de Manutenção:** Registro detalhado de todas as atividades de manutenção já realizadas:
- Data da manutenção.
- Tipo de intervenção (preventiva ou corretiva).
- Peças trocadas ou reparadas.
- Tempo de parada.
- Técnico responsável pela intervenção.
- Observações sobre o estado do equipamento antes e depois da intervenção.

**Registro de Ocorrências de Falhas e Manutenção Corretiva:**
*Ocorrências de Falhas:* O sistema deve permitir o registro de falhas e problemas inesperados com máquinas e equipamentos. Cada falha registrada deve incluir:
- Data e hora da ocorrência.
- Máquina ou equipamento envolvido.
- Descrição do problema identificado.
- Nível de criticidade (impacto na produção).
- Operador que detectou a falha.

**Manutenção Corretiva:** A partir do registro de falhas, o sistema deve permitir a criação de ordens de serviço para manutenções corretivas:
- Prioridade da manutenção com base na criticidade da falha.
- Alocação automática ou manual de técnicos disponíveis para resolver o problema.
- Registro de tempo de resposta e tempo total da intervenção.
- Cálculo de tempo de máquina parada.

**Acompanhamento em Tempo Real:** Visualização em tempo real das manutenções corretivas em andamento, com informações sobre a fase de execução, técnico alocado, e tempo restante previsto.

## 2 - Manutenção Preventiva Programada:
**Criação de Planos de Manutenção Preventiva:** O sistema deve permitir a criação de planos de manutenção preventiva com base em cronogramas pré-definidos ou medições de uso (como horas de operação ou ciclos de produção):
- Definição de frequência (diária, semanal, mensal, trimestral, etc.).
- Tarefas a serem realizadas em cada inspeção ou intervenção.
- Alocação de técnicos responsáveis.
- Notificações automáticas para o agendamento de manutenções preventivas futuras.

**Automatização de Alertas e Ordens de Serviço:** O sistema deve enviar notificações automáticas aos responsáveis quando uma manutenção preventiva estiver se aproximando, gerando ordens de serviço automaticamente:
- Notificações para técnicos e supervisores.
- Registro de status de cada ordem de serviço (pendente, em andamento, concluída).
- Relatório de conformidade com o cronograma de manutenção preventiva.

## 3 - Geração de Relatórios de Histórico de Manutenção:
**Relatórios de Manutenção Corretiva e Preventiva:** O sistema deve ser capaz de gerar relatórios detalhados de todas as manutenções realizadas:
- Frequência de manutenções preventivas versus corretivas.
- Comparação entre o tempo planejado e o tempo real das manutenções.
- Custo de manutenção (peças e mão de obra).
- Análise de falhas recorrentes em máquinas específicas.

**Relatórios de Desempenho de Técnicos:** Avaliação do desempenho de cada técnico ou equipe de manutenção:
- Tempo de resposta para manutenções corretivas.
- Qualidade do serviço (com base no número de reincidências de falhas).
- Carga de trabalho e número de intervenções realizadas.

## 4 - Interface Gráfica para Acompanhamento do Status de Manutenção e Alocação de Técnicos:
**Painel de Controle em Tempo Real:** A interface gráfica deve permitir o acompanhamento em tempo real do status de todas as manutenções (preventivas e corretivas) e do desempenho das máquinas. Funcionalidades incluem:
- Visualização de quais máquinas estão em operação, em manutenção ou paradas.
- Status das ordens de serviço (pendentes, em execução, concluídas).
- Indicadores de disponibilidade e produtividade das máquinas.

**Alocação de Técnicos e Recursos:** A interface também deve permitir a alocação manual ou automática de técnicos para as intervenções, com base em:
- Agenda de cada técnico.
- Especialização do técnico para cada tipo de máquina ou problema.


## Diagramas
**diagrama de classe** <br>
+---------------------+<br>
|      Equipamento    |<br>
+---------------------+<br>
| - codigo: int       |<br>
| - nome: String      |<br>
| - modelo: String    |<br>
| - fabricante: String |<br>
| - dataAquisicao: String |<br>
| - vidaUtil: int     |<br>
| - localizacao: String|<br>
| - status: String    |<br>
+---------------------+<br>
| + getCodigo(): int  |<br>
| + setCodigo(int)    |<br>
| + getNome(): String |<br>
| + setNome(String)   |<br>
| + getModelo(): String|<br>
| + setModelo(String) |<br>
| + getFabricante(): String |<br>
| + setFabricante(String) |<br>
| + getDataAquisicao(): String |<br>
| + setDataAquisicao(String) |<br>
| + getVidaUtil(): int|<br>
| + setVidaUtil(int)  |<br>
| + getLocalizacao(): String |<br>
| + setLocalizacao(String) |<br>
| + getStatus(): String|<br>
| + setStatus(String)  |<br>
| + toString(): String |<br>
+---------------------+<br>
<br>
+---------------------+<br>
|      Maquina        |<br>
+---------------------+<br>
| - codigo: int       |<br>
| - nome: String      |<br>
| - modelo: String    |<br>
| - fabricante: String |<br>
| - dataAquisicao: String |<br>
| - vidaUtil: int     |<br>
| - localizacao: String|<br>
| - status: String    |<br>
+---------------------+<br>
| + getCodigo(): int  |<br>
| + setCodigo(int)    |<br>
| + getNome(): String |<br>
| + setNome(String)   |<br>
| + getModelo(): String|<br>
| + setModelo(String) |<br>
| + getFabricante(): String |<br>
| + setFabricante(String) |<br>
| + getDataAquisicao(): String |<br>
| + setDataAquisicao(String) |<br>
| + getVidaUtil(): int|<br>
| + setVidaUtil(int)  |<br>
| + getLocalizacao(): String |<br>
| + setLocalizacao(String) |<br>
| + getStatus(): String|<br>
| + setStatus(String)  |<br>
| + toString(): String |<br>
+---------------------+<br>
<br>

+---------------------+<br>
|      Manutencao     |<br>
+---------------------+<br>
| - id_maquina: int   |<br>
| - dataManutencao: LocalDate |<br>
| - tipoIntervencao: String |<br>
| - pecasTrocadas: String |<br>
| - tempoParada: int  |<br>
| - tecnicoResponsavel: String |<br>
| - observacoes: String|<br>
+---------------------+<br>
| + getId_maquina(): int |<br>
| + getDataManutencao(): LocalDate |<br>
| + getTipoIntervencao(): String |<br>
| + getPecasTrocadas(): String |<br>
| + getTempoParada(): int |<br>
| + getTecnicoResponsavel(): String |<br>
| + getObservacoes(): String |<br>
| + toString(): String |<br>
+---------------------+<br>
<br>

**diagrama de fluxo**
<br>
+----------------------+<br>
|  Registra  nome      |<br>
|  Registra Mtricula   |   <br>
+----------------------+<br>
<br>
+----------------------+<br>
|  Primeira Tela      |<br>
|   Equipamento       |<br>
|   Maquina           |<br>
|   Manutencao        |<br>
+----------------------+<br>
<br>

**Diagrama de uso**
<br>
+---------------------------------------+<br>
|               Usuário                 |<br>
+---------------------------------------+<br>
        |                   |            
        |                   |            
        |                   |           
        |                   |            
        v                   v           
+------------------+    +-------------------+<br>
| Adicionar Máquina |    | Adicionar Equipamento |<br>
+------------------+    +-------------------+<br>
        |                   |
        v                   v
+------------------+    +-------------------+<br>
| Listar Máquinas  |    | Listar Equipamentos |<br>
+------------------+    +-------------------+<br>
        |                   |
        v                   v
+------------------+    +-------------------+<br>
| Buscar Máquina    |    | Buscar Equipamento  |<br>
+------------------+    +-------------------+<br>
        |                   |        v                   v
+------------------+    +-------------------+<br>
| Atualizar Máquina |    | Atualizar Equipamento |<br>
+------------------+    +-------------------+<br>
        |                   |
        v                   v
+------------------+    +-------------------+<br>
| Remover Máquina   |    | Remover Equipamento  |<br>
+------------------+    +-------------------+<br>
        |                   |
        v                   v
+------------------+    +-------------------+<br>
| Adicionar Manutenção |    | Listar Manutenções |<br>
+------------------+    +-------------------+<br>
        |                   |
        v                   v
+------------------+    +-------------------+<br>
| Buscar Manutenção |    | Atualizar Manutenção |<br>
+------------------+    +-------------------+<br>
        |                   <br>
        v                  <br>
+------------------+  <br>
| Remover Manutenção|    <br>
+------------------+    <br>

# SistemaDeManutencaoPreventivaECorretiva
