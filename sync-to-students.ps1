# Quick Sync to Students Script
# Run this after lectures to push clean content to student branch
# Usage: .\sync-to-students.ps1 "Your commit message"

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
git checkout instructor -- .devcontainer/ .github/ chapter9/ lectures/ README.md WORKFLOW.md QUICK-REF.txt

# Remove instructor subdirectories from lectures
Write-Host "Removing instructor materials..." -ForegroundColor Yellow
Get-ChildItem -Path lectures -Recurse -Directory -Filter "instructor" | Remove-Item -Recurse -Force

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
