# FutebolAPI

API para gerenciamento e consulta de informações sobre clubes de futebol, incluindo títulos conquistados e dados de jogadores, desenvolvida como atividade da disciplina C14.



## Deployment

```bash
git clone https://github.com/otavioOJ/Futebol-API.git
```

```bash
mvn clean install
```

```bash
mvn exec:java -Dexec.mainClass="br.inatel.cdg"
```

## Regressão detectada pela suíte de testes

**Resumo:** este repositório possui testes que impedem regressões em regras de domínio.
No PR #<número> (branch `regression/demo-altura`) removemos propositalmente a validação
de altura/peso negativos em `Jogador` para demonstrar a proteção da suíte.

**Causa raiz:**
A validação removida permitia criar `Jogador` com altura/peso < 0, violando a regra de negócio.

**Correção:**
Reintroduzida validação no construtor de `Jogador`:
```java
if (altura < 0) throw new IllegalArgumentException("Altura não pode ser negativa");
if (peso < 0) throw new IllegalArgumentException("Peso não pode ser negativo");
