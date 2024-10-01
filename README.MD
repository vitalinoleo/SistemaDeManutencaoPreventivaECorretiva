# Sistema de Controle de Estoque e Suprimentos Industriais 

## Descrição:
O Sistema de Manutenção Preventiva e Corretiva é uma solução projetada para gerenciar o ciclo de manutenção de máquinas e equipamentos industriais. O sistema visa controlar as manutenções preventivas programadas, registrar ocorrências de falhas e gerenciar a alocação de técnicos para intervenções corretivas, além de gerar relatórios detalhados sobre o histórico de manutenção e desempenho dos equipamentos.

## Escopo do Sistema:

### Cadastro de Máquinas, Equipamentos e Histórico de Manutenção:
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

## Manutenção Preventiva Programada:
**Criação de Planos de Manutenção Preventiva:** O sistema deve permitir a criação de planos de manutenção preventiva com base em cronogramas pré-definidos ou medições de uso (como horas de operação ou ciclos de produção):
- Definição de frequência (diária, semanal, mensal, trimestral, etc.).
- Tarefas a serem realizadas em cada inspeção ou intervenção.
- Alocação de técnicos responsáveis.
- Notificações automáticas para o agendamento de manutenções preventivas futuras.

**Automatização de Alertas e Ordens de Serviço:** O sistema deve enviar notificações automáticas aos responsáveis quando uma manutenção preventiva estiver se aproximando, gerando ordens de serviço automaticamente:
- Notificações para técnicos e supervisores.
- Registro de status de cada ordem de serviço (pendente, em andamento, concluída).
- Relatório de conformidade com o cronograma de manutenção preventiva.

## Geração de Relatórios de Histórico de Manutenção:
**Relatórios de Manutenção Corretiva e Preventiva:** O sistema deve ser capaz de gerar relatórios detalhados de todas as manutenções realizadas:
- Frequência de manutenções preventivas versus corretivas.
- Comparação entre o tempo planejado e o tempo real das manutenções.
- Custo de manutenção (peças e mão de obra).
- Análise de falhas recorrentes em máquinas específicas.

**Relatórios de Desempenho de Técnicos:** Avaliação do desempenho de cada técnico ou equipe de manutenção:
- Tempo de resposta para manutenções corretivas.
- Qualidade do serviço (com base no número de reincidências de falhas).
- Carga de trabalho e número de intervenções realizadas.

## Interface Gráfica para Acompanhamento do Status de Manutenção e Alocação de Técnicos:
**Painel de Controle em Tempo Real:** A interface gráfica deve permitir o acompanhamento em tempo real do status de todas as manutenções (preventivas e corretivas) e do desempenho das máquinas. Funcionalidades incluem:
- Visualização de quais máquinas estão em operação, em manutenção ou paradas.
- Status das ordens de serviço (pendentes, em execução, concluídas).
- Indicadores de disponibilidade e produtividade das máquinas.

**Alocação de Técnicos e Recursos:** A interface também deve permitir a alocação manual ou automática de técnicos para as intervenções, com base em:
- Agenda de cada técnico.
- Especialização do técnico para cada tipo de máquina ou problema.

# SistemaDeManutencaoPreventivaECorretiva
