# Music Visualiser Project
## Team Members:

Name: Racheal Chen
Student Number: C22338873

Name: Zannath Min Dilruba Tasneem
Student Number: C21371071

Name: Nikita Verbitskiy
Student Number: D20123962

Name: Liutauras Bruozis
Student Number: C22506249
	
=======

# Description of the assignment
In our project we decided on the song "Slow Dancing In The Dark" by Joji. The song is poignant and introspective. It explores themes of love, heartbreak, and vulnerability. The song is characterized by its haunting melody and emotional lyrics, which resonate with listeners on a deep level.
In this assignment we have been tasked to create audio visualisers for our chosen song. We aim to create visuals that are immersive and create a captivating experience that resonates with our audience on both a visual and emotional level. we attempt to convey the melancholic beauty and introspective mood, by synchronizing the visuals with the song's rhythm and dynamics.

# Instructions
We set up 4 separate packages for each of our audio visual java files. 
We are to import them into a main audio java file ( utilising switch cases) and then run the audio java file in a main.java.
We downloaded a mp3 format of our chosen song into the data folder where our visual files will retrieve the song.


# How it works 
### Zannath - Visual Name
### Liutauras - Visual Name
### Nikita - Visual Name
### Racheal Chen - Visual Name

# What I am most proud of in the assignment

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

## NOTES

- Remember to create your own branch to work on the project to prevent interference with others or the master branch
https://thenewstack.io/dont-mess-with-the-master-working-with-branches-in-git-and-github/
>>>>>>> 7556433eaf5818b08c4d0bbc1c6dab6fc9c78a57
- To add the repo files onto your system : go to bash/terminal and type in 
```
git clone https://github.com/C22338873/OOP-MusicVisual-2024
```
- To commit and push updated file 
```
git add .
git commit -m "updated something"
git push
```
- To run example code : go to Main.java and replace 'RotatingAudioBands' in the line below with the file you wish to run
```
processing.core.PApplet.runSketch(a, new RotatingAudioBands());
``` 
- Then in vsc terminal type (for Mac)
```
cd java
source mcompile.sh
source mrun.sh
```
- compile and run on windows
```
cd java
source compile.sh
source run.sh
```

