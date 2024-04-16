# Music Visualiser Project

Name: Racheal Chen

Student Number: C22338873

<<<<<<< HEAD
Name: Zannath

Student Number: 

Name: Nikita

Student Number:

Name: Liutaurus

Student Number:


## NOTES
=======
Name: Zannath Min Dilruba Tasneem

Student Number: C21371071

Name: Nikita Verbitskiy

Student Number: D20123962

Name: Liutauras Bruozis

Student Number: C22506249


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
<<<<<<< HEAD
	
=======
>>>>>>> 7556433eaf5818b08c4d0bbc1c6dab6fc9c78a57

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment

# Instructions

# How it works

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

