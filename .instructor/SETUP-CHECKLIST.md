# Initial Setup Checklist

Run these commands ONCE to initialize your workflow:

## 1. Push instructor branch to GitHub
```powershell
git push -u origin instructor
```

## 2. Set up main branch for students

### Option A: If main is empty or needs reset
```powershell
git checkout main
git merge instructor
```

Then manually copy `.instructor/gitignore-for-main-branch` to `.gitignore`:
```powershell
Copy-Item .instructor/gitignore-for-main-branch .gitignore -Force
git add .gitignore
git commit -m "Setup student-facing branch with .instructor/ hidden"
git push origin main
git checkout instructor
```

### Option B: If main already has student content
```powershell
git checkout main
Copy-Item .instructor/gitignore-for-main-branch .gitignore -Force
git add .gitignore
git commit -m "Add gitignore to hide instructor materials"
git push origin main
git checkout instructor
```

## 3. Verify the setup
On GitHub, check:
- [ ] `instructor` branch exists and has `.instructor/` folder
- [ ] `main` branch exists and does NOT show `.instructor/` folder
- [ ] `.gitignore` on main branch includes `.instructor/` exclusion

## 4. Update Blackboard link
Use this URL format (replace with your details):
```
https://github.com/[your-username]/s26-csci1437-programming-fundamentals2-tr600-notebook
```

This automatically shows the `main` branch (student-safe content).

## 5. Test the workflow
```powershell
# Make a small change on instructor branch
git checkout instructor
echo "Test" > test.txt
git add test.txt
git commit -m "Test sync"

# Sync to students
.\sync-to-students.ps1 "Testing workflow"

# Check GitHub - students should see test.txt on main branch
```

## 6. Clean up
```powershell
git checkout instructor
Remove-Item test.txt
git add test.txt
git commit -m "Remove test file"
git push origin instructor
```

---

## ✅ You're Done!

From now on, just use:
- `.\save-work.ps1 "message"` after lectures
- `.\sync-to-students.ps1 "message"` when ready to share

Everything auto-syncs to cloud! 🎉
