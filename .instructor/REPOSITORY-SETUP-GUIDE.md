# Repository Structure & GitHub Workflow Guide
## For Instructor/Student Teaching Repositories

**Created:** February 2026  
**Purpose:** Document the setup for Programming Fundamentals 2 so it can be replicated for other courses

---

## 🎯 Design Goals

1. **One Repository, Two Views:**
   - Instructors see everything (prep materials, solutions, notes)
   - Students see only curated, safe content
   
2. **No Commit History Leaks:**
   - Students can't browse commits to see instructor materials
   - Clean separation prevents accidental exposure

3. **Simple Daily Workflow:**
   - Work locally on instructor branch
   - One command syncs to students
   - No manual filtering needed

4. **GitHub Codespaces Compatible:**
   - Students get instant cloud development environment
   - No local setup required
   - Same link on Blackboard all semester

---

## 📁 Repository Structure

### Branch Strategy (3 Branches)

#### 1. `instructor` (Local Only - Never Pushed)
Your working branch with ALL materials:
```
.instructor/
  ├── lectures/
  │   ├── lecture_02_jan22_chapter9/
  │   │   ├── Circle.java (solution)
  │   │   ├── CircleDemo.java (solution)
  │   │   └── TEACHING_NOTES.md
  │   └── lecture_XX_*/
  ├── prep/
  │   ├── Chapter10Part2-TeachingExamples.java
  │   └── TEST-DEMO.md
  ├── notebooks/
  │   ├── Chapter9.ipynb
  │   └── Chapter10.ipynb
  ├── solutions/
  ├── exams/
  ├── answer-keys/
  ├── plans/
  └── transcripts/

chapter9/
  ├── Circle.java (student version)
  ├── Chapter9_pt1.java
  └── README.md

chapter10/
  ├── Loan.java
  ├── BMI.java
  ├── Course.java
  ├── GenericStack.java
  └── README.md

lectures/
  ├── lecture_02_jan22_chapter9/
  │   ├── student/
  │   │   ├── Circle.java (starter)
  │   │   └── CircleDemo.java (starter)
  │   └── README.md
  └── lecture_XX_*/

.devcontainer/
  └── devcontainer.json (Codespaces config)

README.md (student-facing)
WORKFLOW.md
check-status.ps1
save-work.ps1
sync-to-students.ps1
```

**Key Points:**
- `.instructor/` = ALL private materials (never synced)
- `lectures/` = ONLY student-facing content
- `chapterX/` = Complete runnable examples
- Scripts stay local for instructor use only

#### 2. `student` (On GitHub - Default Branch)
Clean, student-facing content:
```
.devcontainer/
.github/
chapter9/
chapter10/
lectures/
  ├── lecture_02_jan22_chapter9/
  │   ├── student/  (starter code)
  │   └── README.md
  └── lecture_XX_*/
README.md
WORKFLOW.md
QUICK-REF.txt
```

**Key Points:**
- NO `.instructor/` folder
- NO instructor subdirectories
- NO commit history before Day 1 (orphan branch)
- Students cannot switch to other branches (only `student` exists on GitHub)

#### 3. `main` (Local Only - Optional)
Not actively used, but kept locally for backup/staging if needed.

---

## 🔐 Privacy Model

### What's on GitHub (Students See):
- ✅ Only `student` branch
- ✅ Clean code examples
- ✅ Starter files for lectures
- ✅ READMEs with instructions

### What's Local Only (You See):
- ✅ `instructor` branch (never pushed)
- ✅ `.instructor/` folder with all prep
- ✅ `main` branch (optional backup)
- ✅ Full commit history

### How It Works:
1. **`instructor` branch never pushed to GitHub**
   - All your work stays local
   - Students can't access it even if they know Git

2. **`student` branch is orphan (no history)**
   - Started fresh with single commit
   - No history of `.instructor/` folder
   - Can't browse commits to find secrets

3. **Sync script cherry-picks content**
   - Copies only specific folders
   - Excludes `.instructor/` automatically
   - Creates new commit on `student` branch

---

## 🚀 Daily Workflow

### Morning/Before Class:
```powershell
# You're always on instructor branch
cd d:\path\to\repository

# Make sure you're on instructor
git status

# Create prep materials
code .instructor/prep/TodayNotes.md

# Create lecture materials
mkdir lectures/lecture_05_feb3_chapter11
mkdir lectures/lecture_05_feb3_chapter11/student
code lectures/lecture_05_feb3_chapter11/student/Example.java
code .instructor/lectures/lecture_05_feb3_chapter11/Solution.java
```

### During Class:
- Work in Jupyter notebooks (`.instructor/notebooks/`)
- Demonstrate code live
- Take notes for yourself

### After Class (Sync to Students):
```powershell
# One command syncs everything
powershell -ExecutionPolicy Bypass -File .\sync-to-students.ps1 -CommitMessage "Added Chapter 11 examples"
```

**What Happens:**
1. Saves your work on `instructor` branch (local)
2. Switches to `student` branch
3. Copies only student-safe folders
4. Pushes to GitHub
5. Returns you to `instructor` branch

**Students See:**
- New files in `lectures/lecture_05_*/student/`
- New examples in `chapter11/`
- Updated README

**Students Don't See:**
- `.instructor/` folder
- Your prep notes
- Solutions in `.instructor/lectures/`

---

## 📜 Scripts Reference

### `sync-to-students.ps1`
**Purpose:** One-command sync to students  
**Usage:**
```powershell
powershell -ExecutionPolicy Bypass -File .\sync-to-students.ps1 -CommitMessage "Your message"
```

**What it does:**
```powershell
1. git add . && git commit (on instructor branch)
2. git checkout student
3. git checkout instructor -- .devcontainer/ .github/ chapter9/ chapter10/ lectures/ README.md WORKFLOW.md QUICK-REF.txt
4. git add . && git commit
5. git push origin student
6. git checkout instructor
```

**Automatically excludes:**
- `.instructor/` folder
- instructor scripts (*.ps1)
- Any files not explicitly listed

### `save-work.ps1`
**Purpose:** Quick save local work  
**Usage:**
```powershell
.\save-work.ps1 "Quick save before lunch"
```

**What it does:**
```powershell
git add .
git commit -m "Instructor prep: [message]"
```

### `check-status.ps1`
**Purpose:** See what's changed  
**Usage:**
```powershell
.\check-status.ps1
```

---

## 🛠️ Setup Instructions (For New Repository)

### Step 1: Create Repository on GitHub
```bash
# Create new repository on GitHub
# Example: s25-csci1436-programming-fundamentals1-tr600

# Clone locally
git clone https://github.com/yourusername/repo-name.git
cd repo-name
```

### Step 2: Create Initial Structure
```bash
# Create instructor branch
git checkout -b instructor

# Create folder structure
mkdir .instructor
mkdir .instructor/lectures
mkdir .instructor/prep
mkdir .instructor/notebooks
mkdir .instructor/solutions
mkdir .instructor/exams
mkdir .instructor/answer-keys
mkdir .instructor/plans
mkdir .instructor/transcripts

mkdir chapter1
mkdir lectures
mkdir .devcontainer
mkdir .github
```

### Step 3: Add Essential Files

#### `.gitignore` (for instructor branch):
```gitignore
# Compiled files
*.class

# Build artifacts
target/
build/

# IDE files
.vscode/
.idea/
*.iml
.DS_Store

# Jupyter checkpoints
.ipynb_checkpoints/
*/.ipynb_checkpoints/*

# Temporary files
*.tmp
*.swp
*~

# Note: .instructor/ is NOT in .gitignore on instructor branch
# It WILL be in .gitignore on student branch
```

#### `README.md` (student-facing):
```markdown
# CSCI 1436 - Programming Fundamentals 1

[![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://codespaces.new/yourusername/repo-name?quickstart=1)

## Quick Start

1. Click the badge above to open in Codespaces
2. Wait for environment to load (~30 seconds)
3. Start coding!

## Repository Structure

- `chapter1/`, `chapter2/`, etc. - Complete code examples
- `lectures/` - Lecture materials and starter code
- `README.md` - This file

## How to Run Java Code

```bash
# Compile
javac FileName.java

# Run
java FileName
```

## Getting Updates

Your Codespace automatically pulls latest changes. If you need to update manually:

```bash
git pull origin student
```

## Questions?

Ask in class or during office hours!
```

#### `.devcontainer/devcontainer.json`:
```json
{
  "name": "Java Dev Environment",
  "image": "mcr.microsoft.com/devcontainers/java:21",
  "features": {
    "ghcr.io/devcontainers/features/java:1": {
      "version": "21",
      "installMaven": "true"
    }
  },
  "customizations": {
    "vscode": {
      "extensions": [
        "vscjava.vscode-java-pack",
        "vscjava.vscode-java-debug",
        "vscjava.vscode-maven"
      ]
    }
  },
  "postCreateCommand": "echo 'Welcome to CSCI 1436! Try: javac chapter1/HelloWorld.java && java HelloWorld'",
  "forwardPorts": []
}
```

### Step 4: Create PowerShell Scripts

#### `sync-to-students.ps1`:
```powershell
# Quick Sync to Students Script
# Usage: powershell -ExecutionPolicy Bypass -File .\sync-to-students.ps1 -CommitMessage "Your message"

param(
    [Parameter(Mandatory=$true)]
    [string]$CommitMessage
)

Write-Host "Syncing content to students..." -ForegroundColor Cyan

# Save current work on instructor branch
Write-Host ""
Write-Host "Saving instructor branch work..." -ForegroundColor Yellow
git add .
git commit -m "Instructor prep: $CommitMessage"

# Switch to student branch
Write-Host ""
Write-Host "Switching to student-facing branch..." -ForegroundColor Yellow
git checkout student

# Cherry-pick only student-safe files from instructor
Write-Host ""
Write-Host "Updating student-safe content..." -ForegroundColor Yellow
git checkout instructor -- .devcontainer/ .github/ chapter1/ chapter2/ chapter3/ lectures/ README.md WORKFLOW.md QUICK-REF.txt

git add .
git commit -m "Update: $CommitMessage" --allow-empty

# Push to students
Write-Host ""
Write-Host "Pushing to student branch (students will see this)..." -ForegroundColor Green
git push origin student

# Return to instructor branch
Write-Host ""
Write-Host "Returning to instructor branch..." -ForegroundColor Yellow
git checkout instructor

Write-Host ""
Write-Host "DONE! Students can now see: $CommitMessage" -ForegroundColor Green
Write-Host ""
```

#### `save-work.ps1`:
```powershell
# Quick Save Script
param(
    [Parameter(Mandatory=$true)]
    [string]$Message
)

git add .
git commit -m "Instructor prep: $Message"
Write-Host "Saved: $Message" -ForegroundColor Green
```

#### `check-status.ps1`:
```powershell
Write-Host "Repository Status:" -ForegroundColor Cyan
Write-Host ""
git status
Write-Host ""
Write-Host "Recent commits:" -ForegroundColor Cyan
git log --oneline -5
```

### Step 5: Create Student Branch (Orphan - No History)
```bash
# Commit everything on instructor branch first
git add -f .instructor/  # Force add instructor folder
git commit -m "Initial instructor setup"

# Create orphan student branch (no history)
git checkout --orphan student

# Reset staging
git reset

# Add only student-safe files
git add .devcontainer/ .github/ chapter1/ lectures/ README.md WORKFLOW.md QUICK-REF.txt .gitignore

# Update .gitignore to hide .instructor on student branch
echo "" >> .gitignore
echo "# Instructor-only folder (hidden from students)" >> .gitignore
echo ".instructor/" >> .gitignore

git add .gitignore

# Create first commit
git commit -m "Initial student repository - Fall 2025 CSCI 1436"

# Push student branch
git push origin student

# Return to instructor
git checkout instructor
```

### Step 6: Set GitHub Default Branch
1. Go to: `https://github.com/yourusername/repo-name/settings/branches`
2. Change default branch from `main` to `student`
3. Confirm the change

### Step 7: Delete Remote Branches (Keep Private)
```bash
# Delete main and instructor from GitHub (keep only student)
git push origin --delete main
git push origin --delete instructor

# Verify only student branch exists on GitHub
git branch -r
# Should show: origin/student only
```

### Step 8: Test the Workflow
```bash
# Create test content
mkdir chapter1
echo "public class HelloWorld { public static void main(String[] args) { System.out.println(\"Hello\"); } }" > chapter1/HelloWorld.java
mkdir .instructor/prep
echo "# Test prep notes" > .instructor/prep/test.md

# Sync to students
powershell -ExecutionPolicy Bypass -File .\sync-to-students.ps1 -CommitMessage "Test sync"

# Check student view
git checkout student
ls  # Should NOT see .instructor/
ls chapter1/  # Should see HelloWorld.java
git checkout instructor
```

---

## 📋 Checklist for New Repository

- [ ] Repository created on GitHub
- [ ] Cloned locally
- [ ] `instructor` branch created and checked out
- [ ] Folder structure created (`.instructor/`, `chapter1/`, `lectures/`, etc.)
- [ ] `.gitignore` created (NOT hiding `.instructor/` on instructor branch)
- [ ] `README.md` created (student-facing with Codespaces badge)
- [ ] `.devcontainer/devcontainer.json` created
- [ ] PowerShell scripts created (`sync-to-students.ps1`, `save-work.ps1`, `check-status.ps1`)
- [ ] Initial content added and committed to `instructor` branch
- [ ] Orphan `student` branch created with clean history
- [ ] `.gitignore` updated on `student` branch to hide `.instructor/`
- [ ] `student` branch pushed to GitHub
- [ ] Default branch changed to `student` on GitHub
- [ ] `main` and `instructor` branches deleted from GitHub
- [ ] Test sync performed successfully
- [ ] Viewed repository from student account to verify privacy

---

## 🎓 Blackboard Setup

### Link Format:
```
https://github.com/yourusername/repo-name
```

### Instructions for Students:
```
Access Course Repository:

1. Click the link: [Course Repository](https://github.com/yourusername/repo-name)

2. Click the green "Code" button, then "Open with Codespaces"
   OR click the Codespaces badge at the top of the README

3. Create ONE Codespace and reuse it all semester (60 free hours/month)

4. Your work in Codespaces is NOT submitted automatically
   - Download files if you want to keep them
   - This is for practice and following along in class

5. To get updates: The Codespace auto-updates, or run: git pull origin student
```

---

## 🔄 Common Operations

### Adding New Chapter Materials:
```bash
# On instructor branch
mkdir chapter5
code chapter5/Example.java
code chapter5/README.md

# Update sync script to include chapter5
code sync-to-students.ps1
# Add chapter5/ to the list of folders to sync

# Sync to students
powershell -ExecutionPolicy Bypass -File .\sync-to-students.ps1 -CommitMessage "Added Chapter 5 examples"
```

### Extracting Notebook Code to Student Files:
```bash
# Keep notebooks in .instructor/notebooks/
# Extract large code examples to chapterX/ folders

# Example:
# From .instructor/notebooks/Chapter5.ipynb
# Extract Loan class → chapter5/Loan.java

# Then sync normally - students get .java files, you keep notebooks
```

### Weekly Lecture Pattern:
```bash
# Create new lecture folder
mkdir lectures/lecture_06_feb10_chapter5
mkdir lectures/lecture_06_feb10_chapter5/student
mkdir .instructor/lectures/lecture_06_feb10_chapter5

# Student starter code
code lectures/lecture_06_feb10_chapter5/student/StarterCode.java

# Instructor solution
code .instructor/lectures/lecture_06_feb10_chapter5/Solution.java

# Lecture README
code lectures/lecture_06_feb10_chapter5/README.md

# Sync to students
powershell -ExecutionPolicy Bypass -File .\sync-to-students.ps1 -CommitMessage "Lecture 6 materials"
```

---

## ⚠️ Important Rules

### Never Do:
❌ `git push origin instructor` - Keeps instructor branch local  
❌ `git push origin main` - Main should also stay local  
❌ Put solutions in `lectures/` folder - Use `.instructor/lectures/` instead  
❌ Commit without checking which branch - Always verify with `git branch`

### Always Do:
✅ Work on `instructor` branch  
✅ Use sync script to push to students  
✅ Keep `.instructor/` for all private materials  
✅ Test by checking out `student` branch occasionally  
✅ Verify GitHub only shows `student` branch

---

## 🐛 Troubleshooting

### "Students can see .instructor/ folder"
```bash
# Check which branch you're on
git branch

# If on student branch, check .gitignore
cat .gitignore | grep instructor

# Should show: .instructor/

# If not, add it:
git checkout student
echo ".instructor/" >> .gitignore
git add .gitignore
git commit -m "Hide instructor folder"
git push origin student
git checkout instructor
```

### "Sync script not working"
```bash
# Run with verbose error messages
powershell -ExecutionPolicy Bypass -File .\sync-to-students.ps1 -CommitMessage "Test" -Verbose

# Check you're on instructor branch
git branch
# Should show: * instructor

# Check student branch exists
git branch -a
# Should show: student and remotes/origin/student
```

### "Students see old commit history"
```bash
# Student branch should be orphan (no history)
git checkout student
git log --oneline
# Should show only commits since Day 1

# If you see old commits revealing secrets, recreate student branch:
git checkout instructor
git branch -D student
git checkout --orphan student
# ... follow Step 5 again
```

---

## 📊 Repository Comparison

| Feature | Instructor Branch (Local) | Student Branch (GitHub) |
|---------|--------------------------|-------------------------|
| Visibility | Only you | Public (or students) |
| History | Full commit history | Clean (from Day 1) |
| .instructor/ | ✅ Tracked | ❌ Gitignored |
| instructor/scripts | ✅ Has scripts | ❌ No scripts |
| Solutions | ✅ In .instructor/lectures/ | ❌ Not synced |
| Examples | ✅ All examples | ✅ Only released |
| Notebooks | ✅ In .instructor/notebooks/ | ❌ Not synced |

---

## 🎉 Benefits of This Setup

1. **Security**: Students cannot access instructor materials even if they know Git
2. **Simplicity**: One command syncs to students
3. **Flexibility**: Work however you want locally
4. **Codespaces**: Students get instant dev environment
5. **Organization**: Clear separation of prep vs. student content
6. **Scalability**: Easy to replicate for multiple courses
7. **No Accidents**: Can't accidentally push secrets (instructor branch never pushed)

---

## 📝 Notes

- This setup assumes PowerShell on Windows. For Mac/Linux, convert scripts to bash
- Codespaces gives 60 free hours/month per user (sufficient for coursework)
- Students can't "turn in" work via Codespaces (it's not a fork, just a workspace)
- Same repository link works all semester (just keep pushing to `student` branch)
- `.instructor/` folder works like a vault - everything inside stays private

---

**Need help?** Refer to this document when setting up Programming Fundamentals 1 repository!
