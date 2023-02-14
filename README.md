# SDFD10

Assessment for SDF Day 10

# TASK2 ASSUMPTIONS

    Assume wouldn't is wouldnt,and is a word unique from would i.e. ignore contractions
    Assume "strip all punctions from a word", and "-" implies that right-and-three-quarters is one word
    Assume number is not a word

# NOTES

dirname: C:\Users\ftc_b\GIT\TFIP\SDFD10\day10_sdf_assets-main\sdf_assessment_assets\task02\seuss
C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\cat_in_the_hat.txt
"C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\fox_in_socks.txt";
"C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\happy_birthday_to_you.txt";
"C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\oh_the_places_youll_go.txt";
"C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\happy_birthday_to_you - Copy.txt";
"C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\example.txt";

## Problem Strings

But you…You - becomes you you
You'll be on y our way up! - spelling error

## Code for Testing

Path p = Paths.get(test);
File testFile = p.toFile();
readCorpus(allWords,testFile);

public static final String test = "C:\\Users\\ftc_b\\GIT\\TFIP\\SDFD10\\day10_sdf_assets-main\\sdf_assessment_assets\\task02\\seuss\\example.txt";
