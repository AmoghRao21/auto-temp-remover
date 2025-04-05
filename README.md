# AUTOTEMPREM 🔥

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
![Platforms](https://img.shields.io/badge/Platform-Windows%20%7C%20Linux%20%7C%20macOS-lightgrey)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](CONTRIBUTING.md)

A cross-platform automated temporary file cleaner that keeps your system lean and clean.

## Table of Contents
- [Features](#-features)
- [Installation](#-installation)
- [Usage](#-usage)
- [Configuration](#-configuration)
- [File Structure](#-file-structure)
- [Contributing](#-contributing)
- [License](#-license)

## ✨ Features
- 🧹 **Multi-platform cleanup** (Windows, Linux, macOS)
- ⏳ **Age-based deletion** (Default: 7+ days old)
- 📝 **Detailed logging** with timestamps
- 🔒 **Auto-admin elevation** (Windows)
- 🛡️ **Safe mode** (Skips locked files)
- 📊 **Customizable** (Paths, file types, retention)

## 🚀 Installation
### Prerequisites
- **Bash** (Linux/macOS/Git Bash)
- **PowerShell 5.1+** (Windows)
- **Java 11+** (Optional Java version)

### Quick Start
```bash
git clone https://github.com/yourusername/AUTOTEMPREM.git
cd AUTOTEMPREM
chmod +x cleaner.sh  # Linux/macOS