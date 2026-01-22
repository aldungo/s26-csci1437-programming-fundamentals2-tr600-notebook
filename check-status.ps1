# Quick Status Check
# Shows what branch you're on and if you have uncommitted work
# Usage: .\check-status.ps1

Write-Host "`n📊 REPOSITORY STATUS`n" -ForegroundColor Cyan

# Current branch
$branch = git rev-parse --abbrev-ref HEAD
Write-Host "📍 Current branch: " -NoNewline
if ($branch -eq "instructor") {
    Write-Host "$branch" -ForegroundColor Green
    Write-Host "   ✅ This is your workspace - safe to work here!" -ForegroundColor Gray
} else {
    Write-Host "$branch" -ForegroundColor Yellow
    Write-Host "   ⚠️  You should be on 'instructor' branch!" -ForegroundColor Yellow
    Write-Host "   Run: git checkout instructor" -ForegroundColor Gray
}

# Check for uncommitted changes
Write-Host "`n📝 Uncommitted changes:" -ForegroundColor Cyan
$status = git status --short
if ($status) {
    git status --short
    Write-Host "`n💡 Tip: Run .\save-work.ps1 'your message' to save these" -ForegroundColor Gray
} else {
    Write-Host "   ✅ All clean - no uncommitted changes" -ForegroundColor Green
}

# Last commit
Write-Host "`n📌 Last commit:" -ForegroundColor Cyan
git log -1 --oneline

# Remote status
Write-Host "`n☁️  Cloud sync status:" -ForegroundColor Cyan
git fetch origin --quiet
$local = git rev-parse @
$remote = git rev-parse "@{u}"

if ($local -eq $remote) {
    Write-Host "   ✅ Up to date with GitHub" -ForegroundColor Green
} else {
    Write-Host "   ⚠️  You have unpushed commits" -ForegroundColor Yellow
    Write-Host "   Run: git push origin $branch" -ForegroundColor Gray
}

Write-Host ""
