// Import FANG libraries
import fang2.core.Game
import fang2.sprites._
import java.awt.Color

// Simple standalone class to represent a bullet fired by the ship
//
// This helps in creating many bullets for the ship to fire
//   (See Chapter 10 for infrmation on case classes)
class crazy extends Game(1000,1000) {
case class Bullet(sprite : ImageSprite, dir: Double) {

  // Method in Bullet class to translate the bullet

def move = {
    // Find the new (x,y) coordinates of the Bullet
    val x = 0.03*math.cos(dir)
    val y = 0.03*math.sin(dir)
    // Move the Bullet
    sprite.translate(x,y)
    sprite.setScale(.04)
    // Hide the bullet if it is off the screen
    if (sprite.getX < 0 || sprite.getX > 1 || sprite.getY < 0 || sprite.getY > 1) sprite.hide
	if(sprite.intersects(cage)){
	cage.setLocation(-1.0,-1.0)
	score= score + 1
	setScore
	 }	
	if(sprite.intersects(kev)){
	kev.setLocation(-1.0,-1.0)
	score = score + 1
	setScore
	} 
	if(sprite.intersects(walla)){
	sprite.setLocation(-1.0,-1.0)
	}
	if(sprite.intersects(wallb)){
	sprite.setLocation(-1.0,-1.0)
	}
	if(sprite.intersects(wallc)){
	sprite.setLocation(-1.0,-1.0)
	}
	if(sprite.intersects(walld)){
	sprite.setLocation(-1.0,-1.0)
	}	
	if(sprite.intersects(walle)){
	sprite.setLocation(-1.0,-1.0)
	}
	if(sprite.intersects(wallf)){
	sprite.setLocation(-1.0,-1.0)
	}
	if(sprite.intersects(wallh)){
	sprite.setLocation(-1.0,-1.0)
	}
	if(sprite.intersects(wallg)){
	sprite.setLocation(-1.0,-1.0)
	}
 }
//the code above has the it so that when the bullet sprite intersects wit another sprite something will happen. For the ai's it will hide them and change their position. For the wall it will make the bullets hidden from the screen.
  // Set the location of a bullet
  def setLoc(x: Double, y: Double) = sprite.setLocation(x,y)
}


setMinimumModelFrameRate(120)
	var  backgroud: ImageSprite = null	
	var puck: ImageSprite = null
	var cage: ImageSprite = null
	var kev: ImageSprite = null
	var done: Boolean = false
	var speed: Double = 0.1
	var moving: Boolean = false
	var triDX: Double = 0.005
	var triDX1: Double = 0.004
        var scoreSprite: StringSprite = new StringSprite("Score: 0")
        var score: Int = 0
	var bullets: List[Bullet] = Nil
	val walla: RectangleSprite = new RectangleSprite(0.02,0.6)
	val wallb: RectangleSprite = new RectangleSprite(0.02,0.8)
	val wallc: RectangleSprite = new RectangleSprite(0.02,0.9)
	val walld: RectangleSprite = new RectangleSprite(0.02,0.5)
	val walle: RectangleSprite = new RectangleSprite(0.02,01.1)
	val wallf: RectangleSprite = new RectangleSprite(0.02,0.2)
	val wallg: RectangleSprite = new RectangleSprite(0.02,01.3)
	val wallh: RectangleSprite = new RectangleSprite(0.02,0.1)
	var tacoa: ImageSprite = null
	var tacob: ImageSprite = null
	var tacoc: ImageSprite = null
	var scorea: Int = 0
	var cup: ImageSprite = null
	val w: ImageSprite = new ImageSprite("win.jpg")
//All the variables and values that are going to be used throughout the game
def leveltwo{
	println("Level Two!")	
	triDX= 0.006
	triDX1=0.006
	walla.show	
	walla.setLocation(0.0,0.8)	
	wallb.show
	wallb.setLocation(1.0,0.8)        
	if(score <= 50){
	tacoa.show	
	tacoa.setLocation(0.9,0.1)
	if(score >=100){
		tacoa.hide}}	
	if(score >= 10){
	levelthree}
}  	
//level two will have the ai's move slightly faster and have one wall show up on the screen as well as the first taco.
def levelthree{
	println("Level Three!")	
	triDX = 0.008
	triDX1=0.008
	wallc.show
	wallc.setLocation(0.0,0.6)
	walld.show
	walld.setLocation(1.0,0.6)	
	if(score >= 50){
	tacob.show
	tacob.setLocation(0.9,0.5)
		if(score >=150){
		tacob.hide}}	
	if(score >= 20){
	levelfour
	}
	}
//level three with once again make the ai's slighly faster another wall will appear and another taco.
def levelfour{
	println("Level Four!")
	triDX = 0.01
	triDX1 = 0.01
	walle.show
	walle.setLocation(1.0,0.4)	
	wallf.show	
	wallf.setLocation(0.0,0.4)
	wallg.show
	wallg.setLocation(0.0,0.2)
	wallh.show
	wallh.setLocation(1.0,0.2)
	if (score >= 150){	
	tacoc.show
	tacoc.setLocation(0.1,0.1)
	if(score >=250){
		tacoc.hide}}	
	if(score >= 250){
	end
	}
}
//level three with once again make the ai's slighly faster more walls will appear and another taco, but this time when the taco is collect a new item will apppear which is the end game cup.
def end{
	println("Almost done get to the trophie!")
	cup.show
	cup.setLocation(0.05,0.5)
	if (score >= 1000){
	win
	}}
//hasthe cup appear on screen and when it is collected will call to the win defition
def win{
	println("YOU WIN!")
	w.show
	backgroud.hide
	cage.hide
	kev.hide
	puck.hide
	walla.hide
	wallb.hide
	wallc.hide
	walld.hide
	walle.hide
	wallf.hide
	wallg.hide
	wallh.hide
	tacoa.hide
	tacob.hide
	tacoc.hide
	cup.hide
	scoreSprite.hide
}
//Hides all the sprites when the cup is collected except the sprite that says winner!

   def setScore {
    scoreSprite.setText("Score: " + score) 
	if (score >= 5){
	leveltwo} }
//function to update the score
  override def setup {
backgroud = new ImageSprite("background.png")
puck = new ImageSprite("blake.png")
cage = new ImageSprite("cage.png")
kev = new ImageSprite("kev.png")
tacoa = new ImageSprite("Taco.PNG")
tacob = new ImageSprite("Taco.PNG")
tacoc = new ImageSprite("Taco.PNG")
cup = new ImageSprite("cup.PNG")
//sprites that will be used as the background, collectable, player or ai

backgroud.setLocation(0.50,0.50)

walla.setLocation (2.0,2.5)
walla.rotate(180.64)
walla.setColor(Color.red)
walla.hide

wallb.setLocation(3,3)
wallb.rotate(180.64)
wallb.setColor(Color.red)
wallb.hide

wallc.setLocation(4,4)
wallc.rotate(180.64)
wallc.setColor(Color.red)
wallc.hide

walld.setLocation(5,5)
walld.rotate(180.64)
walld.setColor(Color.red)
walld.hide

walle.setLocation(7,7)
walle.rotate(180.64)
walle.setColor(Color.red)
walle.hide

wallf.setLocation(6,6)
wallf.rotate(180.64)
wallf.setColor(Color.red)
wallf.hide

wallg.setLocation(8,8)
wallg.rotate(180.64)
wallg.setColor(Color.red)
wallg.hide

wallh.setLocation(9,9)
wallh.rotate(180.64)
wallh.setColor(Color.red)
wallh.hide
//makes each of the wall hidden off the screen with the color red.
puck.setScale(0.10)
puck.setLocation(0.50,0.90)
puck.setRotation(180.65)
//setting the puck(blakes head) to the center of the screen and scaling to size

cage.setLocation(0.50,0.10)
cage.setScale(0.10)
kev.setLocation(5.50,5.20)
kev.setScale(0.10)
//setting the ai's settings for the game


tacoa.setScale(0.04)
tacoa.setLocation(0.1,0.1)
tacoa.hide

tacob.setScale(0.04)
tacob.setLocation(1.5,2)
tacob.hide

tacoc.setScale(0.04)
tacoc.setLocation(1.75,2.5)
tacoc.hide

cup.setScale(0.04)
cup.setLocation(1.75,3.02)
cup.hide
//the four collectable items throughout the game

w.setLocation(0.5,0.5)
w.hide
//the win sprite to say winner!

addSprite(backgroud)
addSprite(cage)
addSprite(kev)
addSprite(puck)
addSprite(walla)
addSprite(wallb)
addSprite(wallc)
addSprite(walld)
addSprite(walle)
addSprite(wallf)
addSprite(wallg)
addSprite(wallh)
addSprite(tacoa)
addSprite(tacob)
addSprite(tacoc)
addSprite(cup)
addSprite(w)
//adding the sprites to the game


scoreSprite.setLocation(0.11,0.9)
    scoreSprite.setScale(0.1)
    setScore
    addSprite(scoreSprite) 
//sets the score sprite to the bottom left of the game


 // Set up the help text
    setHelpText("Welcome to Shenanigans! Stop Nicholas Cage and Kevin Costner from stealing your tacos! We all know the worst weapon in the world is Justin Bieber CD's, fire them at Nick and Kevin to scare them away! Use the arrows keys to chase after Kevin, Nick, and your tacos. More importantly, use the space bar to shoot the CD's! I know losing your tacos has you in an unstoppable rage, but do not forget that Nick and Kevin have some tricks up their sleeve's as well! Make sure you dodge them so they do not regress your progress! Lastly, do not forgot to grab your tacos! When they appear make sure you set your eye on getting that delicious pile of ground beef!  *Hint* Kevin and Nick will not so easily drop a taco, it should take an initial score of 5 to loosen them up! Oh and...beware the walls.")

}

 
 
 override def advance {

// Check for key pressed
   
	
if(walla.intersects(puck)){
	puck.setLocation(0.50,0.90)}
if(wallb.intersects(puck)){
	puck.setLocation(0.50,0.90)}
if(wallc.intersects(puck)){
	puck.setLocation(0.50,0.90)}
if(walld.intersects(puck)){
	puck.setLocation(0.50,0.90)}
if(walle.intersects(puck)){
	puck.setLocation(0.50,0.90)}
if(wallf.intersects(puck)){
	puck.setLocation(0.50,0.90)}
if(wallh.intersects(puck)){
	puck.setLocation(0.50,0.90)}
if(wallg.intersects(puck)){
	puck.setLocation(0.50,0.90)}
//when the player intersects any wall the player will be reset back to the starting position

def moveCage {
    cage.translateX(triDX1)
    if (cage.getX <= 0.0) {
      // It hit the left wall - go other direction
      cage.setLocation(0.0, math.random)    // Place it on left wall
      triDX1 = -triDX1   // Move in opposite direction
    } else if (cage.getX >= 1.0) {
      // It hit the right wall - go other direction
      cage.setLocation(1.0, math.random)    // Place it on right wall
      triDX1 = -triDX1   // Move in opposite directin
    }
  }


def moveKev {
    kev.translateX(triDX)
    if (kev.getX <= 0.0) {
      // It hit the left wall - go other direction
      kev.setLocation(0.0, math.random)    // Place it on left wall
      triDX = -triDX   // Move in opposite direction
    } else if (kev.getX >= 1.0) {
      // It hit the right wall - go other direction
      kev.setLocation(1.0, math.random)    // Place it on right wall
      triDX = -triDX   // Move in opposite directin
    }
  }
//function to have the ai randomly pick rows to move from across the screen
//stops them at each wall and then will pick a new row
moveCage
moveKev
   
      if (done != true) {
      // Move the player left (but not off the screen)
       if (leftPressed && (puck.getX > 0.10)){
        puck.translateX(-speed)
      // Move the player right (but not off the screen)
     } else if (rightPressed && (puck.getX < 0.90))
        puck.translateX(speed) 
	else if (upPressed && (puck.getY>0.1))
	puck.translateY(-speed)
	else if (downPressed && (puck.getY<.9))
	puck.translateY(speed)	
	//sets the arrow key controls for the player		
	else if (keyPressed && getKeyPressed == 'b'){
	score = score + 1
	setScore}	
	//if the player hits the b key they will cheat making their 		score go up by 1 point
	if (keyPressed && getKeyPressed == ' ') {
      // Make a new Bullet
      val b = new Bullet(new ImageSprite("bullet.png"), puck.getRotation)
      // Set the Bullet location to the cennter of the ship
      b.setLoc(puck.getX,puck.getY)
      // Add the Bullet to list, and to the game
      bullets = b::bullets
      addSprite(b.sprite)
    }
 // Move any Bullets in the list (until they leave the screen
    if (bullets != null) {
      // Use a higher-order function to split the list into
      // visible and not-visible Lists.
      val (b1,b2) = bullets.partition((x: Bullet) => {
          x.move
          x.sprite.isVisible
        })
      // Save the visible Bullets back in bullets
      bullets = b1
      // Remove the Bullets no longer visible
      b2.foreach((x: Bullet) => removeSprite(x.sprite))
	
}    
	}
if (puck.intersects(kev)){
	score = score - 2
	setScore
	puck.setLocation(0.50,0.90)
	kev.setLocation(0.50,0.20)}
if (puck.intersects(cage)){
	score = score - 2
	setScore
	puck.setLocation(0.50,0.90)
	cage.setLocation(0.50,0.10)}
//makes it so that when the player intersects with one of the ai's they will be set back to the original postion and the ai will be more to another position
if(tacoa.intersects(puck)){
	score = score + 100	
	setScore	
	tacoa.setLocation(2,5)
	tacoa.hide
	
}
if(tacob.intersects(puck)){
	score = score + 100	
	setScore	
	tacob.setLocation(2,5)
	tacob.hide
	
}
if(tacoc.intersects(puck)){
	score = score + 100	
	setScore	
	tacoc.setLocation(2,5)
	tacoc.hide
	
}
//sets it so that if the player hits a taco the player will "collect" the taco gaining 100 points and hiding the taco sprite
if(puck.intersects(cup)){
	score = score + 1000
	setScore
	cup.setLocation(5,8)
	cup.hide}
//basically does the same thing as the taco sprites but the player gains 1000 points.

}
}
 
