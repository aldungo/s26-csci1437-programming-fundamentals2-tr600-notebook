# Image File Setup for Demos

## Quick Setup for Local Image Demos

When demonstrating local file loading in class, follow these steps:

### Option 1: Quick Download During Class (Recommended)

1. **Find any image online** (right-click → "Save image as...")
2. **Save it as:** `demo-image.png` 
3. **Save location:** This folder (`.instructor\chapter14\examples\`)
4. **Update the code:** Uncomment the local file line in any ImageDemo file

### Option 2: Pre-Download Before Class

Download these example images and save to this folder:

**Suggested sources:**
- JavaFX logo: https://openjfx.io/images/logo.png → Save as `demo-image.png`
- Any image from your computer
- Stock photos from: https://unsplash.com (free, no attribution needed)

### File Naming Convention

Use simple names without spaces:
- ✅ `demo-image.png`
- ✅ `sample.jpg`
- ✅ `test-pic.png`
- ❌ `my image.png` (spaces cause issues!)
- ❌ `Demo Image.PNG` (case sensitive on some systems)

---

## Using Local Images in Code

### Relative Path (Recommended):
```java
Image image = new Image("file:demo-image.png");
```
- File must be in **same folder** as your .java file
- Works on any computer once they clone the repo

### Absolute Path (Backup):
```java
Image image = new Image("file:D:/tamusa-github/s26/.../examples/demo-image.png");
```
- Full computer path
- Won't work on student computers (different paths!)

### Common Mistakes:
```java
// WRONG - Missing "file:" prefix
Image image = new Image("demo-image.png");  ❌

// WRONG - Using backslashes (Windows only)
Image image = new Image("file:C:\\images\\demo.png");  ❌

// CORRECT - Always use forward slashes!
Image image = new Image("file:C:/images/demo.png");  ✅
```

---

## For Students

Students should:
1. Download any image they want to use
2. Save it in their project folder where their .java files are
3. Use `"file:their-image-name.png"` in code
4. Make sure filename has no spaces
5. Check file extension matches (.png, .jpg, .gif)

---

## Quick Test

After adding a local image:

1. Open `ImageDemoBasic.java`
2. Comment out line with web image
3. Uncomment line with `file:demo-image.png`
4. Run the program
5. You should see your local image!

---

**Files in this folder:**
- `demo-image.png` ← **PUT YOUR DEMO IMAGE HERE** (you'll add this)
- `README-IMAGES.md` ← You are here!
- All ImageDemo*.java files have commented examples ready to use
