# 🎯 Quick Reference: Web vs Local Images (For Live Demo)

## During Class Demo - Two Approaches

### **APPROACH 1: Web Image (Current Default)**
✅ Works immediately - no setup  
✅ Students see it working right away  
✅ No file not found errors  

```java
Image image = new Image("https://openjfx.io/images/logo.png");
```

**Say to students:**
> "Right now I'm loading this image from the internet. The advantage is it works on any computer with internet. The disadvantage is you need internet connection!"

---

### **APPROACH 2: Local File (Switch During Demo)**

**Live Demo Steps:**

1. **Show them you're downloading an image:**
   - Right-click any image online → "Save image as..."
   - Save to examples folder as `demo-image.png`
   - Show them the file in File Explorer

2. **Update the code together:**
   ```java
   // Comment out web version
   // Image image = new Image("https://openjfx.io/images/logo.png");
   
   // Uncomment local version
   Image image = new Image("file:demo-image.png");
   ```

3. **Recompile and run:**
   ```powershell
   javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls -d . ImageDemoBasic.java
   java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "YOUR_ABS_PATH" com.example.javafx.ImageDemoBasic
   ```

4. **Point out:**
   - ✅ Now works offline
   - ✅ Can use any image they want
   - ⚠️ File must be in correct folder
   - ⚠️ Filename must match exactly (case sensitive!)

**Say to students:**
> "For your projects, you'll probably want local images. Just put them in your project folder and use the `file:` prefix like I just showed you."

---

## Common Student Mistakes (Be Ready!)

| Mistake | What Happens | Fix |
|---------|--------------|-----|
| Forgot `file:` prefix | Blank window or error | Add `file:` before filename |
| Wrong folder | `FileNotFoundException` | Move image to same folder as .java |
| Typo in filename | Blank window | Check spelling EXACTLY |
| Used backslashes `\` | Error on Mac/Linux | Use forward slashes `/` |
| Spaces in filename | Path breaks | Rename file without spaces |

---

## Demo Script (Optional)

**Transition dialogue:**

> "Alright, so we've seen web images working. Now let me show you how to use your own images stored on your computer, because that's what you'll do for projects."

> *[Download image live, save as demo-image.png, show in folder]*

> "Notice I saved it right here in the same folder as my Java file. Now I just need to change one line..."

> *[Comment web line, uncomment local line]*

> "See how I added `file:` before the filename? That tells JavaFX 'look on the local filesystem, not the web.'"

> *[Run it]*

> "And there we go! Same result, but now it's loading from my computer. For your semester projects, this is how you'll add logos, avatars, product images, whatever you need."

---

## All 4 Demo Files Have This

Every ImageDemo file now has comments showing:
- ✅ Option A: Web image (default, works now)
- ✅ Option B: Local file `file:demo-image.png`
- ✅ Option C: Absolute path (backup if relative doesn't work)

Just uncomment whichever version you want to show!
