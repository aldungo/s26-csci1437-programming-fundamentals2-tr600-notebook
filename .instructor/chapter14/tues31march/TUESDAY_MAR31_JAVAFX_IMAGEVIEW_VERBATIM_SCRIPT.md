# Tuesday March 31 Verbatim Script - JavaFX Image and ImageView

## Opening (2-3 minutes)
"Good afternoon, everyone. Last class we finished pane layouts and I told you our next step would be putting images onto the screen. Today is exactly that continuation."

"Keep this pipeline in your head all class: Image, then ImageView, then Pane, then Scene, then Stage. If one link is missing, nothing shows."

## Bridge from Prior Class (3 minutes)
"On Thursday, we practiced stage versus scene and how panes hold nodes. Today, our node is an image node."

"Image loads the picture data. ImageView is what actually displays it as a node in the scene graph."

## Demo 1 Narration - First Working Image (12 minutes)
"I am starting with the minimum working example. First, I create an Image object and point it to a file path."

"Second, I wrap it in ImageView. Third, I add that ImageView to a Pane. Fourth, Pane goes into a Scene. Fifth, Scene goes on the Stage, then show."

"Notice the order. I can create these objects in many styles, but conceptually this order is always what makes it visible."

"If you remember nothing else, remember this: loading data is not the same as displaying a node. Image loads, ImageView displays."

## Demo 2 Narration - Sizing and Position (12 minutes)
"Now I want the image to behave nicely in the window. I will set fit width and fit height."

"If preserveRatio is false, we can stretch and distort it. If preserveRatio is true, the image scales naturally."

"I can also set X and Y to control where the image sits in the pane."

"This directly connects to what we said about scene versus stage sizing last class. The stage can grow, but node behavior depends on how we configure the node and container."

## Student Replication Sprint (10 minutes)
"Your turn: replicate my first demo with one image only. Do not add extra complexity yet."

"If it does not display, check in this order: imports, path prefix, file location, then compile/run command."

"Goal is one visible image, not a perfect app yet."

## Demo 3 Narration - Mini Image Gallery with GridPane (12 minutes)
"Now we extend from one image to multiple images. Same concept, new layout pane."

"GridPane gives us explicit row and column control, so this is a clean way to build a small gallery."

"Pay attention to what changed and what stayed the same: pane type changed, but image-to-node-to-scene pipeline is unchanged."

## Demo 4 Narration - Safe Fallback (10 minutes)
"I am now breaking one path on purpose. This is a realistic bug."

"Instead of crashing our momentum, we fail gracefully: if image load fails, we show a text label placeholder in the same area."

"This is a strong software habit for your semester project: controlled failure, visible feedback, keep moving."

## Project Tie-In (6 minutes)
"Think ahead to your semester project. Where would you use images? Logos, avatars, icons, thumbnails, item cards."

"Type in chat one image-based feature your group can implement this week."

## Close and Exit Check (5 minutes)
"Before we close, answer these three checks:"
1. "What is the difference between Image and ImageView?"
2. "Where do you add ImageView so it appears on screen?"
3. "What is one common reason an image does not appear?"

"Excellent work today. Thursday we continue by combining these visuals with more interaction and cleaner layout structure."
