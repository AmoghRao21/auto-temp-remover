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
```

## 🛠️ Usage

### Basic Commands

#### 1. Run The Cleaner
```bash
#Bash (Linux/MacOS/Git Bash)
./cleaner.sh

# Power Shell (Windows)
.\cleaner.ps1

# Java Version (requires JDK)
javac cleaner.java && java cleaner
```

#### 2. View Help
```bash
./cleaner.sh --help
```

## ⚙️ Configuration

### **1. Bash Script (`cleaner.sh`)**
Edit the variables at the top of the script:
```bash
# Retention period (days)
RETENTION_DAYS=7

# Directories to clean (add your custom paths)
TEMP_DIRS=(
    "$HOME/Downloads"
    "/tmp"
    "$HOME/AppData/Local/Temp"  # Windows (Git Bash)
    "/var/tmp"                  # Linux/macOS
)

# File patterns to target (add extensions as needed)
FILE_TYPES=(
    "*.tmp"
    "*.log"
    "*.temp"
    "*.cache"
    "Thumbs.db"                 # Windows thumbnail cache
)

# Logging (enable/disable)
LOG_ENABLED=true
LOG_FILE="cleaner.log"
```

## 🖥️ PowerShell Configuration (cleaner.ps1)

### *Basic Setup*
Edit these variables at the top of the script:
```powershell
# Days to keep files (default: 7)
$RetentionDays = 7

# Enable/disable logging
$LogEnabled = $true
$LogPath = "cleaner.log"

# Directories to clean (add your paths)
$TargetPaths = @(
    "$env:USERPROFILE\Downloads",
    "$env:TEMP",
    "$env:LOCALAPPDATA\Temp",
    "C:\Windows\Temp"
)

# File patterns to target
$FilePatterns = @(
    "*.tmp",
    "*.log",
    "*.bak",
    "~$*"          # Office temp files
    "Thumbs.db"    # Windows thumbnails
)
```

## ✨ Contributing

### 🛠️ How to contribute
1. **Fork The Project**
2. **Clone Your Fork**
   ```bash
   git clone https://github.com/yourusername/auto-temp-remover.git
   cd auto-temp-remover
   ```
3. **Set Upstram Remote**
   ```bash
   git remote add upstream https://github.com/AmoghRao21/auto-temp-remover.git
      git fetch upstream
   ```

### ✨ Making Changes
1. **Create a Feature Branch**
   ```bash
   git checkout -b feat/add-new-feature
   ```
   **_Branch naming conventions_**
   * feat/ for new features
   * fix/ for bug fixes
   * docs/ for documentation
   * chore/ for maintainance
2. **Develop Your Chnages** </br>
   Test your changes with:
   ```bash
   #Test Bash Version
     ./cleaner.sh --dry-run --verbose
   # Test powershell version
      powershell -ExecutionPolicy Bypass -File ./cleaner.ps1 -DryRun
3. **Commit Your Changes** </br>
   Use [Conventional Commits](https://www.conventionalcommits.org/) style:
   ```bash
   git commit -m "feat: add support for .bak files"
      git commit -m "fix: resolve memory leak in java version"
   ```
