## Week 6 Summary

### Overview
Week 6 bridged the close of Exam 1 with the launch of Chapter 4. Lectures emphasized reusing Chapter 1–3 fundamentals while layering on math class utilities, randomness, and the character type. Students were urged to stay communicative, keep up with Blackboard deliverables, and start ideating for the semester project and optional Rowdy Hacks participation.

### Monday · 29 Sep 2025
- **Exam logistics & housekeeping** – Reminder that Exam 1 (covering Chapters 1–3) must be submitted by midnight; grades will follow. Assignment 1 is graded, Assignment 2 due next Monday, and Lab 5 (switch statements) due Tuesday. Students were asked to flag any Blackboard anomalies.
- **Semester project kickoff** – Project instructions (15 % of final grade) now posted. Students should brainstorm ideas through October and may leverage UTSA’s Rowdy Hacks hackathon for inspiration or team work. Final deliverable remains a working `Final.java` plus a one‑page reflection.
- **Chapter 4 introduction** – Transition discussion stressed retaining earlier syntax and logic while exploring math utility methods. Topics demonstrated live:
	- Trigonometric methods (`Math.sin`, `Math.cos`, `Math.tan`) with degree→radian conversions via `Math.toRadians`/`Math.toDegrees`.
	- Exponent methods (`Math.pow`, `Math.sqrt`, `Math.exp`, `Math.log`, `Math.log10`) and their ties to constants `Math.PI` and `Math.E`. Highlighted fractional exponents for roots (e.g., `Math.pow(27, 1.0/3)` for cube root).
	- Service methods (`Math.ceil`, `Math.floor`, `Math.round`, `Math.rint`, `Math.min`, `Math.max`, `Math.abs`) and combining them within larger expressions.
	- Randomness foundations: `Math.random()` returns `[0.0,1.0)`. Casting and scaling pattern `int x = (int)(Math.random() * n) + m;` yields integers in `[m, m + n - 1]`. Demoed ranges (0–10, 0–100, shifted 5–15, 10–20) and showed how casting truncates the scaled double.
- **Lab alignment** – Lab 6 (released after lecture) will focus on these Chapter 4 math techniques and random ranges.

### Wednesday · 1 Oct 2025
- **Knowledge check** – Class opened with a projectile-motion challenge requiring velocity/angle input, radian conversion, and method chaining inside `Math.pow` and `Math.sin`. Students also reasoned through a random range equation for 10–59.
- **Random review** – Replayed Monday’s range logic and emphasized interpreting expressions to find min/max bounds—critical for Lab 6.
- **Character type deep dive**
	- Literals use single quotes; demonstrated digits as characters vs numeric literals.
	- Escape sequences (`\n`, `\t`, `\"`, `\\`) for formatting within strings.
	- Unicode background: hexadecimal notation `\uXXXX`, range `\u0000`–`\uFFFF`, and conversions between chars and their numeric codes (e.g., `'A'` → 65, `'a'` → 97). Explored hexadecimal literals and implicit casting limits.
	- Character arithmetic: adding integers to chars to shift letters, summing character digits (e.g., `'2' + '3'` → 101), and outlining how to generate random uppercase/lowercase letters by pairing Unicode ranges with `Math.random`.
	- Comparisons: relational operators rely on Unicode values, enabling range tests like `'A' <= ch && ch <= 'Z'` for uppercase detection.
	- `Character` helper methods (`isDigit`, `isLetter`, `isLetterOrDigit`, `isUpperCase`, `isLowerCase`) introduced as cleaner alternatives to manual range checks.
- **Next steps preview** – Monday’s lecture will revisit key math/character examples before moving into strings. Lab 6 runs Wednesday evening; students should review notes beforehand.

### Action Items & Reminders
- Finish Lab 6 after reviewing random range patterns and character helpers.
- Assignment 2 due 6 Oct; monitor Blackboard for grading updates on Exam 1 and labs.
- Start semester project brainstorming; consider Rowdy Hacks participation for project inspiration or collaboration.
- Bring Chapter 4 questions (math methods, randomness, character operations) to the next class or office hours.
