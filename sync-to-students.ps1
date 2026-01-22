# Quick Sync to Students Script
# Run this after lectures to push clean content to main branch
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

# Switch to main branch
Write-Host "`n🔄 Switching to student-facing main branch..." -ForegroundColor Yellow
git checkout main

# Merge instructor content (gitignore will filter out private stuff)
Write-Host "`n🔀 Merging student-safe content..." -ForegroundColor Yellow
git merge instructor --no-edit -m "Student update: $CommitMessage"

# Push to students
Write-Host "`n🚀 Pushing to main (students will see this)..." -ForegroundColor Green
git push origin main

# Return to instructor branch
Write-Host "`n↩️  Returning to instructor branch..." -ForegroundColor Yellow
git checkout instructor

Write-Host "`n✅ Done! Students can now see: $CommitMessage" -ForegroundColor Green
Write-Host "   View at: https://github.com/[your-repo-url]" -ForegroundColor Gray
