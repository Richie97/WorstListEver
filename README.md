# WorstListEver

Leaderboard: http://tiny.cc/bamg_wt

You were up all night working on your game-changing reddit client. You cranked it out in no time flat with your leet coding skills and copious amounts of Red Bull. There is only one itsy-bitsy teeny-tiny small problem: when you scroll the list of posts it crawls along at only a few frames per second. Unfortunately, your users are not going to accept that. Your job is to fix the mess that you made last night and get things performing buttery smooth.

# Getting started

You just have to clone this repo to get started. The project is built with gradle and should import cleanly into Android Studio. When you are finished, email a compiled .apk to bamg@willowtreeapps.com along with an archive of your source code.

# Testing

In order to test how well you are doing, a script is provided that uses monkeyrunner and systrace to test the performance of scrolling the list. You can execute it simply by running `./gradlew bench`. This will output a score of how well the list performs (lower is better). You may have to adjust some parameters depending on your environment and the size and performance of your device. Check out the `bench` task in `app/build.gradle` for more details.

Note that systrace may not be enabled on all devices or may require root to do so. You can always use an emulator if you can't get your physical device to work.

# Submission

Email a compiled .apk and an archive of your source code to bamg@willowtreeapps.com when you feel confident enough!  Then come by the WillowTree booth and we'll verify your score.

# Judging

We will use the same test script that is in this repository to check your submission. If it performs well, we will also manually verify that it still looks the same and you aren't doing anything tricky (for example, under no circumstances are you to put all the items in a ScrollView!). If your score appears to be prize-eligible, we will use an average of a number of runs as your final score.

# Prizes

The top three scores for the day will win an Android Series 5 blind box figure (leaderboard: http://tiny.cc/bamg_wt).  Along with that, everyone who scores > 37 (verified by our team) will get an awesome WillowTree sticker.  The best we've been able to get (on our reference device, a Nexus 4) is ~48, so try to beat that!

# Resources

- http://developer.android.com/training/improving-layouts/smooth-scrolling.html
- http://www.curious-creature.com/docs/android-performance-case-study-1.html
