# Tuesday March 31 Plan - JavaFX Continuation (Image and ImageView)

## Continuity Note from Thursday (March 26)
We ended Thursday by completing pane demonstrations and explicitly queuing this next step:
- "What we'll get into next is actually putting images onto the screen."
- We will continue from that exact handoff using `Image` and `ImageView`.

## Class Outcomes (By End of Session)
Students should be able to:
1. Explain the role of `Image` vs `ImageView` in JavaFX.
2. Load an image from a local file path or classpath resource.
3. Add `ImageView` to a pane and display it in a scene/stage.
4. Control basic display behavior (`fitWidth`, `fitHeight`, `preserveRatio`).
5. Troubleshoot common issues (bad path, missing file, blank window, wrong imports).

## 75-Minute Tuesday Flow

## 0:00-0:06 - Fast Restart and Context Bridge
- Re-anchor from last class:
  - Stage = window
  - Scene = container for visual graph
  - Pane = layout container for nodes
- Bridge sentence to use:
  - "Last class we learned how to place nodes onto panes and panes onto scenes. Today we use that same pipeline, but our node is now an image."
- Confirm that today is demo-heavy and practical.

## 0:06-0:18 - Demo 1: Smallest Working Image Example
- Instructor runs a minimal JavaFX class with one image on one pane.
- Students observe import set and object creation order.

Suggested demo structure:
1. `Image image = new Image("file:resources/dog.jpg");`
2. `ImageView view = new ImageView(image);`
3. `Pane root = new Pane(); root.getChildren().add(view);`
4. `Scene scene = new Scene(root, 500, 350);`
5. `stage.setScene(scene); stage.show();`

Instructional emphasis:
- `Image` loads data.
- `ImageView` is the visual node placed in the scene graph.

## 0:18-0:30 - Demo 2: Make the Image Behave in the Window
- Add formatting controls live:
  - `view.setFitWidth(300);`
  - `view.setFitHeight(220);`
  - `view.setPreserveRatio(true);`
  - Optional position: `view.setX(20); view.setY(20);`
- Show what happens when ratio is off vs on.

Checkpoint prompt:
- "If I resize the stage, what is fixed and what is scalable in this version?"

## 0:30-0:40 - Student Replication Sprint (Guided)
- Students reproduce Demo 1 with your guidance.
- They only need one valid image rendered.
- You circulate and quickly triage setup/path errors.

Quick triage script:
1. Verify imports are from `javafx.*`.
2. Verify image path starts with `file:` when using filesystem path.
3. Verify image file actually exists where the code expects it.
4. Verify class compiles and launch command is correct.

## 0:40-0:52 - Demo 3: Multi-Image Layout with GridPane
- Transition from single node to multiple nodes while reinforcing last class pane concepts.
- Create 2x2 image gallery with `GridPane`.
- Keep file names simple and predictable (`img1.jpg`, `img2.jpg`, etc.).

Instructional emphasis:
- Pane choice controls layout behavior.
- `GridPane` makes placement explicit (row/column).

## 0:52-1:02 - Demo 4: Safe Loading Pattern (Avoid Crashes)
- Show one broken path deliberately.
- Add a simple guard pattern:
  - If image fails, display a `Label` placeholder in same pane.
- Teach students to fail gracefully rather than stop progress.

## 1:02-1:10 - Semester Project Connection
- Tie directly to project expectations:
  - logos
  - icons
  - profile avatars
  - product/asset tiles
- Prompt:
  - "What one image-driven feature could your project show in Week 11?"

## 1:10-1:15 - Exit Check and Thursday Preview
- Exit checks (students answer in chat or verbally):
1. What is the difference between `Image` and `ImageView`?
2. Where do we add `ImageView` so it appears on screen?
3. Name one reason an image might not appear.
- Preview Thursday:
  - Event handling on image-related UI controls (buttons/menu interactions) and stronger layout composition.

## Instructor Demo Files to Prepare Before Class
1. `ImageDemoBasic.java` (single image on `Pane`)
2. `ImageDemoSizing.java` (fit width/height + preserve ratio)
3. `ImageGridDemo.java` (multi-image `GridPane`)
4. `ImageFallbackDemo.java` (missing image -> label fallback)

## Pre-Class Technical Checklist (10 minutes)
1. Confirm JavaFX project runs locally on instructor machine.
2. Put sample images in a known folder (`resources/` inside demo folder).
3. Run each demo once before class starts.
4. Keep one backup demo with no external image dependency (shapes + label) in case path issues consume time.

## Teaching Moves That Match Thursday Success
- Keep the class demonstration-forward (high visual feedback).
- Narrate object order repeatedly: `Image -> ImageView -> Pane -> Scene -> Stage`.
- Pause every 10-12 minutes for a one-question comprehension check.
- Favor one complete working example over multiple partial snippets.

## Risk Controls for Tuesday
- If many students are blocked by local setup:
  - Continue conceptual and live coding demos via instructor screen.
  - Shift student coding to pseudocode + import/path diagnostics.
  - Reserve hands-on execution for lab or Thursday follow-up.
- If time slips:
  - Preserve Demo 1, Demo 2, and exit check first.
  - Move GridPane gallery to Thursday.

## Optional 1-Slide Welcome Board Text
"Today: JavaFX Image + ImageView\n- Continue from Thursday's pane work\n- Put image nodes on screen\n- Resize and position images\n- Build a mini image gallery\n- Troubleshoot file path issues"
