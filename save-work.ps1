# Quick Save Script
# Quickly save and push your instructor work without syncing to students
# Usage: .\save-work.ps1 "Description of what you did"

param(
    [Parameter(Mandatory=$false)]
    [string]$Message = "Save work"
)

Write-Host "💾 Saving instructor work..." -ForegroundColor Cyan

# Ensure we're on instructor branch
git checkout instructor

# Save everything
git add .
git commit -m "Instructor: $Message"
git push origin instructor

Write-Host "✅ Saved to instructor branch (students don't see this)" -ForegroundColor Green
