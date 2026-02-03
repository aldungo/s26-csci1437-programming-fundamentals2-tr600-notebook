# Quick Sync to Students Script
# Run this after lectures to push clean content to student branch
# Usage: .\sync-to-students.ps1 "Your commit message"

param(
    [Parameter(Mandatory=$true)]
    [string]$CommitMessage
)

Write-Host "🎓 Syncing content to students..." -ForegroundColor Cyan

# Save current work on instructor branch
Write-Host "`n📝 Saving instructor branch work..." -ForegroundColor Yellow
git add .
git commit -m "Instructor prep: $CommitMessage"
git push origin instructor

# Switch to student branch
Write-Host "`n🔄 Switching to student-facing branch..." -ForegroundColor Yellow
git checkout student

# Cherry-pick only student-safe files from instructor
Write-Host "`n🔀 Updating student-safe content..." -ForegroundColor Yellow
git checkout instructor -- .devcontainer/ .github/ chapter9/ lectures/ README.md WORKFLOW.md QUICK-REF.txt
git add .
git commit -m "Update: $CommitMessage" --allow-empty

# Push to students
Write-Host "`n🚀 Pushing to student branch (students will see this)..." -ForegroundColor Green
git push origin student

# Return to instructor branch
Write-Host "`n↩️  Returning to instructor branch..." -ForegroundColor Yellow
git checkout instructor

Write-Host ""
Write-Host "Done! Students can now see: $CommitMessage" -ForegroundColor Green
