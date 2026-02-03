# 🎓 Blackboard Setup - Complete Guide

## What You Now Have

Your repository is set up for **GitHub Codespaces** - students can run code in the cloud without installing anything!

---

## 📋 Step-by-Step: Adding to Blackboard

### 1. Create a Content Item in Blackboard

**Location:** Content → Week 1 (or create "Course Resources" folder)

**Title:** 📦 Live Code Repository (Updated Weekly)

**Description:** Use the text from `.instructor/BLACKBOARD-INSTRUCTIONS.md`

---

### 2. Add the Repository Link

**Primary Link (View Code):**
```
https://github.com/aldungo/s26-csci1437-programming-fundamentals2-tr600-notebook
```

**Codespaces Link (Run Code):**
```
https://codespaces.new/aldungo/s26-csci1437-programming-fundamentals2-tr600-notebook?quickstart=1
```

**Recommended Format:**
Create a button or prominent link that says:
> 🚀 **Open Cloud Workspace** (Recommended)

And a secondary link:
> 📖 **View Code Online** (Browse Only)

---

### 3. Important Student Instructions

Copy this into Blackboard:

```
## How to Use the Course Repository

This is NOT an assignment - it's a constantly-updated resource!

✅ What to do:
- Click "Open Cloud Workspace" to run examples
- Create ONE workspace and reuse it all semester
- Pull updates after each class (git pull origin main)
- Experiment and learn!

❌ What NOT to do:
- Don't create multiple workspaces (wastes free hours)
- Don't copy code for assignments (reference only!)
- Don't submit anything here (use Blackboard for assignments)

Your workspace is 100% private - only you can see your work!
```

---

## 🔐 Privacy & Security

### What Students CAN See:
✅ All code in `lectures/` folders  
✅ Jupyter notebooks (Chapter9.ipynb, Chapter10.ipynb)  
✅ Working examples with clear instructions  
✅ README files and study guides  

### What Students CANNOT See:
❌ `.instructor/` folder (gitignored on main branch)  
❌ Your prep work and solutions  
❌ Files with `-KEY`, `-TEACHER`, `-SOLUTION` in name  
❌ Each other's Codespace work (completely private!)  

---

## 🎮 How Codespaces Work for Students

### The Model:
Think of it like a **read-only textbook with a scratch paper**

- **Main Repository** = The textbook (everyone sees the same content)
- **Student's Codespace** = Their personal scratch paper (private workspace)
- Students can write notes, run code, experiment
- Their changes DON'T go back to the main repo
- Each student's work is isolated and private

### The Workflow:
1. Student clicks Codespaces link
2. GitHub creates a **private copy** of your repo in the cloud
3. Student can edit, run, break code - all private!
4. When they `git pull`, they get YOUR latest updates
5. Their local changes stay separate

---

## 📊 Monitoring (Optional)

### What You CAN See:
- Repository traffic (Settings → Insights → Traffic)
- Number of clones/views
- Which files are popular

### What You CANNOT See:
- Student Codespace contents (100% private to them)
- What code they're running
- Their experimental changes

This is PERFECT - they have a safe sandbox to learn!

---

## 🔄 Your Weekly Update Workflow

### After Monday's Lecture:
```powershell
# On instructor branch
.\save-work.ps1 "Monday Week 4 - Inheritance intro"
```

### After Wednesday's Lecture:
```powershell
.\save-work.ps1 "Wednesday Week 4 - Inheritance continued"
```

### When Ready to Push to Students:
```powershell
.\sync-to-students.ps1 "Week 4 Complete - Inheritance & Polymorphism"
```

Students will then:
1. Open their existing Codespace
2. Run `git pull origin main` in terminal
3. Get your new content!

---

## 💡 Best Practices

### DO Include:
✅ **Working examples** - Like the Loan calculator  
✅ **Clear instructions** - "To run: javac Loan.java, java TestLoan"  
✅ **Lecture demos** - What you showed in class  
✅ **Study guides** - Exam prep without answers  
✅ **Practice starters** - Templates they can build on  

### DON'T Include:
❌ **Assignment solutions** - Keep in `.instructor/solutions/`  
❌ **Answer keys** - Files ending in `-KEY.java`  
❌ **Exam answers** - Study guide questions only  
❌ **Half-finished code** - Students might think it's complete  

---

## 🎯 Example: The Loan Calculator

**Perfect for students because:**
- ✅ Complete, working code
- ✅ Clear comments explaining each part
- ✅ Shows real-world application
- ✅ They can modify values and see results
- ✅ Demonstrates best practices

**To add similar examples:**
1. Create in `.instructor/prep/` first
2. Test thoroughly
3. Add helpful comments
4. Move to appropriate `lectures/student/` folder
5. Commit and sync to students

---

## 📱 Student Communication Template

**Email/Announcement:**
```
Subject: 📦 New Resource: Live Code Repository

Hi class!

I've set up a cloud-based code repository where you can:
- Access all lecture examples
- Run Java programs in your browser (no install needed!)
- Practice with working code
- Get updates after every class

🔗 Link in Blackboard under "Course Resources"

Watch the quick tutorial video for setup instructions.
This is NOT graded - just a helpful learning tool!

Questions? Ask in class or office hours.
```

---

## ⚙️ Codespaces Settings (Already Configured!)

The `.devcontainer/devcontainer.json` file sets up:
- ✅ Java 21 pre-installed
- ✅ Maven build tool
- ✅ VS Code Java extensions
- ✅ Proper formatting/syntax highlighting
- ✅ Welcome message with quick start command

Students get a ready-to-go environment in 30 seconds!

---

## 🆘 Common Student Issues & Solutions

### "I can't find the Codespaces button"
→ Make sure they're signed into GitHub
→ Look for green "Code" button, then "Codespaces" tab

### "I ran out of free hours"
→ They created too many Codespaces (delete old ones)
→ Didn't stop Codespace when done
→ Can switch to local clone if needed

### "I broke something and can't fix it"
→ `git checkout main` then `git pull origin main`
→ Or delete Codespace and create fresh one

### "The code won't compile"
→ Check they're in the right directory (`pwd`)
→ Verify Java file names match class names (case-sensitive!)
→ Make sure they compiled before running (`javac` first)

---

## 🎬 Next Steps

1. ✅ Add repository link to Blackboard (use template above)
2. ✅ Post announcement about the new resource
3. ✅ Show quick demo in next class (1-2 minutes)
4. ✅ Continue your normal workflow:
   - Prep in `.instructor/`
   - Demo in class
   - `.\sync-to-students.ps1` when ready
5. ✅ Monitor usage (GitHub Insights) to see what's popular

---

**That's it! Students now have an evergreen, cloud-based resource that stays in sync with your teaching.** 🎉

---

*Created: February 3, 2026*
