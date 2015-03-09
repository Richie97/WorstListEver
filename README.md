# WorstListEver

You were up all night working on your game-changing reddit client. You cranked it out in no time flat with your leet coding skills and copious amounts of Red Bull. There is only one itsy-bitsy teeny-tiny small problem: when you scroll the list of posts it crawls along at only a few frames per second. Unfortunately, your users are not going to accept that. Your job is to fix the mess that you made last night and get things performing buttery smooth.

# Getting started

You just have to fork this repo to get started. The project is built with gradle and should import cleanly into Android Studio. When you are finished, create a pull request with your changes.

# Testing

In order to test how well you are doing, a script is provided that uses monkeyrunner and systrace to test the performance of scrolling the list. You can execute it simply by running `./gradlew bench`. This will output a score of how well the list performs (lower is better). You may have to adjust some parameters depending on your environment and the size and performance of your device. Check out the `bench` task in `app/build.gradle` for more details.

Note that systrace may not be enabled on all devices or may require root to do so. You can always use an emulator if you can't get your physical device to work.

# Judging

We will use the same test script that is in this repository to check your submission. If it performs well, we will also manually verify that it still looks the same and you aren't do anything tricky (Under no circumstances are you to put all the items in a ScrollView). TODO figure out what kinds of scores we are seeing on our "official test device"

# Prizes

TODO

# Resources

- http://developer.android.com/training/improving-layouts/smooth-scrolling.html
- http://www.curious-creature.com/docs/android-performance-case-study-1.html
