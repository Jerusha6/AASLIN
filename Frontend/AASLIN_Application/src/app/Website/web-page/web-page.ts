import { Component } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import { RouterLink } from '@angular/router';
import {MatIconModule} from '@angular/material/icon';
import { RouterLinkActive } from '@angular/router';
import { MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
@Component({
  selector: 'app-web-page',
  imports: [MatIconModule,MatGridListModule,MatCardModule,MatToolbarModule,RouterLink,RouterLinkActive,MatButtonModule],
  templateUrl: './web-page.html',
  styleUrl: './web-page.css'
})
export class WebPage {
AboutUs =`In a world marked by rapid technological advancements, dynamic economic shifts, and a
				constantly changing global landscape, navigating these transformations poses a considerable
				challenge for our people, clients, partners, and communities. At AASLIN Technologies, we are
				dedicated to pushing the limits of what is achievable. Drawing on our expertise, experience,
				and innovative ecosystem, we empower enterprises, individuals, and communities to forge a
				better future at an accelerated pace. Together, we strive to overcome obstacles by driving
				business transformation through our strengths—technology, talent, and a robust network of
				partners. Our unwavering commitment is directed towards a singular objective: ensuring that
				our clients achieve their future sustainable selves well ahead of schedule.`;
  backend=`A backend developer builds and maintains the server-side of websites and applications,
   focusing on the parts users don't see.`;

  frontend=`A front-end developer builds the parts of websites and applications that users see and interact with directly,
   using core languages like HTML, CSS, and JavaScript to create the visual interface.`;

  currentPosition = 0;
  cardWidth = 320; 

  nextSlide() {
    if (this.currentPosition > -(this.cardWidth * 2)) { 
      this.currentPosition -= this.cardWidth;
    }
  }

  prevSlide() {
    if (this.currentPosition < 0) {
      this.currentPosition += this.cardWidth;
    }
}
}
