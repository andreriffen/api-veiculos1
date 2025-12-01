# 🚀 Automação Cyberpunk - VS Code Workspace

> *"Captain Kirk mode activated!"* ☕✨

Esta pasta contém configurações especiais para automação do workspace, criando uma experiência futurística ao abrir o projeto.

---

## 🎯 O que acontece automaticamente?

Quando você abre o projeto no VS Code, **2 terminais são criados automaticamente**:

### 🚀 Terminal 1: **API Server Runtime**
- **Cor:** Ciano/Magenta (cyberpunk theme)
- **Função:** Executa `startup.sh --no-shell`
- **Comportamento:**
  - ✅ Verifica se o projeto está compilado
  - 🔨 Compila se necessário (primeira vez)
  - 🚀 Inicia Spring Boot em background
  - 📊 Mostra informações do sistema (URLs, credenciais)
  - 📡 Mantém logs em tempo real

### 🎮 Terminal 2: **Interactive Shell**  
- **Cor:** Verde/Amarelo (matrix theme)
- **Função:** Terminal interativo para comandos manuais
- **Recursos:**
  - 📋 Cheatsheet de comandos úteis
  - 🎯 Atalhos para scripts (`populate-data.sh`, `test-api.sh`)
  - 🔧 Exemplos de curl para testar endpoints
  - 🖥️ Shell bash pronto para uso

---

## ⚙️ Como ativar a automação?

### 🔓 Primeira vez (necessário apenas uma vez):

1. **Abra a Command Palette:**
   - `Ctrl+Shift+P` (Linux/Windows)
   - `Cmd+Shift+P` (macOS)

2. **Digite:** `Tasks: Manage Automatic Tasks in Folder`

3. **Escolha:** `Allow Automatic Tasks in Folder`

4. **Feche e reabra o VS Code**

✅ **Pronto!** Na próxima vez que abrir o projeto, os terminais serão criados automaticamente.

---

## 📂 Arquivos desta pasta

```
.vscode/
├── tasks.json          # Definição das tasks automáticas
├── settings.json       # Tema cyberpunk + configurações
├── extensions.json     # Extensões recomendadas Spring/Java
└── README.md          # Este arquivo (documentação)
```

### 📝 `tasks.json`
Define as 2 tasks que rodam automaticamente:
- **🚀 API Server Runtime** → `startup.sh --no-shell`
- **🎮 Interactive Shell** → Terminal com cheatsheet

### 🎨 `settings.json`
Customizações visuais:
- Tema cyberpunk nos terminais (cores ciano/magenta/verde)
- Auto-save habilitado
- Format on save
- Exclusão de `target/` do search

### 🔌 `extensions.json`
Extensões recomendadas para Java/Spring:
- Java Extension Pack
- Spring Boot Dashboard
- Lombok Annotations Support

---

## 🎮 Comandos úteis no Interactive Shell

```bash
# Popular banco de dados
./populate-data.sh

# Testar todos os endpoints
./test-api.sh

# Consultas rápidas com curl + jq
curl -s http://localhost:8080/marcas | jq '.'
curl -s http://localhost:8080/veiculos | jq '.'

# Acessar H2 Console
# Navegador: http://localhost:8080/h2-console
```

---

## 🔧 Troubleshooting

### ❓ Os terminais não abrem automaticamente

**Solução:** Permitir automatic tasks
```
Ctrl+Shift+P → "Tasks: Manage Automatic Tasks" → Allow
```

### ❓ Porta 8080 já está em uso

O `startup.sh` já trata isso automaticamente! Mas se precisar fazer manual:
```bash
# Matar processo na porta 8080
kill -9 $(lsof -t -i:8080)
```

### ❓ Quero rodar manualmente (sem automação)

```bash
# Executar startup normal
./startup.sh

# Ou diretamente via Maven
./mvnw spring-boot:run
```

### ❓ Quero desabilitar a automação

1. **Command Palette:** `Ctrl+Shift+P`
2. **Digite:** `Tasks: Manage Automatic Tasks in Folder`  
3. **Escolha:** `Disallow Automatic Tasks in Folder`

---

## 🎨 Cores do terminal (Cyberpunk Theme)

| Cor | Hex | Uso |
|-----|-----|-----|
| 🔵 Blue | `#2196f3` | Links, headers |
| 💠 Cyan | `#59c2ff` | Títulos, destaque |
| 💚 Green | `#91b362` | Success, OK |
| 💜 Magenta | `#c792ea` | Warnings |
| 🔴 Red | `#ea6c73` | Errors |
| 🟡 Yellow | `#f99b15` | Info, alerts |

---

## 🖖 Filosofia "Capitão Kirk"

> *"Você se senta na cadeira de capitão e todos os sistemas iniciam sozinhos."*

A ideia é **zerar o atrito** entre abrir o projeto e começar a trabalhar:

- ✅ Sem `mvnw spring-boot:run` manual
- ✅ Sem abrir terminais na mão  
- ✅ Sem copiar/colar URLs do H2
- ✅ Sem esquecer de compilar
- ✅ Tudo visual, colorido, cyberpunk

**Automação + Estética = Produtividade + Diversão** 🚀✨

---

## 📚 Referências

- [VS Code Tasks Documentation](https://code.visualstudio.com/docs/editor/tasks)
- [Terminal Customization](https://code.visualstudio.com/docs/terminal/appearance)
- [Workspace Settings](https://code.visualstudio.com/docs/getstarted/settings)

---

## 📜 Licença

MIT - Use, abuse, customize! 🎉

---

**🖖 Live long and prosper!**

*2025 ©️ - Andre Riffen (@andreriffen)*
