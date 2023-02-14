# SDFD10

Assessment for SDF Day 10

# TASK2 ASSUMPTIONS

- Assume wouldn't is wouldnt,and is a word unique from would i.e. ignore contractions
- Assume "strip all punctions from a word", and "-" implies that right-and-three-quarters is one word
- Assume number is not a word
- Assume “…” U+2026 to replace with space e.g.
  But you…You - you you
  that…Why - that why
- ignore spelling error e.g.
  You'll be on y our way up!
- Assume "’" U+2019 to be standard ASCII "'"

# NOTES

## Problem Strings

## Code for Testing

Path p = Paths.get(test);
File testFile = p.toFile();
readCorpus(allWords,testFile);

System.out.println(allWordsTable);

public static final String test = "C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\example.txt";

dirname: C:\Users\ftc_b\GIT\TFIP\SDFD10\day10_sdf_assets-main\sdf_assessment_assets\task02\seuss
C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\cat_in_the_hat.txt
"C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\fox_in_socks.txt";
"C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\happy_birthday_to_you.txt";
"C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\oh_the_places_youll_go.txt";
"C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\happy_birthday_to_you - Copy.txt";
"C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\example.txt";
